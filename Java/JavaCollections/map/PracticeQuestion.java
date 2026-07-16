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
        QUESTION 1
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
        QUESTION 2
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
        QUESTION 3
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
        QUESTION 4
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
        QUESTION 5
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
        QUESTION 6

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

        }

        return map;


    }

    /*

        QUESTION 8

        Find Duplicate Numbers

        Given an integer array, return a list containing numbers that appear more than once.

        Each duplicate number should appear only once in the result.
     */

    static List<Integer> findDuplicate(int[] numbers ){
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : numbers){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        for (Map.Entry< Integer, Integer > entry : map.entrySet() ){
            if (entry.getValue() > 1){
                result.add(entry.getKey());
            }
        }

        return result;
    }


    /*

    QUESTION 9
     Finance Map Problem : Transaction Velocity Detection

    A bank wants to identify accounts making transactions too quickly.
    An account is considered suspicious when it makes more than three transactions within any ten-second window.
    That means an account must make at least four transactions, where:
    latest timestamp - earliest timestamp <= 10,000 milliseconds
    Return every suspicious accountId.
    The result must not contain duplicates.

    E.g:

     accountId: "ACC001", timestamp: 1000
     accountId: "ACC001", timestamp: 5000
     accountId: "ACC001", timestamp: 8000
     accountId: "ACC001", timestamp: 10000   ← 4 transactions within 10 seconds (1000–10000) → suspicious
     accountId: "ACC002", timestamp: 1000
     accountId: "ACC002", timestamp: 9000    ← only 2 transactions → clean
     accountId: "ACC001", timestamp: 50000   ← new window, not suspicious alone

     */


    static List<String> findSuspiciousAccounts(List<Transaction> transactions){
        Map<String, List<Long>> countMaps = new HashMap<>();

        for (Transaction transaction : transactions){
            countMaps.computeIfAbsent(transaction.accountId, k ->new ArrayList<>() ).add(transaction.timestamp);
        }

        Set<String> suspiciousAccounts = new HashSet<>();

        for (Map.Entry<String, List<Long>> entry : countMaps.entrySet()){

            String accountId = entry.getKey();
            List<Long> timeStamp = entry.getValue();

            Collections.sort(timeStamp);

            int left = 0;

            for (int right = 0; right < timeStamp.size(); right++){

                while (timeStamp.get(right) - timeStamp.get(left) > 10000 ){
                    left++;
                }

                int windowSize = right - left + 1;

                if (windowSize > 3){
                    suspiciousAccounts.add(accountId);
                    break;
                }
            }
        }

        return new ArrayList<>(suspiciousAccounts);
    }


    static class  Transaction{
        private String accountId;
        private long timestamp;

        public Transaction(String accountId, long timestamp) {
            this.accountId = accountId;
            this.timestamp = timestamp;
        }

        public String getAccountId() {
            return accountId;
        }

        public long getTimestamp() {
            return timestamp;
        }

    }



}
