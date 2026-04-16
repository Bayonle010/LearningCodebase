package Algorithm;

import java.util.Arrays;

public class MissingNumber {

    public static void main(String[] args) {
        int[] array = {5, 4, 2,3, 0};
        int missingNumber = missingNumberInRange0_to_n(array);
        System.out.println(missingNumber);

    }

    static int missingNumberInRange0_to_n(int[] array){
        int i = 0;
        int lengthOfArray = array.length;

        while (i < lengthOfArray){
            int correctIndex = array[i];
            if (array[i]< array.length && array[i] != array[correctIndex]){
                swap(array, i, correctIndex);
            }else {
                i++;
            }
        }

        for (int index = 0; index < lengthOfArray; index++){
            if (array[index] != index){
                return index;
            }
        }

        return lengthOfArray;

    }

    // finding missing number in an array from the range [1,n]
    static int missingNumber(int[] array){
        int i = 0;
        int lengthOfArray = array.length;
        while (i < lengthOfArray){
            int current = array[i];

            if (current >= 1 && current < lengthOfArray){
                int correctIndex = array[i] - 1;

                if (array[i] != array[correctIndex]){
                    swap(array, i, correctIndex);
                }else {
                    i++;
                }
            }else {
                i++;
            }
        }

        //search for firstMissingNumber
        for (int index = 0; index< array.length; index++){
            if (array[index] != index + 1){
                return index + 1;
            }
        }

        return lengthOfArray + 1;

    }


    static void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }



    
}
