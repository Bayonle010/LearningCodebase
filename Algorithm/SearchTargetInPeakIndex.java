package Algorithm;

public class SearchTargetInPeakIndex {

    public static void main(String[] args) {
        int[] mountainArray = {1,2,3,4,5,3,1};

        System.out.println(
                findInMountainArray(3, mountainArray)
        );
    }



    public static int findInMountainArray(int target, int[] arr) {

        int peak =  peakIndexMountainArray(arr);
        System.out.println("peakIndex is : " + peak);

        int ansInAscArray = binarySearchForAscSoredAArray(arr, target, 0 , peak -1);
        if (ansInAscArray != -1 ){
            return ansInAscArray;
        }else {
            return binarySearchForDscSortedArray(arr, target, peak, arr.length -1 );
        }

    }

    public static int peakIndexMountainArray(int[]  arr){
        int start = 0;
        int end = arr.length -1;

        while (start < end){

            int mid = start + (end - start)/2;

            if (arr[mid] < arr[mid + 1]){

                start = mid + 1;

            } else {
                end = mid;
            }
        }

        return start; // or end

    }

    static int binarySearchForAscSoredAArray(int[] array, int target, int start, int end){
        while (start <= end){
            int mid = start + (end - start)/2;

            if (target < array[mid]){
                end = mid - 1;
            } else if (target > array[mid]) {
                start = mid + 1;

            }else{
                return mid;
            }
        }

        return -1;
    }

    private static int binarySearchForDscSortedArray(int[] array, int target, int start, int end){
        while (start<= end){
            int mid = start + (end -start)/2;
            if (target > array[mid]){
                end = mid -1;
            }else if (target < array[mid]){
                start = mid +1;
            }else {
                // target found
                return mid;
            }
        }
        return -1;
    }
}
