package edu.kse.threadingpractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Runner implements Runnable {

    private final String name;
    private boolean running = true;

    public Runner(){
        this(null);
    }

    public Runner(String name){
        this.name = name;
    }

    @Override
    public void run() {
        while (running){
            System.out.println(name + " is running ...");
            try {
                Thread.sleep(new Random().nextInt(500) + 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown(){
        running = false;
    }
}