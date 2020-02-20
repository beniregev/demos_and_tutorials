package com.beniregev.demos_and_tutorials.examples.mapdb.threads;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Equivalent to {@code DataCreator} class in {@code Injector}
 *
 * @author Binyamin Regev e-mail: beniregev@gmail.com
 * @since 1.8
 */
public class ThreadLevel2 implements Runnable {
    private List<String> segmentsList;
    private List<LocalDateTime> listOfCalls = new ArrayList<>();
    private Thread invokingThread;
    private String agentName;
    private LocalDateTime callDateTime;
    private int callIndex;

    public ThreadLevel2(String agentName, LocalDateTime callDateTime, int callIndex) {
        this.agentName = agentName;
        this.callDateTime = callDateTime;
        this.callIndex = callIndex;
    }

    public ThreadLevel2(Thread invokingThread, String  agentName, List<LocalDateTime> listOfCalls, int overallBulks) {
        this.segmentsList = new ArrayList<String>(overallBulks);
        this.invokingThread = invokingThread;
        this.agentName = agentName;
        this.listOfCalls = listOfCalls;
    }

    @Override
    public synchronized void run() {
        MapDbWithThreadsExample.listOfStrings.add(this.agentName + "_" + this.callIndex);
        System.out.println(">> ThreadLevel2.run() --> \t" + this.callDateTime + "\t" + this.agentName
//                + "\n--------------------------------------------------------------------------------------------------"
        );
    }

    public void create(boolean runInSeparateThread) {
        System.out.println("> ThreadLevel2.create(" + runInSeparateThread + ")");
        if (runInSeparateThread) {
            new Thread(this, "CreateDataThread").start();
        }
        else {
            run();
        }
    }
}
