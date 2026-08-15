package Java.concurrency;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class Main {
//    public static void main(String[] args) {
//        System.out.println(
//                "Main : "  + Thread.currentThread().getName()
//        );
//
//        Thread worker = new Thread(
//                ()-> {
//                    System.out.println(
//                            "Worker : " + Thread.currentThread().getName()
//                    );
//                }
//        );
//
//        worker.start();
//    }
//    public static void main(String[] args) {
//
//        Thread worker = new Thread(() -> {
//            for (int i = 0; i < 5; i++) {
//                System.out.println("Worker: " + i);
//            }
//        });
//
//        worker.start();
//
//        for (int i = 0; i < 5; i++) {
//            System.out.println("Main: " + i);
//        }
//    }

            public static void main(String[] args) {
                Thread currentThread = new Thread();
                currentThread.setName("Main Guy");
                currentThread.setPriority(Thread.MAX_PRIORITY);
                printThreadState(currentThread);

                CustomThread customThread = new CustomThread();
                customThread.start();

                Runnable myRunnable = ()->{
                    for (int i =1; i<8 ; i ++){
                        System.out.println("2");

                        try {
                            TimeUnit.MILLISECONDS.sleep(250);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                };

                Thread myThread = new Thread(myRunnable);
                myThread.start();

                for (int i = 1; i<=3; i++){
                    System.out.println(" 0 ");

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }


            }

    public static void printThreadState(Thread thread){
        System.out.println("------------------------");
        System.out.println("Thread ID: " + thread.getId());
        System.out.println("Thread Name: " + thread.getName());
        System.out.println("Thread Priority: " + thread.getPriority());
        System.out.println("Thread State: " + thread.getState());
        System.out.println("Thread Group: " + thread.getThreadGroup());
        System.out.println("Thread Is Alive: " + thread.isAlive());
        System.out.println("------------------------------");
    }
}
