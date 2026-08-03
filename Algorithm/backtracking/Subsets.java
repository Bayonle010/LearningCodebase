package Algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int [] numbers = {1, 2};

        List<List<Integer>> result = new ArrayList<>();

        generateSubsets(
                numbers, 0, new ArrayList<>(), result
        );

        System.out.println(result);
    }

    static void generateSubsets(
            int[] numbers,
            int index,
            List<Integer> current,
            List<List<Integer>> result
    ){

        // Base case: all numbers have been considered
        if (index == numbers.length){
            result.add(new ArrayList<>(current));
            return;
        }

        // choice 1 : include the current number
        current.add(numbers[index]);

        generateSubsets(numbers, index+1, current, result);

        // Backtrack
        current.remove(current.size() -1 );

        generateSubsets(numbers, index+1, current, result);
    }
}
