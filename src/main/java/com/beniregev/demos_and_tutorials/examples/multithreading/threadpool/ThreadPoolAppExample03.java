package com.beniregev.demos_and_tutorials.examples.multithreading.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <div>In Java: 1 Java Thread = 1 OS Thread</div>
 * <div>If we want to run 0..1000 JVM will create 1000 threads and since creating
 * a thread in itself is an expensive operation.</div>
 * <div>What we rather want is to have a fixed number of threads, say 10 threads,
 * we want to create them up front, let's call it a pool, a pool of threads, that's
 * where we get the name <i>ThreadPool</i> and let's submit 1000 tasks to them. And
 * then we want the thread to pick up those tasks, complete the tasks and move the
 * the next available task.</div>
 * <div>The way to code this is very simple as shown in this example:</div>
 * <div>For CPU intensive tasks we will set the number of threads depending on the
 * number of available processors</div>
 * @author Binyamin Regev
 * @since 1.8
 */
public class ThreadPoolAppExample03 {
    static class Task03 implements Runnable {
        public void run() {
            System.out.println("^^ Thread Name: " + Thread.currentThread().getName());  //  Thread Name: main
        }
    }

    public static void main(String[] args) {
        //
        //  Get the number of available processors
        int coreCount = Runtime.getRuntime().availableProcessors();
        //  Create the threads pool according to the number of available processors
        ExecutorService service = Executors.newFixedThreadPool(coreCount);
        //  Submit the tasks for execution
        for (int i=0; i < 1000; i++) {
            service.execute(new Task03());
        }
        System.out.println(">> Thread Name: " + Thread.currentThread().getName());  //  Thread Name: Thread-0
    }
}
