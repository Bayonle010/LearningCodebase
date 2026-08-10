package Java.concurrency;

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
    public static void main(String[] args) {

        Thread worker = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Worker: " + i);
            }
        });

        worker.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("Main: " + i);
        }
    }
}
