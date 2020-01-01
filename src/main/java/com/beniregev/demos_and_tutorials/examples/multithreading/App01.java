package com.beniregev.demos_and_tutorials.examples.multithreading;

class MyTask {
    void executeTask() {
        for (int doc=1; doc <= 10; doc++) {
            System.out.println("@@ Printing Document #" + doc + " - Printer2");
        }
    }
}

/**
 * <div>Everything is executed in sequence, Till Job2 is
 * finished, Job3 & Job4 are waiting and are not executed.</div>
 * <div>In case Job2 is a long running operation, i.e. several
 * documents are suppose to be printed.</div>
 * <div>In such a use case OS/JVM shall give a message that the
 * app is not responding, some sluggish behavior is app can be
 * observed that the app seems to hang.</div>
 * <div>So instead of making {@link MyTask} a normal class, we
 * will make it into a {@link Thread}.</div>
 * @author Binyamin Regev e-mail beniregev@gmail.com
 * @since 1.8
 * @see App02
 */
public class App01 {
    public static void main(String[] args) {

        //  Job1
        System.out.println("== Application Started ==");

        //  Job2
        MyTask task = new MyTask();
        task.executeTask();

        //  Job3
        for (int doc=0; doc<=10;doc++) {
            System.out.println("^^ Printing Document #" + doc + " - Printer1");
        }
        //  Job4
        System.out.println("== Application Finished ==");

    }
}
