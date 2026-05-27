package Algorithm.sorting;

import javax.swing.*;
import java.util.Arrays;

public class SortingRevision {

    public static void main(String[] args) {
        int[] array = {4,2,1,3};
//        bubbleSort(array);
//        insertionSort(array);
//        selectionSort(array);
        cyclicSort(array);
        System.out.println(Arrays.toString(array));
//        System.out.println(getMin(array));
    }

    // move the largest element to the end of the array
    static void bubbleSort(int[] array){
        for (int i = 0; i < array.length; i++){
            boolean swapped = false;

            for (int j = 1; j < array.length - i; j++){

                if (array[j] < array[j -1 ]){
                    swap(array, j, j - 1);
                    swapped = true;
                }
            }
            if (!swapped){
                break;
            }
        }
    }

    //
    static void insertionSort(int[] array){
        for(int i = 0; i< array.length -1; i++){
            for (int j = i + 1; j > 0; j--){
                if (array[j] < array[j -1]){
                    swap(array, j , j-1);
                }
            }
        }
    }

//    pick the largest or smallest element and fix it to the last or first respectively by replacing the element in the position
    static void selectionSort(int[] array){
        for (int i = 0; i < array.length -1; i++){
            int minIndex = getMinIndex(array, i, array.length -1);

            if (minIndex != i){
                swap(array, minIndex, i);
            }
        }
    }


    static void cyclicSort(int[] array){
        int i = 0;
        while (i < array.length){
            int correctIndex = array[i] -1;

            if (array[i] != array[correctIndex]){
                swap(array, i, correctIndex);
            }else {
                i++;
            }
        }
    }


    private static int getMinIndex(int[] array, int start, int end){
        int min = start;

        for (int i = start; i <= end; i++){
            if (array[i] < array[min]){
                min = i;
            }
        }
        return min;
    }



    private static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
