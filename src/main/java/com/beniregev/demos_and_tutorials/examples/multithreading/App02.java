package com.beniregev.demos_and_tutorials.examples.multithreading;

/*class MyTask {
    void executeTask() {
        for (int doc=1; doc <= 10; doc++) {
            System.out.println("@@ Printing Document #" + doc + " - Printer2");
        }
    }
} */

/**
 * MyTaskThread is a {@link Thread}
 */
class MyTaskThread extends Thread {

    @Override
    public void run() {
        for (int doc=1; doc <= 10; doc++) {
            System.out.println("@@ Printing Document #" + doc + " - Printer2");
        }
    }
}

/**
 * <div>Now, {@code main()} method (Job3) and {@link MyTaskThread#run()} method (Job2)
 * are executing in parallel, or concurrently.</div>
 * @author Binyamin Regev e-mail beniregev@gmail.com
 * @since 1.8
 * @see App01
 */
public class App02 {
    public static void main(String[] args) {

        //  Job1
        System.out.println("== Application Started ==");

        //  Job2
        MyTaskThread task = new MyTaskThread(); //  Child Thread / Worker Thread
        //task.executeTask();
        task.start();   //  --> start() will internally execute run method

        //  Job3
        for (int doc=0; doc<=10;doc++) {
            System.out.println("^^ Printing Document #" + doc + " - Printer1");
        }
        //  Job4
        System.out.println("== Application Finished ==");

    }
}
