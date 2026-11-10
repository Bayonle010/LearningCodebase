package Algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumInsertionToBalance1541 {
    /*
    You are given a parentheses string s containing only the characters '(' and ')'. A parentheses string is balanced if it can be formed using the following rules:

    The empty string is balanced.
    If A is balanced, then '(' + A + '))' is balanced.
    If A and B are balanced, then their concatenation is balanced.
    In other words, every left parenthesis '(' must have a corresponding pair of two consecutive right parentheses '))' that comes after it, and every right parenthesis must
    belong to exactly one such matching pair.

    For example, "())", "())(())))" and "(())())))" are balanced, while ")()", "()))" and "(()))" are not balanced.

    You can insert the characters '(' and ')' at any position of the string to balance it if needed.

    Return the minimum number of insertions needed to make s balanced.
     */


    public static int minInsertions(String s){


        Deque<Character> stack = new ArrayDeque<>();

        int insertion = 0;

        for (int i =0; i < s.length(); i ++){
            char c = s.charAt(i);

            if (c == '('){
                stack.push(c);
            }else {
                if ( i+1 < s.length() && s.charAt(i+1) == ')'){
                    i++; // consume the second ')'
                }else {
                    insertion++;  // insert the missing second
                }

                // Match the pair of ')' with an opening '('
                if (!stack.isEmpty()){
                    stack.pop();
                }else{
                    insertion++; // insert a missing '('
                }
            }

        }

        // each remaining '(' require two ')'

        return insertion + ( stack.size() * 2 );
    }


}
