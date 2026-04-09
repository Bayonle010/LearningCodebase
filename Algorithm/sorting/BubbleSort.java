package Algorithm.sorting;

import java.util.Arrays;

public class BubbleSort {


    public static void main(String[] args) {
        int [] array = {5,4,3,2,1};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**

     * {5,4,3,2,1}
     * i runs from 0 to 5
     * j runs from 1 to (5-i-1)
     * i = 0||, j = 1,  runs from 1 to 5 -0 - 1 = 4;
     * j =1 => {4,5,3,2,1}, j=2 => {4,3,5,2,1}, j = 3=> {4,3,2,5,1}, j = 4=> {4,3,2,1,5}
     * i = 1 || j runs from 1 to (5-1-1) = 3
     * j = 1 => {3,4,2,1,5}, j = 2 => {3,2,4,1,5}, j = 3 => {3,2,1,4,5}

     **/

    static void bubbleSort(int[] array){
        boolean swapped;

        for (int i = 0; i< array.length; i++){
            swapped = false;

            for (int j = 1; j< array.length - i; j++){

                // swap if item is smaller than previous item
                    if (array[j] < array[j-1]){
                        int temp = array[j];
                        array[j] = array[j-1];
                        array[j-1] = temp;

                        swapped = true;
                    }

            }

            // if swapp did not occur, it means

            if(!swapped){
                break;
            }
        }
    }

}
