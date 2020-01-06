package com.beniregev.demos_and_tutorials.examples.multithreading.threadpool;

/**
 * In Java: 1 Java Thread = 1 OS Thread
 * If we want to run 0..1000 JVM will create 1000 threads and since creating
 * a thread in itself is an expensive operation, What we rather want is to have
 * a fixed number of thread -- look at the following example.
 *
 * @author Binyamin Regev
 * @since 1.8
 * @see ThreadPoolAppExample03
 */
public class ThreadPoolAppExample02 {
    static class Task02 implements Runnable {
        private int code;
        public Task02(int code) {
            this.code = code;
        }

        public void run() {
            System.out.println("^^ (" + this.code + ") Thread Name: " + Thread.currentThread().getName());  //  Thread Name: main
        }
    }

    public static void main(String[] args) {
        for (int i=0; i< 10; i++) {
            Thread thread = new Thread(new Task02(i));
            thread.start();
        }
        System.out.println(">> Thread Name: " + Thread.currentThread().getName());  //  Thread Name: Thread-0
    }
}
