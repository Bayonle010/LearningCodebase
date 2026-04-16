package Algorithm;

import java.util.Arrays;

public class MissingNumber {

    public static void main(String[] args) {
        int[] array = {5, 4, 2, 1};
        int missingNumber = missingNumber(array);
        System.out.println(missingNumber);

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
