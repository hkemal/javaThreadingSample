package com.company;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        System.out.println("==Application Startet==");

        MyTask myTask = new MyTask();
        //myTask.executeTask(); //1
        //myTask.start();       //2
        Runnable runnable = new MyTask();
        Thread task = new Thread(runnable);
        task.start();

        IntStream.range(1, 11 ).forEach(i -> System.out.println("^^ Printing Document #" + i + " - Printer1"));

        System.out.println("==Application Finished==");
    }
}

//class MyTask {
//    public void executeTask() {
//        IntStream.range(1, 11).forEach(i -> System.out.println("@@ Printing Document #" + i + " - Printer2"));
//    }
//}

//class MyTask extends Thread {
//    @Override
//    public void run() {
//        IntStream.range(1, 11).forEach(i -> System.out.println("@@ Printing Document #" + i + " - Printer2"));
//    }
//}

class CA {

}

class MyTask implements Runnable {
    @Override
    public void run() {
        IntStream.range(1, 11).forEach(i -> System.out.println("@@ Printing Document #" + i + " - Printer2"));
    }
}
