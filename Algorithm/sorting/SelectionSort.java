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

    static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
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
