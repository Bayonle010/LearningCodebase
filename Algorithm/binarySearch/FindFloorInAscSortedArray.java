package Algorithm.binarySearch;

public class FindFloorInAscSortedArray {
    //<<------------ INTERVIEW QUESTION --------->>
    // 2.  Floor of a number :  is the greatest number in an array less than or equal to target number
    private static int findFloorInAscSortedArray(int[] array, int target){
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
        return end;
    }
}
