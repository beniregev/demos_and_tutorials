package com.beniregev.demos_and_tutorials.examples.multithreading.threadpool;

/**
 * Showing the difference between query Thread-Name in {@code main()} method
 * vs in {@Code Thread} {@code run()} method.
 * @author Binyamin Regev
 * @since 1.8
 */
public class ThreadPoolAppExample01 {
    static class Task01 implements Runnable {
        public void run() {
            System.out.println("^^ Thread Name: " + Thread.currentThread().getName());  //  Thread Name: main
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task01());
        thread1.start();
        System.out.println(">> Thread Name: " + Thread.currentThread().getName());  //  Thread Name: Thread-0
    }
}

