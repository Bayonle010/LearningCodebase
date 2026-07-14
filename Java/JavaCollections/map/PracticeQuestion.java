package Java.JavaCollections.map;

import com.sun.source.tree.BreakTree;

import javax.naming.InitialContext;
import javax.swing.text.StyleContext;
import java.io.CharArrayReader;
import java.util.*;

public class PracticeQuestion {

    public static void main(String[] args) {
        String[] words = {
                "java", "spring", "java", "docker", "spring", "java"
        };

        int[] numbers = {2, 4, 2, 5, 4, 2};
        String text = "swiss";

        int[] first = {1, 2, 2, 3};
        int[] second = {2, 3, 2, 1};

        // System.out.println(countWords(words));
        // System.out.println(countFrequency(numbers));
        System.out.println(firstNonRepeatingCharacter(text));
        System.out.println(haveSameFrequency(first, second));

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));

        String[] w = {
                "apple", "banana", "ant", "ball", "cat", "car"
        };

        System.out.println(groupByFirstCharacter(w));

    }

    /*
        Write a Java method that receives an array of words and returns a Map<String, Integer> containing how many times each word appears.
    */

    static Map<String, Integer> countWords(String[] words){
        Map<String, Integer> map = new HashMap<>();

        for (String word : words){
//            if (map.containsKey(word)){
//                map.put(word, map.get(word) + 1);
//            }else {
//                map.put(word, 1);
//            }
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        return map;

    }


    /*
        Find the Frequency of Numbers

        Given an integer array, return a map showing how many times each number appears.
     */

    static Map<Integer, Integer> countFrequency(int[] array){
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++){
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }

        return map;
    }

    /*
        Find the First Non-Repeating Character

        Given a string, return the first character that appears only once
     */

    static Character firstNonRepeatingCharacter(String text){

        Map<Character, Integer> map = new HashMap<>();

        for (char c : text.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Character c: text.toCharArray()){
            if (map.get(c) == 1){
                return c;
            }
        }

        return null;
    }

    /*
        Check Whether Two Arrays Have the Same Frequencies
        Given two integer arrays, return true when they contain the same numbers with the same frequencies, regardless of order.
     */

    static boolean haveSameFrequency(int[] first, int[] second){
        if (first.length != second.length){
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : first){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num2: second){
            if (!map.containsKey(num2)) return false;

            map.put(num2, map.get(num2) - 1);

            if (map.get(num2) == 0){
                map.remove(num2);
            }
        }

        return map.isEmpty();
    }

    /*
        Two Sum

        Given an integer array and a target, return the indices of two numbers whose sum equals the target.
     */

    static int[] twoSum(int[] numbers, int target){

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0 ; i< numbers.length; i++ ){
            int compliment = target - numbers[i];

            if (map.containsKey(compliment)){
                return new int[] {map.get(compliment), i};
            }
            map.put(numbers[i], i);
        }

        return null;
    }

    /*
        Group Words by Their First Character

        Given an array of words, group words that start with the same character.
     */

    static Map<Character, List<String>> groupByFirstCharacter(String[] words){

        Map<Character, List<String>> map = new HashMap<>();
        for (String word : words){
            char firstCharacter = word.charAt(0);

            map.computeIfAbsent(
                    firstCharacter, key-> new ArrayList<>()
            ).add(word);


//            if (map.containsKey(firstCharacter)){
//
//                map.get(firstCharacter).add(word);
//            }else {
//                List<String> values = new ArrayList<>();
//                values.add(word);
//                map.put(firstCharacter, values);
//            }
        }

        return map;


    }


}
