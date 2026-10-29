package Algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangle84 {


    static void main() {

        int[] heights = {2, 1,5, 2, 3};
        System.out.println(findLargestRectangleInHistogram(heights));
    }


    public static int findLargestRectangleInHistogram(int[] heights) {
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {

            int minHeight = heights[i];

            for (int j = i; j < heights.length; j++) {

                minHeight = Math.min(minHeight, heights[j]);

                int width = j - i + 1;

                int area = minHeight * width;

                maxArea = Math.max(maxArea, area);
            }


        }

        return maxArea;

    }



    /*
        Right boundary = current index when we encounter a shorter bar
        Left boundary = index remaining at the top the stack after popping
    */

    public static int largestRectangleAreaLeetcode84(int[] heights){
        Deque<Integer> stack = new ArrayDeque<>();

        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i<= n; i++){
            int currentHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] > currentHeight) {
                int poppedIndex = stack.pop();

                int height = heights[poppedIndex];

                int leftBoundary = stack.isEmpty() ? -1 : stack.peek();

                int width = i - leftBoundary - 1;

                int area = height * width;

                maxArea = Math.max(maxArea, area);
            }
            if (i < n){
                stack.push(i);
            }
        }
        return maxArea;
    }
}
