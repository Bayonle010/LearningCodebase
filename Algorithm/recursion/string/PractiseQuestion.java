package Algorithm.recursion.string;

import java.util.ArrayList;

public class PractiseQuestion {

    public static void main(String[] args) {
        //skipLetterA("", "agbalumo");
        ArrayList<String> ans = permutationsList("", "abc");
        System.out.println(ans);

    }

    static void skipLetterA(String processed, String unprocesed){
        if (unprocesed.isEmpty()){
            System.out.println(processed);
            return ;
        }

        char ch = unprocesed.charAt(0);
        if (ch == 'a'){
            skipLetterA(processed, unprocesed.substring(1));
        }else {
            skipLetterA(processed + ch, unprocesed.substring(1));
        }
    }

    static String skipLetterA( String unprocessed){
        if (unprocessed.isEmpty()){
            return "";
        }

        char ch = unprocessed.charAt(0);
        if (ch == 'a'){
           return skipLetterA(unprocessed.substring(1));
        }else {
            return ch + skipLetterA(unprocessed.substring(1));
        }
    }




    static void permutations(String processed, String unprocessed){
        if (unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }

        char ch = unprocessed.charAt(0);

        for (int i = 0; i<= processed.length(); i++){
            String f = processed.substring(0, i);
            String s = processed.substring(i, processed.length());

            permutations(f + ch + s, unprocessed.substring(1));

        }
    }

    static ArrayList<String> permutationsList(String processed, String unprocessed){
        if (unprocessed.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        char ch = unprocessed.charAt(0);

        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i<= processed.length(); i++){
            String f = processed.substring(0, i);
            String s = processed.substring(i, processed.length());

            ans.addAll(permutationsList(f + ch + s, unprocessed.substring(1)));

        }

        return ans;
    }

}
