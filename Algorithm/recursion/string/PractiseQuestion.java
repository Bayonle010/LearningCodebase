package Algorithm.recursion.string;

public class PractiseQuestion {

    public static void main(String[] args) {
        skipLetterA("", "agbalumo");

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

    static String skipLetterA( String unprocesed){
        if (unprocesed.isEmpty()){
            return "";
        }

        char ch = unprocesed.charAt(0);
        if (ch == 'a'){
           return skipLetterA(unprocesed.substring(1));
        }else {
            return ch + (unprocesed.substring(1));
        }
    }

}
