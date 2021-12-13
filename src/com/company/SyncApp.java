package com.company;

import java.util.stream.IntStream;

public class SyncApp {
    public static void main(String[] args) {

        System.out.println("==Application Startet==");

        Printer printer = new Printer();
        //printer.printDocuments(10, "IshantsProfile.pdf");

        MyThread myThread = new MyThread(printer);
        YourThread yourThread = new YourThread(printer);

        myThread.start();
//        try {
//            myThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        yourThread.start();

        System.out.println("==Application Finished==");
    }
}

class MyThread extends Thread {
    Printer printer;

    MyThread(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        this.printer.printDocuments(10, "JohnsProfile.pdf");
    }
}

class YourThread extends Thread {
    Printer printer;

    YourThread(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        this.printer.printDocuments(10, "FionasProfile.pdf");
    }
}

class Printer {
    public void printDocuments(int numberOfCopies, String docName) {
        IntStream.range(1, numberOfCopies + 1).forEach(i -> {
            System.out.println(">> Printing" + docName + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    synchronized void printDocuments1(int numberOfCopies, String docName) {
        IntStream.range(1, numberOfCopies + 1).forEach(i -> {
            System.out.println(">> Printing" + docName + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
