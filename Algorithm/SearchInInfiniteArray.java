package Algorithm;

public class SearchInInfiniteArray {
    // Search in an infinite array

    static int ans(int[] array, int target){
        int start = 0;
        int end = 1;

        while (target > array[end]){
            int newStart = end + 1;

            end = end + (end - start + 1) * 2;
            start = newStart;
        }

        return binarySearch(array, target, start, end);
    }

    static int binarySearch(int[] array, int target, int start, int end){
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
}
