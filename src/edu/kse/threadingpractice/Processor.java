package edu.kse.threadingpractice;

public class Processor {

//    private static final Logger LOGGER = Logger.getLogger("THREADING LOGGER");

    private static volatile int value = 0;

    public static void execute() {
        new ChangeListener().start();
        new ChangeMaker().start();
    }

    static class ChangeListener extends Thread {
        @Override
        public void run() {
            int oldValue = value;
            while ( oldValue < 5){
                if( oldValue != value){
//                    LOGGER.log(Level.INFO,"Got Change for value : {0}", value);
                    System.out.println("ChangeListener : value has been changed to " + value);
                    oldValue = value;
                }
            }
        }
    }

    static class ChangeMaker extends Thread{
        @Override
        public void run() {
            while (value < 5){
//                LOGGER.log(Level.INFO, "Incrementing value to {0}", local_value+1);
                System.out.printf("ChangeMaker    : change value from %d to %d\n", value, ++value);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }
}
