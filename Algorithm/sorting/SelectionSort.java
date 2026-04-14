package Algorithm.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {5,6,7,4,3,2,1};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    static void selectionSort(int[] array){

        for (int i = 0; i< array.length; i++){

            int lastIndex = array.length - i - 1;
            int maxIndex = getMaxIndex(array, 0, lastIndex);
            swap(array, maxIndex, lastIndex);
        }

    }

    static void swap(int[] array, int firstElement, int secondElement){
        int temp = array[firstElement];
        array[firstElement] = array[secondElement];
        array[secondElement] = temp;
    }

    static int getMaxIndex(int[] array, int start, int end){
        int max = start;
        for (int i = start ; i <= end; i++){

            if (array[max] < array[i]){
                max= i;
            }

        }
        return max;
    }
}
