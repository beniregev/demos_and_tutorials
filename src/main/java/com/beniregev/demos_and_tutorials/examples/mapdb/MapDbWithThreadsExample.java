package com.beniregev.demos_and_tutorials.examples.mapdb;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MapDbWithThreadsExample {
    private static final int NUMBER_OF_AGENTS = 1000;
    private static final int CALLS_PER_DAY = 22;
    private static final int NUMBER_OF_DAYS = 5;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final int SECONDS_PER_HOUR = 3_600;
    private static final int MINUTES_PER_HOUR = 60;
    private static final int MINUTES_PER_DAY = 1_440;
    private static final int HOURS_PER_DAY = 24;

    List<String> firstNames = generateNames("..\\demos_and_tutorials\\input\\first-names.txt");
    List<String> lastNames = generateNames("..\\demos_and_tutorials\\input\\last-names.txt");
    List<String> middleNames = generateNames("..\\demos_and_tutorials\\input\\middle-names.txt");

    public static void main(String[] args) {
        MapDbWithThreadsExample example = new MapDbWithThreadsExample();

        System.out.println("First Names size() = " + example.getFirstNames().size() + "\n" +
                "Middle Names size() = " + example.getMiddleNames().size() + "\n" +
                "Last Names size() = " + example.getLastNames().size()
        );

        DB dbAgentsNames = DBMaker.fileDB("agentsNames.db")
                .cleanerHackEnable()
                .closeOnJvmShutdown()
                .make();
        HTreeMap<String, Integer> mapAgentsNames = example.generateListOfAgents(example.NUMBER_OF_AGENTS, 100, dbAgentsNames);
        System.out.println("mapAgentsNames.sizeLong() = " + mapAgentsNames.sizeLong());

    }

    private HTreeMap<String, Integer> generateListOfAgents(int numberOfAgents, double uniqueNamePercent, DB db) {
        //List<String> firstNames = generateNames("..\\demos_and_tutorials\\input\\first-names.txt");
        //List<String> lastNames = generateNames("..\\demos_and_tutorials\\input\\last-names.txt");
        //List<String> middleNames = generateNames("..\\demos_and_tutorials\\input\\middle-names.txt");

        //  numberOfFirstNames and numberOfLastNames is the same, since using Square Root to find them
        int numberOfFirstNames = (int)Math.sqrt((double)numberOfAgents) + 1;
        System.out.println("Number of First Names = " + numberOfFirstNames);

        HTreeMap mapAgentsNames = db.hashMap("mapAgentsNames").createOrOpen();
        long start = System.currentTimeMillis();
        int i=1;
        for(String firstName : firstNames) {
            int j=1;
            for (String lastName : lastNames) {
                mapAgentsNames.put(firstName + " " + lastName, 1);
                System.out.println("firstName=" + firstName + " ; lastName=" + lastName);
                j++;
                if (j > numberOfFirstNames) break;
            }
            i++;
            if (i > numberOfFirstNames) break;
        }
        long end = System.currentTimeMillis();
        System.out.println("Generating a list of " + numberOfAgents +
                " agents names took " + (end - start) + " milliseconds");

        return mapAgentsNames;
    }

    private List<String> generateNames(String path) {
        List<String> names = new ArrayList<>();
        BufferedReader bufferReader = null;
        try {
            bufferReader = new BufferedReader(new FileReader(path));
            String line = null;
            while ((line = bufferReader.readLine()) != null) {
                names.add(line);
            }

        } catch (FileNotFoundException fnfe) {
            System.out.println("FileNotFoundException: " + fnfe.getMessage());
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            System.out.println("IOException: " + ioe.getMessage());
            ioe.printStackTrace();
        } finally {
            if (bufferReader != null) {
                try {
                    bufferReader.close();
                } catch (IOException ioe) {
                    System.out.println("Error while trying to close reader, IOException: " + ioe.getMessage());
                    ioe.printStackTrace();
                }
            }
        }
        return names;
    }

    public List<String> getFirstNames() {
        return firstNames;
    }

    public void setFirstNames(List<String> firstNames) {
        this.firstNames = firstNames;
    }

    public List<String> getLastNames() {
        return lastNames;
    }

    public void setMiddleNames(List<String> middleNames) {
        this.middleNames = middleNames;
    }

    public List<String> getMiddleNames() {
        return middleNames;
    }

    public void setLastNames(List<String> lastNames) {
        this.lastNames = lastNames;
    }

}
