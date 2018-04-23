package edu.kse.threadingpractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Worker {

    private static final Random RANDOM = new Random();

    private final Object LOCK1 = new Object();
    private final Object LOCK2 = new Object();

    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    public void stage1() {
        synchronized (LOCK1){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(RANDOM.nextInt());
        }
    }

    public void stage2() {
        synchronized (LOCK2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(RANDOM.nextInt());
        }
    }

    public void process(){
        for (int i = 0; i < 1000; i++) {
            stage1();
            stage2();
        }
    }

    public void startWork(){

        Thread t1 = new Thread(this::process);
        Thread t2 = new Thread(this::process);

        long start = System.currentTimeMillis();

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("Worker spend " + (end - start) + " ms.");
        System.out.println("list1 = " + list1.size());
        System.out.println("list2 = " + list2.size());
    }
}
