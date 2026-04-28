package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesNumber {

    public static void main(String[] args) {
        int[] array = {1};

        System.out.println(findAllDuplicates(array));
    }

    public static List<Integer> findAllDuplicates(int[] nums){


        int i = 0;
        while (i < nums.length){

            if (nums[i] != i + 1){
                int current = nums[i];
                int correctIndex = current - 1;

                if (current != nums[correctIndex]){
                    swap(nums, i, correctIndex);
                }else {
                    i++;
                }
            }else {
                i++;
            }
        }


        List<Integer> duplicates = new ArrayList<>();
        for (int index = 0; index < nums.length; index++){
            if (nums[index] != index + 1){
                duplicates.add(nums[index]);
            }
        }
        return duplicates;
    }

    static void swap(int[] array, int num1, int num2){
        int temp = array[num1];
        array[num1] = array[num2];
        array[num2] = temp;
    }
}
