package Algorithm.stacks_and_queues.questions;

import java.util.Arrays;
import java.util.Scanner;

public class TwoStacks {

    // Question :
    /*
    Alexa has two stacks of non-negative integers, stack a[n] and stack b[m] where index 0 denotes the top of the
    stack. Alexa challenges Nick to play the following game:

    1. In each move, Nick can remove one integer from the top of either stack a or b
    2. Nick keeps a running sum of integers he removes from the two stacks.
    3. Nick is disqualified from the game, at any point his running sum becomes greater than some integer maxSum given
       at the beginning o the game.

    4. Nick's final score is the total number of integers he has removed from the two stacks.


    Given a,b and maxSum for g games, find the number of maximum possible score Nick can achieve

    E.g

    a = [1, 2, 3, 4, 5]
    b = [6, 7, 8, 9]
    maxSum =
    The maximum number of values Nick can remove is 4 if the max is 10.


     */

    static int twoStacks(int x, int[] a, int[] b) {
        return twoStacks(x, a, b, 0, 0, 0, 0);
    }

    private static int twoStacks(
            int x,
            int[] a,
            int[] b,
            int sum,
            int count,
            int i,
            int j
    ) {

        // Stop if the sum exceeds the maximum allowed
        if (sum > x) {return count - 1;}

        // Stop when both stacks are empty
        if (i == a.length && j == b.length) {
            return count;
        }

        int ans1 = count;
        int ans2 = count;

        // Remove an element from stack A if available
        if (i < a.length) {
            ans1 = twoStacks(
                    x, a, b,
                    sum + a[i],
                    count + 1,
                    i + 1,
                    j
            );
        }

        // Remove an element from stack B if available
        if (j < b.length) {
            ans2 = twoStacks(
                    x, a, b,
                    sum + b[j],
                    count + 1,
                    i,
                    j + 1
            );
        }

        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.print("Enter number of games: ");
        int t = s.nextInt();

        for (int i = 0; i < t; i++) {

            System.out.print("Enter size of stack A: ");
            int n = s.nextInt();

            System.out.print("Enter size of stack B: ");
            int m = s.nextInt();

            System.out.print("Enter maximum sum: ");
            int x = s.nextInt();

            int[] a = new int[n];
            int[] b = new int[m];

            System.out.println("Enter elements of stack A:");
            for (int j = 0; j < n; j++) {
                a[j] = s.nextInt();
            }

            System.out.println("Enter elements of stack B:");
            for (int j = 0; j < m; j++) {
                b[j] = s.nextInt();
            }

            System.out.println(
                    "Maximum score: " + twoStacks(x, a, b)
            );
        }

        s.close();
    }

}
