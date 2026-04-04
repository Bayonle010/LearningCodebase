package Java;

import java.util.ArrayList;
import java.util.List;

public class Streams {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        processData(nums);
    }

    static public void processData(List<Integer> nums){

        nums.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .forEach(System.out::print);
    }

}
