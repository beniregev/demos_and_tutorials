package com.beniregev.demos_and_tutorials.examples.mapdb.threads;

import org.mapdb.HTreeMap;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Equavalent to {@code BacklogPolicy} class in {@code Injector}
 * @author Binyamin Regev e-mail: beniregev@gmail.com
 * @since 1.8
 */
public class ThreadLevel1 implements Runnable {
    private static List<String> listOfStrings;
    private List<LocalDateTime> listOfCallsPerAgent;
    private long numberOfSegments;
    private boolean runInSeparateThread;
    private String agentName;
    private int index;

    public ThreadLevel1(String agentName, List<LocalDateTime> listOfCallsPerAgent, long numberOfSegments, boolean runInSeparateThread, int index) {
        this.agentName = agentName;
        this.listOfCallsPerAgent = listOfCallsPerAgent;
        this.numberOfSegments = numberOfSegments;
        this.runInSeparateThread = runInSeparateThread;
        this.index = index;

    }

    @Override
    public void run() {
        System.out.println(">> ThreadLevel1.run() --> " + this.index);
        System.out.println("Agent Name = " + this.agentName);
        System.out.println("listOfCallsPerAgent.size() = " + listOfCallsPerAgent.size());
        System.out.println("numberOfSegments = " + this.numberOfSegments);
        System.out.println("runInSeparateThread = " + runInSeparateThread);
        System.out.println("-------------------------------------------------");
        int callIndex = 1;
        for (LocalDateTime callDateTime : listOfCallsPerAgent) {
            Thread threadLevel2 = new Thread(new ThreadLevel2(this.agentName, callDateTime, callIndex));
            threadLevel2.start();
            callIndex ++;
        }
    }

}
