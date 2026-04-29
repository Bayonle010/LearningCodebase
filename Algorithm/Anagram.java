package Algorithm;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
    // e.g listen == silent
    public static boolean isAnagram(String firstLetter, String secondLetter){
        if (firstLetter.length() != secondLetter.length()){
            return false;
        }

        Map<Character, Integer> freq = new HashMap<>();

        for (char s: firstLetter.toCharArray()){
            freq.put(s, freq.getOrDefault(s,0) + 1);
        }

        for (char c : secondLetter.toCharArray()){
            if(!freq.containsKey(c)) return false;

            freq.put(c, freq.get(c) -1 );

            if (freq.get(c) == 0){
                freq.remove(c);
            }
        }

        return freq.isEmpty();

    }
}
