package Algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses20 {
    /*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.


    Example 1:

    Input: s = "()"
    Output: true

    Example 2:
    Input: s = "()[]{}"
    Output: true

    Example 3:
    Input: s = "(]"
    Output: false

    Example 4:
    Input: s = "([])"
    Output: true

    Example 5:
    Input: s = "([)]"
    Output: false

     */

    static void main() {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([])"));
        System.out.println(isValid("([)]"));
    }


    public static boolean isValid(String s){
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()){

            if (c == '(' || c ==  '{'  || c == '['){
                stack.push(c);
            }else{
                if (c == ')' ) {
                    if (stack.isEmpty() || stack.pop() != '('){
                        return false;
                    }
                }

                if (c == '}' ) {
                    if (stack.isEmpty() || stack.pop() != '{'){
                        return false;
                    }
                }

                if (c == ']' ) {
                    if (stack.isEmpty() || stack.pop() != '['){
                        return false;
                    }
                }

            }

        }

        return true;
    }


}
