package Java.concurrency.parallelstreams;

import java.util.Arrays;
import java.util.Random;

public class ParallelStreams {
    public static void main(String[] args) {
        int numberLength =  100_000;
        long[] numbers =  new Random().longs(numberLength, 1, numberLength).toArray();

        long start = System.nanoTime();
        double averageSerial = Arrays.stream(numbers).average().orElseThrow();

        long elapsedSerial = System.nanoTime() - start;

        System.out.printf("Ave = %.2f, elapsed = %d nanos%n", averageSerial, elapsedSerial);
    }
}
