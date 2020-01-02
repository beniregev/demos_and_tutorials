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
 * <div>For IO intensive tasks we will set the number of threads to a number that
 * suits both executing the IO tasks and later handling the OS side of the task,
 * keeping in mind the number of available processors. Exact number will depend
 * on rate of task submissions and average task wait time.</div>
 * <div>Too many thread will increase memory consumption too.</div>
 * @author Binyamin Regev
 * @since 1.8
 */
public class ThreadPoolAppExample04 {
    /**
     * <ul>Some IO operations:
     * <li>Retrieve/Insert/Update to database</li>
     * <li>HTTP(S) requests</li>
     * <li>Working with files: creating, reading or writing</li>
     * </ul>
     */
    static class Task04 implements Runnable {
        public void run() {

            System.out.println("^^ Thread Name: " + Thread.currentThread().getName());  //  Thread Name: main
        }
    }

    public static void main(String[] args) {
        //
        //  Get the number of available processors
        int coreCount = Runtime.getRuntime().availableProcessors();
        //  Create the threads pool according to the number of available processors
        ExecutorService service = Executors.newFixedThreadPool(coreCount * 25);
        //  Submit the tasks for execution
        for (int i=0; i < 1000; i++) {
            service.execute(new Task04());
        }
        System.out.println(">> Thread Name: " + Thread.currentThread().getName());  //  Thread Name: Thread-0
    }
}
