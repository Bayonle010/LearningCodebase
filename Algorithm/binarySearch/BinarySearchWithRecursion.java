package Algorithm.binarySearch;

public class BinarySearchWithRecursion {

    private static int binarySearchAlgorithmWithRecursion(int[] array, int target, int start, int end){
        if (start > end){
            return -1;
        }

        int m = start + (end - start)/2;
        if (array[m] == target){
            return m;
        }

        if (target < array[m]){
            return binarySearchAlgorithmWithRecursion(array, target, start, m-1);
        }
        return binarySearchAlgorithmWithRecursion(array, target, m+1, end);

    }

}
