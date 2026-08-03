package Algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};

        List<List<Integer>> result = new ArrayList<>();

        generatePermutations(
                numbers,
                new ArrayList<>(),
                new boolean[numbers.length],
                result
        );

        System.out.println(result);
    }

    static void generatePermutations(
            int[] numbers,
            List<Integer> current,
            boolean[] used,
            List<List<Integer>> result
    ) {
        // A complete permutation contains every number
        if (current.size() == numbers.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            // Skip numbers already used in this permutation
            if (used[i]) {
                continue;
            }

            // Choose
            current.add(numbers[i]);
            used[i] = true;

            // Explore
            generatePermutations(numbers, current, used, result);

            // Undo
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}