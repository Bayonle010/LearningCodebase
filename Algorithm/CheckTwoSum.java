package Algorithm;

import java.util.HashMap;
import java.util.Map;

public class CheckTwoSum {
//    This is a brute force approach
//    Time = O(n^2) , space = O(1)

    public int[] checkForTwoSum(int[] nums, int target){
        int loopCount =0;

        for (int i= 0; i < nums.length - 1 ; i++) {
            loopCount++;

            for(int j = i+1; j < nums.length ; j++){
                int sum = nums[i] + nums[j];
                System.out.println("Trying: " + nums[i] + " + " + nums[j] + " = " + sum);

                if( sum == target) {
                    System.out.println("found target");
                    System.out.println("[" + i + ", " + j + "]");
                    System.out.println("the sum of " + nums[i] + " and " + nums[j] + " gives " + target);
                    System.out.println("Total loops: " + loopCount);
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    //HashMap approach
//    Time = O(n), space = O(n)

    public int[] checkForTwoSumUsingHashMap(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i<nums.length; i++){
            int compliment = target - nums[i];

            if (map.containsKey(compliment)){
                System.out.println(map.get(compliment) + " and " + i + " gives " + target);
                return new int[]{map.get(compliment), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }


}
