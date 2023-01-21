package com.beniregev.demos_and_tutorials.demos.java_test;

/**
 * What will be the output of running the following code?
 * A) Error in line 16 [at: this.stop()]
 * B) Print:
 *    Before start method
 *    After stop method
 * C) Print:
 *    Before start method
 * D) Error in line 11 [at: ThreadDemo a = new ThreadDemo();]
 */
public class ThreadDemo extends Thread {
    public void run() {
        System.out.println("Before start method");
        this.stop();
        System.out.println("After stop method");
    }
    public static void main(String[] args) {
        ThreadDemo a = new ThreadDemo();
        a.start();
    }
}
