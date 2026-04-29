package Algorithm;

import java.util.Arrays;

public class SetMismatch {
    public static void main(String[] args) {
        int[] array1 = {1,1};
        System.out.println(Arrays.toString(findErrorNums(array1)));
    }

    static int[] findErrorNums(int[] nums){
        // sort using cyclic sort
        int i = 0;
        while(i < nums.length){
            int current = nums[i];
            int correctIndex = current - 1;

            if (current != nums[correctIndex]){
                swap(nums, i, correctIndex);
            }else {
                i++;
            }
        }

        for (int index = 0; index < nums.length; index++){
            if (nums[index] != index + 1){
                return new int[]{nums[index], index + 1};
            }
        }

        return new int[]{-1, -1};
    }


    static void swap(int[] array, int num1, int num2){
        int temp = array[num1];
        array[num1] = array[num2];
        array[num2] = temp;
    }
}
