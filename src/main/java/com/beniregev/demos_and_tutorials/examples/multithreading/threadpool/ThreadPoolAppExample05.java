package com.beniregev.demos_and_tutorials.examples.multithreading.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Binyamin Regev
 * @since 1.8
 */
public class ThreadPoolAppExample05 {
    static class Task05 implements Runnable {
        public void run() {
            //  Short lived task
            System.out.println("^^ Thread Name: " + Thread.currentThread().getName());  //  Thread Name: main
        }
    }

    public static void main(String[] args) {
        //  For a lot of short lived tasks
        ExecutorService service = Executors.newCachedThreadPool();
        //  Submit the tasks for execution
        for (int i=0; i < 1000; i++) {
            service.execute(new Task05());
        }
        System.out.println(">> Thread Name: " + Thread.currentThread().getName());  //  Thread Name: Thread-0
    }
}
