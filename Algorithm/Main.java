package Algorithm;

public class Main {
    public static void main(String[] args) {

        CheckTwoSum checkTwoSum = new CheckTwoSum();

        checkTwoSum.checkForTwoSum(new int[] {2,7,11,15},  9);

        System.out.println("------------->>>> next question");

        checkTwoSum.checkForTwoSum(new int[] {3,2,4},  6);

        System.out.println("------------->>>> next question");

        checkTwoSum.checkForTwoSum(new int[] {3,3},  6);


        System.out.println("----------->>>> hash map test begin");

        // HashMap samples

        checkTwoSum.checkForTwoSumUsingHashMap(new int[] {2,7,11,15},  9);

        System.out.println("------------->>>> next question");

        checkTwoSum.checkForTwoSumUsingHashMap(new int[] {3,2,4},  6);

        System.out.println("------------->>>> next question");

        checkTwoSum.checkForTwoSumUsingHashMap(new int[] {3,3},  6);

    }
}
