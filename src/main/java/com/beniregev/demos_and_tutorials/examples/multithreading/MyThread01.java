package com.beniregev.demos_and_tutorials.examples.multithreading;

/**
 * <ol>
 *     <li>Create a Thread class.</li>
 *     <li>Override {@code run()} method.</li>
 *     <li>Create object of the class.</li>
 *     <li>Invoke {@code start()} method to execute the custom threads {@code run()}.</li>
 * </ol>
 */
public class MyThread01 extends Thread {
    public void run() {
        System.out.println("Benny's MyThread class that extends Thread class");
    }

    public static void main(String[] args) {
        MyThread01 obj = new MyThread01();
        obj.start();
    }
}
