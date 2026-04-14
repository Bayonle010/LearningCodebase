package Algorithm.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] array = {6,5,4,5,2};

        insertionSort(array);

        System.out.println(Arrays.toString(array));
    }


    static void insertionSort(int[] array){
        for (int i = 0; i < array.length -  1; i++){

            for (int j = i+1; j> 0; j--){
                if (array[j] < array[j-1]){
                    swap(array, j, j -1);
                }else {
                    break;
                }
            }

        }
    }

    static void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}
