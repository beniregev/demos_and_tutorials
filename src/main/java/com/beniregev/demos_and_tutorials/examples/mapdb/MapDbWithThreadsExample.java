package com.beniregev.demos_and_tutorials.examples.mapdb;

import com.beniregev.demos_and_tutorials.examples.multithreading.threadpool.ThreadPoolAppExample02;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MapDbWithThreadsExample {
    private static final int OVERALL_BULKS = 1000;
    private static final int NUMBER_OF_AGENTS = 9;
    private static final int CALLS_PER_DAY = 22;
    private static final int NUMBER_OF_DAYS = 2;
    private static final int DURATION_OF_CALL_IN_MINUTES = 5;
    private static final int MINUTES_PER_DAY = 1_440;
    private static final LocalDate dateFrom = LocalDate.parse("2019-12-01");
    private static final LocalDate dateTo = LocalDate.parse("2019-12-05");

    private boolean runInSeparateThread;
    private Runnable r;

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

        System.out.println("ISO_LOCAL_DATE = " + dateFrom.format(DateTimeFormatter.ISO_LOCAL_DATE));

        List<String> listOfDates = example.generateListOfDates(dateFrom,dateTo);
        listOfDates.forEach(System.out::println);

        List<String> listOfCallsTimes = example.generateListOfCallsPerDay(CALLS_PER_DAY, DURATION_OF_CALL_IN_MINUTES);
        listOfCallsTimes.forEach(System.out::println);

        List<String> listOfCallsPerAgent = new ArrayList<>();
        for (String date : listOfDates) {
            for (String time : listOfCallsTimes) {
                listOfCallsPerAgent.add(date + " " + time);
            }
        }
        listOfCallsPerAgent.forEach(System.out::println);

        long numberOfSegments = NUMBER_OF_AGENTS * CALLS_PER_DAY * NUMBER_OF_DAYS;
        int index = 1;
        for (String agentName : mapAgentsNames.getKeys()) {
            Thread threadLevel1 = new Thread(new ThreadLevel1(agentName, listOfCallsPerAgent, numberOfSegments, true, index));
            threadLevel1.start();
            index++;
        }

    }

    private List<String> generateListOfDates(LocalDate dateFrom, LocalDate dateTo) {
        int numberOfDays = (int) ChronoUnit.DAYS.between(dateFrom, dateTo) + 1;
        List<String> list = IntStream.iterate(0, i -> i + 1)
                .limit(numberOfDays)
                .mapToObj(i -> dateFrom.plusDays(i).format(DateTimeFormatter.ISO_LOCAL_DATE))
                .collect(Collectors.toList());
        return list;
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

    private List<String> generateListOfCallsPerDay(int numberOfCallsPerDay, int durationOfCallInMinutes) {
        final int timeIntervalBetweenCallInMinutes = (MINUTES_PER_DAY - (durationOfCallInMinutes * (numberOfCallsPerDay + 1))) / (numberOfCallsPerDay + 1);

        //  For the first gap there's no need to add the call duration
        LocalTime timeCallStarted = LocalTime.MIN.plusMinutes(timeIntervalBetweenCallInMinutes);

        List<String> listOfCalls = new ArrayList<>();
        for (int i=1; i <= CALLS_PER_DAY ; i++) {
            listOfCalls.add(timeCallStarted.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
            System.out.println("Call #" + i + ": \n\tStarted at " + timeCallStarted +
                    "\n\tEnded at " + timeCallStarted.plusMinutes(durationOfCallInMinutes) +
                    "\n\tContact Start Time: " + timeCallStarted +
                    "\n\tContact End Time: " + timeCallStarted.plusSeconds(150)
            );
            timeCallStarted = timeCallStarted.plusMinutes(durationOfCallInMinutes).plusMinutes(timeIntervalBetweenCallInMinutes);
        }
        return listOfCalls;
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

    public List<String> getLastNames() {
        return lastNames;
    }

    public List<String> getMiddleNames() {
        return middleNames;
    }

}
