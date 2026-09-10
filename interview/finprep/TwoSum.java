package interview.finprep;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public  static int[ ]twoSum(int[] array, int target){
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i<array.length; i++){

            int compliment = target - array[i];

            if (map.containsKey(compliment)){
                return new int[]{map.get(compliment), i};
            }

            map.put(array[i], i);
        }

        return new int[]{-1,-1};
    }
}
