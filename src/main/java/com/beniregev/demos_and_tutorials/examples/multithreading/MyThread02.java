package com.beniregev.demos_and_tutorials.examples.multithreading;

/**
 * <ol>
 *     <li>Create a {@code Thread} class implementing {@link Runnable} interface.</li>
 *     <li>Override {@code run()} method.</li>
 *     <li>Create object of the class.</li>
 *     <li>Invoke {@code start()} method using the object.</li>
 * </ol>
 */
public class MyThread02 implements Runnable {
    public void run() {
        System.out.println("Benny's Thread implementing Runnable interface...");
    }

    public static void main(String[] args) {
        Thread t = new Thread(new MyThread02());
        t.start();
    }
}
