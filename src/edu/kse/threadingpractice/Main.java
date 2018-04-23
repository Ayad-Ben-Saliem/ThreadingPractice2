package edu.kse.threadingpractice;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Processor.execute();
        Processor.execute();

    }

    public static void test1(){
        Runner runner1 = new Runner("R1");
        Runner runner2 = new Runner("R2");

        System.out.println("Press any key to exit\n");

        runner1.start();
        runner2.start();

        new Scanner(System.in).nextLine();
        runner1.shutdown();
        runner2.shutdown();
        System.out.println("Finish");
    }

    public static void test2() {

        Worker worker = new Worker();
        worker.startWork();

    }

    public static void stopThread(Runner runner){
        runner.running = false;
    }
}
