package Algorithm.random;

public class FirstMissingPositivee {
    /*
        Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

        You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.



        Example 1:

        Input: nums = [1,2,0]
        Output: 3
        Explanation: The numbers in the range [1,2] are all in the array.
        Example 2:

        Input: nums = [3,4,-1,1]
        Output: 2
        Explanation: 1 is in the array but 2 is missing.
        Example 3:

        Input: nums = [7,8,9,11,12]
        Output: 1
        Explanation: The smallest positive integer 1 is missing.
     */


    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int current = nums[i];
            int correctIndex = current - 1;

            if (current > 0 && current <= nums.length && current != nums[correctIndex]){
                swap(nums, i, correctIndex);
            }else {
                i++;
            }
        }

        for (int index = 0; index < nums.length; index++){
            if (nums[index] != index + 1){
                return index + 1;
            }
        }

        return nums.length + 1;

    }

    static void swap(int[] array, int num1, int num2){
        int temp = array[num1];
        array[num1] = array[num2];
        array[num2] = temp;
    }
}
