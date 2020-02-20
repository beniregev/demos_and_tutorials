package com.beniregev.demos_and_tutorials.examples.jaxax_json_api;

import javax.json.*;
import java.io.StringReader;

public class JavaxJsonApiExample {
    private String personJSONData =
            "{ " +
                    "\"name\": \"Jack\", " +
                    "\"age\" : 13, " +
                    "\"isMarried\" : false, " +
                    "\"address\": { " +
                    "\"street\": \"#1234, Main Street\", " +
                    "\"zipCode\": \"123456\" " +
                    "}, " +
                    "\"phoneNumbers\": [\"011-111-1111\", \"11-111-1111\"] " +
                    " }";


    private void readJsonObjectWithArray() {
        JsonReader reader = Json.createReader(new StringReader(personJSONData));

        JsonObject personObject = reader.readObject();

        reader.close();

        System.out.println("Name   : " + personObject.getString("name"));
        System.out.println("Age    : " + personObject.getInt("age"));
        System.out.println("Married: " + personObject.getBoolean("isMarried"));

        JsonObject addressObject = personObject.getJsonObject("address");
        System.out.println("Address: ");
        System.out.println(addressObject.getString("street"));
        System.out.println(addressObject.getString("zipCode"));

        System.out.println("Phone  : ");
        JsonArray phoneNumbersArray = personObject.getJsonArray("phoneNumbers");
        for (JsonValue jsonValue : phoneNumbersArray) {
            System.out.println(jsonValue.toString());
        }
    }

    //private void readArray(String personJSONData) {
    //    JsonReader reader = Json.createReader(new StringReader(personJSONData));
    //    JsonArray personArray = reader.readArray();
    //    reader.close();
    //
    //
    //    for (JsonValue jsonVal : personArray) {
    //        System.out.println(jsonVal.getValueType() + " - "
    //                + ((JsonObject) jsonVal).getString("name"));
    //    }
    //}

    private void readJsonUsingCreateObjectBuilder() {
        JsonObject personObject = Json.createObjectBuilder()
                .add("name", "John")
                .add("age", 13)
                .add("isMarried", false)
                .add("address",
                        Json.createObjectBuilder().add("street", "Main Street")
                                .add("city", "New York")
                                .add("zipCode", "11111")
                                .build()
                )
                .add("phoneNumber",
                        Json.createArrayBuilder().add("00-000-0000")
                                .add("11-111-1111")
                                .add("11-111-1112")
                                .build()
                )
                .build();

        System.out.println("Object: " + personObject);

    }
    public static void main(String[] args) {
        JavaxJsonApiExample example = new JavaxJsonApiExample();
        example.readJsonObjectWithArray();
        //example.readArray(example.getPersonJSONData());
        example.readJsonUsingCreateObjectBuilder();

    }

    public String getPersonJSONData() {
        return personJSONData;
    }
}
