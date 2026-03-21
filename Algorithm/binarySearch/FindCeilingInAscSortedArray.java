package Algorithm.binarySearch;

public class FindCeilingInAscSortedArray {
    //<<------------ INTERVIEW QUESTION --------->>
    // 1.  Ceiling : is the least number in an array greater than or equal to target number
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
