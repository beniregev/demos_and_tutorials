package com.beniregev.demos_and_tutorials.examples.multithreading;

/*class MyTask {
    void executeTask() {
        for (int doc=1; doc <= 10; doc++) {
            System.out.println("@@ Printing Document #" + doc + " - Printer2");
        }
    }
} */

/**
 * <div>MyTaskRunnable is a {@link Thread} implementing {@link Runnable} interface
 * and extending {@link JustAnotherClass} class.</div>
 */
class MyTaskRunnable extends JustAnotherClass implements Runnable {
    @Override
    public void run() {
        for (int doc=1; doc <= 10; doc++) {
            System.out.println("@@ Printing Document #" + doc + " - Printer2");
        }
    }
}

class JustAnotherClass {

}

/**
 * <div>Now, {@code main()} method (Job3) and {@link MyTaskRunnable#run()} method (Job2)
 * are executing in parallel, or concurrently.</div>
 * @author Binyamin Regev e-mail beniregev@gmail.com
 * @since 1.8
 * @see App01
 */
public class App03 {
    public static void main(String[] args) {

        //  Job1
        System.out.println("== Application Started ==");

        //  Job2
        //MyTaskThread task = new MyTaskThread(); //  Child Thread / Worker Thread
        //task.executeTask();
        //task.start();   //  --> start() will internally execute run method
        Runnable r = new MyTaskRunnable();
        Thread task = new Thread(r);
        task.start();

        //  Job3
        for (int doc=0; doc<=10;doc++) {
            System.out.println("^^ Printing Document #" + doc + " - Printer1");
        }
        //  Job4
        System.out.println("== Application Finished ==");

    }
}
