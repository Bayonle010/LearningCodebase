package Algorithm.binarySearch;

public class SearchInRotatedArray {
    public static void main(String[] args) {
        int [] rotatedArray = {4, 5, 6, 7, 0, 1 ,2};
        int [] rotatedArray2 = {1};
        System.out.println(searchInRotatedArray(rotatedArray, 0));
        System.out.println(searchInRotatedArray(rotatedArray, 3));
        System.out.println(searchInRotatedArray(rotatedArray2, 0));



    }

    static int searchInRotatedArray(int[] array, int target){
        int peakIndex = peakIndex(array);
        if (array[peakIndex] == target){
            return peakIndex;
        }

        int leftSearch = binarySearchInAscOrder(array, target, 0, peakIndex - 1);
        if (leftSearch != -1){
            return  leftSearch;
        }

        return binarySearchInAscOrder(array, target, peakIndex + 1, array.length -1 );

    }

    private  static int peakIndex(int[] array){
        int start = 0;
        int end = array.length -1;

        while (start < end){
            int mid = start + (end - start) / 2;

            if (array[mid] > array[mid + 1]) {
                return mid; // found pivot directly
            }

            if (array[mid] >= array[start]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return array.length -1;
    }

    static int binarySearchInAscOrder(int[] array, int target, int start, int end){
        while (start <= end){
            int mid = start + (end - start)/2;
          if (array[mid] < target){
                start = mid + 1;
          }else if (array[mid] > target){
                end = mid -1;
          }else{
              return mid;
          }
        }

        return  -1;
    }


    //
    static int searchInRotatedArraySecondMethod(int[] nums, int target){

        return -1;
    }
}
