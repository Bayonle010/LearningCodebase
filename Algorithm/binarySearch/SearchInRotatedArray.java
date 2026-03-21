package Algorithm.binarySearch;

public class SearchInRotatedArray {
    public static void main(String[] args) {
        int [] rotatedArray = {4, 5, 6, 7, 0, 1 ,2};
        System.out.println(searchInRotatedArray(rotatedArray, 0));

    }

    static int searchInRotatedArray(int[] array, int target){
        int peakIndex = peakIndex(array);
        if (peakIndex == target){
            return peakIndex;
        }

        int leftSearch = binarySearchInAscOrder(array, target, 0, peakIndex - 1);
        if (leftSearch != -1){
            return  leftSearch;
        }else {
            return binarySearchInAscOrder(array, target, peakIndex + 1, array.length -1 );
        }
    }

    private  static int peakIndex(int[] array){
        int start = 0;
        int end = array.length -1;

        while (start < end){
            int mid = start + (end - start)/2;

            if (array[mid] < array[mid +1]){
                start = mid + 1;
            }else if (array[mid] > array[mid + 1]){
                end = mid;
            }else {
                return mid;
            }
        }

        return start;
    }

    static int binarySearchInAscOrder(int[] array, int target, int start, int end){
        while (start < end){
            int mid = start + (end - start)/2;
          if (array[mid] < target){
                start = mid +1;
          }else if (array[mid] > target){
                end = mid;
          }else{
              return mid;
          }
        }

        return  -1;
    }
}
