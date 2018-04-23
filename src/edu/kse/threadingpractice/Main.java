package edu.kse.threadingpractice;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        new SoundClipTest("/home/ayad/Downloads/piano2.wav");
    }


    public static void test1() {
        Runner runner1 = new Runner("R1");
        Runner runner2 = new Runner("R2");

        System.out.println("Press enter to exit\n");

        Thread t1 = new Thread(runner1);
        Thread t2 = new Thread(runner2);

        t1.start();
        t2.start();

        new Scanner(System.in).nextLine();
        runner1.shutdown();
        runner2.shutdown();
        System.out.println("Finish");
    }

    public static void test2() {

        Worker worker = new Worker();
        worker.startWork();

    }

    public static void test3() {
        Processor.execute();
        Processor.execute();
    }

    public static void test4(){
        Demo demo1 = new Demo("DEMO1");
        Demo demo2 = new Demo("DEMO2");

        Thread t1 = new Thread(demo1);
        Thread t2 = new Thread(demo2);

        t1.start();
        t2.start();
    }


    public static void demo(String name){

        System.out.println("Starting " + name + "...");
        for (int i = 0; i < 1000; i++) {
            System.out.println(name + " i = " + i);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finish " + name);
    }
}


class Demo implements Runnable{
    String name;

    public Demo(String name){
        this.name = name;
    }

    @Override
    public void run() {
        Main.demo(name);
    }
}
