package Algorithm.sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CyclicSort {


    public static void main(String[] args) {
        int[] array = {5,4,3,2,1};
        cyclicSort(array);
        System.out.println(Arrays.toString(array));
    }



    // better version with while loop

    static void cyclicSort(int[] array){
        int i = 0;
        while (i < array.length){
            int correctIndex = array[i] - 1;
            if (array[i] != array[correctIndex]){
                swap(array, i, correctIndex);
            }else {
                i++;
            }
        }

    }


    // for loop usage
    static void cyclicSortWithForLoop(int[] array){
        for (int i = 0; i< array.length;){

            int correctIndex = array[i] -1;

            if (array[i] != array[correctIndex]){
                swap(array, i, correctIndex);
            }else {
                i++;
            }

        }
    }



    static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
