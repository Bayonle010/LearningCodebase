package Algorithm;

public class BinarySearchAlgorithm  {
    public static void main(String[] args) {
        int [] input = {2,4,6,8,9,10,12,14};
        System.out.println(
                findCeilingInAscSortedArray(input, 7)
        );

    }

    private static int binarySearchForAscSortedArray(int[] array, int target){
        int start = 0;
        int end = array.length -1;
        while (start<= end){
            int mid = start + (end -start)/2;
            if (target < array[mid]){
                end = mid -1;
            }else if (target > array[mid]){
                start = mid +1;
            }else {
                // target found
                return mid;
            }
        }
        return -1;
    }


    private static int unknownSortedOrderBinarySearch(int[] array, int target){
        int start = 0;
        int end = array.length -1;
        boolean isAscOrder = (array[start] < array[end]);

        while (start<= end){
            int mid = start + (end - start)/2;
            if (array[mid] == target) {return  mid;}
            if (isAscOrder){
                if (target < mid){
                    end = mid -1;
                }else{
                    start = mid + 1;
                }
            }else{
                if (target > array[mid]){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }


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


    // Ceiling is a number greater than or equal to target number
    private static int findCeilingInAscSortedArray(int[] array, int target){
        int start = 0;
        int end = array.length -1;
        while (start<= end){
            int mid = start + (end -start)/2;
            if (target < array[mid]){
                end = mid -1;
            }else if (target > array[mid]){
                start = mid +1;
            }else {
                // target found
                return mid;
            }
        }
        return start;
    }
}
