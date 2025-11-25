package Algorithm;

public class BinarySearchAlgorithm  {
    public static void main(String[] args) {
        int [] input = {-18,2,4,6,8,9};
        System.out.println(
                binarySearchForAscSortedArray(input, 8)
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
}
