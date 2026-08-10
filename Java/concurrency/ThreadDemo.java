package Java.concurrency;

public class ThreadDemo {

    public static void main(String[] args)
            throws InterruptedException {

        Thread worker1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.printf(
                        "%s -> %d%n",
                        Thread.currentThread().getName(),
                        i
                );
            }
        }, "worker-1");

        Thread worker2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.printf(
                        "%s -> %d%n",
                        Thread.currentThread().getName(),
                        i
                );
            }
        }, "worker-2");

        worker1.start();
        worker2.start();

        worker1.join();
        worker2.join();

        System.out.println("All workers finished");
    }
}