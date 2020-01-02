package com.beniregev.demos_and_tutorials.examples.multithreading.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * ScheduledThreadPool
 *
 * @author Binyamin Regev
 * @since 1.8
 */
public class ThreadPoolAppExample06 {
    static class Task06 implements Runnable {
        public void run() {
            //  Task that needs to run based on schedule
            System.out.println("^^ Thread Name: " + Thread.currentThread().getName());  //  Thread Name: main
        }
    }

    public static void main(String[] args) {
        //  For scheduling of tasks (pool of 10 threads)
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        //  Task to run after 10 seconds delay
        service.schedule(new Task06(), 10, SECONDS);
        //  Task to run repeatedly every 10 seconds
        service.scheduleAtFixedRate(new Task06(), 15, 10, SECONDS);
        //  Task to run repeatedly 10 seconds after previous task completes
        service.scheduleWithFixedDelay(new Task06(), 15, 10, SECONDS);

        System.out.println(">> Thread Name: " + Thread.currentThread().getName());  //  Thread Name: Thread-0
    }
}
