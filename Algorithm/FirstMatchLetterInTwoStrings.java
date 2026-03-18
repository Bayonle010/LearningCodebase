package Algorithm;

import java.io.StringReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstMatchLetterInTwoStrings {
    public static void main(String[] args) {
        System.out.println(findMatchingCharacter("Bayonle", "Onadiran"));
    }

    /*
        Write a method that takes two strings and returns the first character that appears in
        both strings. If no such character exists, return null. The method should be case-sensitive
     */
    // Bad . Time complexity is O(n^2)
    public static Character bruteForceMatchingCharacter(String firstLetter, String secondLetter){

        for (int i = 0; i < firstLetter.length(); i++){
            for (int j = 0; j < secondLetter.length(); j++){
                if (firstLetter.charAt(i) == secondLetter.charAt(j)){
                    return firstLetter.charAt(i);
                }
            }
        }
        return null;
    }

    // Optimized Approach
    // Time Complexity O(n + m +1) = O(n + m)
    public static Character findMatchingCharacter(String firstLetter, String secondLetter){
        Set<Character> secondLettersStorage = new HashSet<>();

        for (int j = 0; j < secondLetter.length(); j++) {
            secondLettersStorage.add(secondLetter.charAt(j));
        }

        for (int i = 0; i< firstLetter.length(); i++){
            char current = firstLetter.charAt(i);
            if (secondLettersStorage.contains(current)){
                return current;
            }
        }

        return null;
    }
}
