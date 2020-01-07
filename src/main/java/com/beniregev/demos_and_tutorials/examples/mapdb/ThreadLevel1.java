package com.beniregev.demos_and_tutorials.examples.mapdb;

import org.mapdb.HTreeMap;
import java.util.List;

/**
 * Equavalent to {@code BacklogPolicy} class in {@code Injector}
 * @author Binyamin Regev e-mail: beniregev@gmail.com
 * @since 1.8
 */
public class ThreadLevel1 implements Runnable {
    private HTreeMap mapAgentsNames;
    private List<String> listOfCallsPerAgent;
    private long numberOfSegments;
    private boolean runInSeparateThread;
    private String agentName;
    private int index;

    public ThreadLevel1(String agentName, List<String> listOfCallsPerAgent, long numberOfSegments, boolean runInSeparateThread, int index) {
        //public ThreadLevel1(Thread invokingThread, String  agentName, List<String> listOfCalls, int overallBulks) {
        this.agentName = agentName;
        this.listOfCallsPerAgent = listOfCallsPerAgent;
        this.numberOfSegments = numberOfSegments;
        this.runInSeparateThread = runInSeparateThread;
        this.index = index;

//        this.r = () -> {
//            System.out.println("^^ MapDbWithThreadsExample.main()");
//
//            long startTime = System.currentTimeMillis();
//            ThreadLevel1 threadLevel1 = new ThreadLevel1(Thread.currentThread(), agentName, listOfCallsPerAgent, OVERALL_BULKS);
//            threadLevel1.create(true);
//
//            long finishTime = System.currentTimeMillis();
//        };

    }

    public ThreadLevel1(HTreeMap mapAgentsNames, List<String> listOfCallsPerAgent, long numberOfSegments, boolean runInSeparateThread) {
    //public ThreadLevel1(Thread invokingThread, String  agentName, List<String> listOfCalls, int overallBulks) {
        this.mapAgentsNames = mapAgentsNames;
        this.agentName = null;
        this.listOfCallsPerAgent = listOfCallsPerAgent;
        this.numberOfSegments = numberOfSegments;
        this.runInSeparateThread = runInSeparateThread;

//        this.r = () -> {
//            System.out.println("^^ MapDbWithThreadsExample.main()");
//
//            long startTime = System.currentTimeMillis();
//            ThreadLevel1 threadLevel1 = new ThreadLevel1(Thread.currentThread(), agentName, listOfCallsPerAgent, OVERALL_BULKS);
//            threadLevel1.create(true);
//
//            long finishTime = System.currentTimeMillis();
//        };

    }

    @Override
    public void run() {
        System.out.println(">> ThreadLevel1.run() --> " + this.index);
//        System.out.println("mapAgentsNames.sizeLong() = " + mapAgentsNames.sizeLong());
        System.out.println("Agent Name = " + this.agentName);
        System.out.println("listOfCallsPerAgent.size() = " + listOfCallsPerAgent.size());
        System.out.println("numberOfSegments = " + this.numberOfSegments);
        System.out.println("runInSeparateThread = " + runInSeparateThread);
        System.out.println("-------------------------------------------------");
    }

//    public void create(boolean runInSeparateThread) {
//        System.out.println("> ThreadLevel1.create(" + runInSeparateThread + ")");
//        if (runInSeparateThread) {
//            new Thread(this, "CreateDataThread").start();
//        }
//        else {
//            run();
//        }
//    }

}
