package com.beniregev.demos_and_tutorials.examples;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class LoadPropertiesFileExample {
    private final String JAVA_PROPERTIES = "jdbc.properties";
    private final String OUTPUT_PROPERTIES = "output.properties";
    private final int NEW = 1;
    private final int IN_PROGRESS = 2;
    private final int FIXED = 3;
    private final int RELEASED = 4;

    private InputStream input = null;
    private OutputStream output = null;

    public String getResourceFile(final String filename) {
        ClassLoader classLoader = getClass().getClassLoader();
        String resourceFile = classLoader.getResource(filename).getFile();
        return resourceFile;
    }

    private VehicleProperties stringToObject(String stringValue) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        VehicleProperties vehicleProperties = objectMapper.readValue(stringValue, VehicleProperties.class);
        return vehicleProperties;
    }

    public void runExample(String[] args) {
        Properties prop = new Properties();

        final String jdbcProperties = getResourceFile(JAVA_PROPERTIES);
        final String outputProperties = "d:/temp/datafiles/properties/" + OUTPUT_PROPERTIES;

        try {

            input = new FileInputStream(jdbcProperties);
            output = new FileOutputStream(outputProperties);

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println("jdbc.postgresql.connection.url = " + prop.getProperty("jdbc.postgresql.connection.url"));
            System.out.println("jdbc.postgresql.connection.driver_class = " + prop.getProperty("jdbc.postgresql.connection.driver_class"));
            System.out.println("jdbc.postgresql.connection.username = " + prop.getProperty("jdbc.postgresql.connection.username"));
            System.out.println("jdbc.postgresql.connection.password = " + prop.getProperty("jdbc.postgresql.connection.password"));
            System.out.println("jdbc.postgresql.connection.dbms = " + prop.getProperty("jdbc.postgresql.connection.dbms"));
            System.out.println("jdbc.postgresql.connection.hostname = " + prop.getProperty("jdbc.postgresql.connection.hostname"));
            System.out.println("jdbc.postgresql.connection.port = " + prop.getProperty("jdbc.postgresql.connection.port"));
            System.out.println("jdbc.postgresql.connection.database = " + prop.getProperty("jdbc.postgresql.connection.database"));

            Map<String, VehicleProperties> vehicles = new HashMap<>();
            vehicles.put("12345678", new VehicleProperties("12345678", "abcdefgh", 2018, NEW));
            vehicles.put("87123456", new VehicleProperties("12345678", "abcdefgh", 2018, IN_PROGRESS));
            vehicles.put("9876543", new VehicleProperties("12345678", "abcdefgh", 2016, FIXED));
            vehicles.put("9876542", new VehicleProperties("12345678", "abcdefgh", 2016, NEW));
            vehicles.put("6543210", new VehicleProperties("12345678", "abcdefgh", 2000, NEW));
            vehicles.put("6630704", new VehicleProperties("12345678", "abcdefgh", 1995, NEW));
            vehicles.put("6630404", new VehicleProperties("12345678", "abcdefgh", 1995, IN_PROGRESS));
            vehicles.put("1234582", new VehicleProperties("12345678", "abcdefgh", 1982, FIXED));
            vehicles.put("1245685", new VehicleProperties("12345678", "abcdefgh", 1985, FIXED));
            vehicles.put("5498788", new VehicleProperties("12345678", "abcdefgh", 1988, NEW));
            vehicles.put("654321", new VehicleProperties("12345678", "abcdefgh", 1968, IN_PROGRESS));

            Properties properties = new Properties();
            for (Map.Entry<String, VehicleProperties> vehicle : vehicles.entrySet()) {
                String key = vehicle.getKey();
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    String value = objectMapper.writeValueAsString(vehicle.getValue());
                    properties.setProperty(key, value);
                    System.out.println("key=\"" + key + "\", value=\"" + value + "\"");

                    VehicleProperties valueAsObject = stringToObject(value);
                    System.out.println("valueAsObject=" + valueAsObject);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            properties.store(output, "Store Property File Dynamically");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        (new LoadPropertiesFileExample()).runExample(args);
    }
}

class VehicleProperties {
    private String licensePlateNumber;
    private String description;
    private int year;
    //  1=New, 2=In Progress, 3=Fixed, 4=Released
    private int status;

    public VehicleProperties() {
    }

    public VehicleProperties(String licensePlateNumber, String description, int year, int status) {
        this.setLicensePlateNumber(licensePlateNumber);
        this.setDescription(description);
        this.setYear(year);
        this.setStatus(status);
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleProperties that = (VehicleProperties) o;
        return year == that.year &&
                status == that.status &&
                licensePlateNumber.equals(that.licensePlateNumber) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licensePlateNumber, description, year, status);
    }

    @Override
    public String toString() {
        return "propertiesVehicle{" +
                "licensePlateNumber='" + licensePlateNumber + '\'' +
                ", description='" + description + '\'' +
                ", year=" + year +
                ", status=" + status +
                '}';
    }
}