package interview.finprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] mergerIntervals(int[][] intervals){

        if (intervals.length == 1){
            return  intervals;
        }

        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        int[] current = intervals[0];

        for(int i = 1; i<= intervals.length; i++){
            int[] next = intervals[i];

            if (next[0] <= current[1]){
                current[1] = Math.max(current[1], next[1]);
            }else {
                current = next;
            }

        }

        return result.toArray(new int[result.size()][]);
    }
}
