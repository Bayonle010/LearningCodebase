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


    //Remove Element
//    A function that gives the relationship about how the time grows as the input grows is referred to as Time complexity

//    what do we need to consider when thinking about complexity
//1. Always look for worst case complexity
//    2. Always look at complexity for large or infinite data
//    3. for O(n), we dont care about the actual time. if an algorithm is y = x, y=2x or y=3x. we consider is as same y =x and ignore all constants
//    4. Always ignore less dominating terms
//    e.g in a time complexity of :
//    O(N^3 + logN):
//    from point 2
//    if n= 1million
//
//    answer = 1million^3 + log(1millionN) = 1 milllion^3 + 6s (very small hence ignore)


//    Big O -notation
//    word algorithm : O(N^3) upper bound
//    maths: f(n) = O(g(n))
//    this means lim as n tends to infinity (f(n) / g(n)) < infinity

//    Big Omega: Opposit by Big oh;
//    words : Omega(N^3) lower bound;
//    maths: lim as n tends to infinity  (f(x)/ g(x)) > 0;

//    Little O notation;
//    This also gives upper bound;
//    word : loose up;
//
//    big Oh versus  little O
//    f= o(g(n));     f = O(g); f< g (strictly slower)
//    f <= g
//
//    maths: lim as n tends to infinity f(N)/g(N) = 0;


// Little Omega;
//    f = w(g);
//
//    Big w versus little Omega;
//    f = ohms(g);           f = w(g)
//    f >= g                 f > g;
//
//    Maths: lim as n tends to infinity f(n)/g(n) = infinity;




}

