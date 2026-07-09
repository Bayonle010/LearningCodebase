package Algorithm.random;

import java.util.HashMap;
import java.util.Map;

public class PalindromeCheck {

    public static void main(String[] args) {
//        System.out.println(isPalindrome("Ma dam"));
        System.out.println(isAnagram("vile", "evil"));
    }

    public static boolean isPalindrome(String letter){

        String word = letter.toLowerCase().replace(" ", "");

        int left = 0;
        int right = word.length() -1;


        while (left < right){
            if (word.charAt(left) != word.charAt(right)){
                return false;
            }

            left++;
            right--;
        }

        return true;

    }


    public static boolean isAnagram(String word1, String word2){
        if (word1.length() != word2.length()){
            return false;
        }

        Map<Character, Integer> mapFrequencyCount = new HashMap<>();

        for (Character letterFromWord1 : word1.toCharArray()){
            mapFrequencyCount.put(letterFromWord1, mapFrequencyCount.getOrDefault(letterFromWord1, 0) + 1);
        }

        for (Character letterFromWord2: word2.toCharArray()){
            if (!mapFrequencyCount.containsKey(letterFromWord2)){
                return false;
            }

            mapFrequencyCount.put(letterFromWord2, mapFrequencyCount.getOrDefault(letterFromWord2, 0) -1);

            if (mapFrequencyCount.get(letterFromWord2) == 0){
                mapFrequencyCount.remove(letterFromWord2);
            }
        }

        return mapFrequencyCount.isEmpty();
    }

}
