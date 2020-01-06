package com.beniregev.demos_and_tutorials.examples.mapdb;

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
    private Thread invokingThread;
    private String agentName;
    private List<String> listOfCalls = new ArrayList<>();

    public ThreadLevel2(Thread invokingThread, String  agentName, List<String> listOfCalls, int overallBulks) {
        this.segmentsList = new ArrayList<String>(overallBulks);
        this.invokingThread = invokingThread;
        this.agentName = agentName;
        this.listOfCalls = listOfCalls;
    }

    @Override
    public synchronized void run() {
        System.out.println(">> ThreadLevel1.run()");
        System.out.println("agentName: " + this.agentName);
        for (String callTime : listOfCalls) {
            System.out.println("\t" + callTime);
        }
        System.out.println("-------------------------------------------------");

    }

    public void create(boolean runInSeparateThread) {
        System.out.println("> ThreadLevel1.create(" + runInSeparateThread + ")");
        if (runInSeparateThread) {
            new Thread(this, "CreateDataThread").start();
        }
        else {
            run();
        }
    }
}
