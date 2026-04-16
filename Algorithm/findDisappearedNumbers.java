package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class findDisappearedNumbers {

    public static void main(String[] args) {
        int[] nums = {1,1};

        System.out.println(findDisappearedNumbers(nums));
    }
    /**  Range (1, n)
     values => nums[i] => 1, 2, 3, 4, 5, 6, 8, 9;
     index ==> i          0, 1, 2, 3, 4, 5, 6, 7
     *

    **/
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        int lengthOfArray = nums.length;

        while (i < lengthOfArray){
            int current = nums[i];

            if (current >= 1 && current <= lengthOfArray){
                int correctIndex = nums[i] -1;

                if (nums[i] != nums[correctIndex]){
                    swap(nums, i, correctIndex);
                }else {
                    i++;
                }
            }else {
                i++;
            }
        }


        List<Integer> result = new ArrayList<>();

        for (int index = 0; index < lengthOfArray; index++){
            if (nums[index] != index + 1){
                result.add(index + 1);
            }
        }

//        result.add(lengthOfArray + 1);


        return result;
    }


    static void swap(int[] array, int a , int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}
