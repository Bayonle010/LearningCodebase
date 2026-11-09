package Algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinToMakeParenthesesValid921 {

    // LEETCODE 921

    /*
    A parentheses string is valid if and only if:

    It is the empty string,
    It can be written as AB (A concatenated with B), where A and B are valid strings, or
    It can be written as (A), where A is a valid string.
    You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.

    For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
    Return the minimum number of moves required to make s valid.
     */

    public int minAddToMakeValid(String s){

        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()){
            if (c == ')' && !stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        return stack.size();
    }



    public int minAddToMakeValidMethodII(String s){

        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if (c == ')' && !stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        return stack.size();
    }
}
