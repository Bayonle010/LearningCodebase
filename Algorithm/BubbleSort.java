package Algorithm;

import java.util.Arrays;

public class BubbleSort {


    public static void main(String[] args) {
        int [] array = {5,4,3,2,1};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

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
