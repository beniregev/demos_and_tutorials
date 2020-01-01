package com.beniregev.demos_and_tutorials.examples.multithreading;

class Printer {
    //  Synchronizing the method will lock it from being used by other threads
    //synchronized void printDocument(int numOfCopies, String docName) {
    void printDocument(int numOfCopies, String docName) {
        for (int i=1; i <= numOfCopies; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(">> Pringting " + docName + " " + i);
        }

    }
}
class MyThread extends Thread {
    Printer pRef;

    MyThread(Printer p) {
        this.pRef = p;
    }

    @Override
    public void run() {
        //  Instead of using Synchronized keywork on printDocument method we can
        //  use a synchronized block. This is acquiring the lock as a block everywhere
        //  we use the synchronized block.
        synchronized (pRef) {
            pRef.printDocument(10, "CV Dr-Miri MD.pdf");
        }

    }
}

class YourThread extends Thread {
    Printer pRef;

    YourThread(Printer p) {
        this.pRef = p;
    }

    @Override
    public void run() {
        //  Instead of using Synchronized keywork on printDocument method we can
        //  use a synchronized block. This is acquiring the lock as a block everywhere
        //  we use the synchronized block.
        synchronized (pRef) {
            pRef.printDocument(10, "CV Benny Sr Java BE.pdf");
        }

    }
}

public class SyncApp04 {

    //  main is representing main thread
    public static void main(String[] args) {

        System.out.println("== Application Started ==");

        //  We have only a single object of Printer
        Printer printer = new Printer();
        //printer.printDocument(10, "CV Benny Sr Java BE.pdf");

        //  Scenario is that we have multiple thread working on the same Printer object
        //  If multiple Threads are going to work on the same single object we must Synchronize them
        MyThread mRef = new MyThread(printer);      //  MyThread is having a reference to the Printer object
        YourThread yRef = new YourThread(printer);  //  YourThread is having a reference to the Printer object

        mRef.start();

        //  Instead of invoking join() method we can use synchronized
        //  keyword in printDocument signature definition
        /*try {
            mRef.join();    //  Synchronization
        } catch (InterruptedException e) {
            e.printStackTrace();
        } */
        yRef.start();

        System.out.println("== Application Finished ==");

    }
}
