package Java.lamda;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class LambdaExercise2 {
    public static void main(String[] args) {
        System.out.println(everySecondCharLambda.apply("1234567890"));;
        System.out.println(everySecondCharacter(everySecondCharLambda, "1234567890"));
        System.out.println(iLoveJava.get());
    }

    public static String everySecondCharacter(UnaryOperator<String> func, String source) {
        return func.apply(source) ;
    }

    // write this method as lambda expression
    public static String everySecondChar(String source){
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i< source.length(); i++){
            if (i%2 == 1){
                returnVal.append(source.charAt(i));
            }
        }
        return  returnVal.toString();
    }

    static  UnaryOperator<String> everySecondCharLambda = source -> {
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i< source.length(); i++){
            if (i%2 == 1){
                returnVal.append(source.charAt(i));
            }
        }
        return  returnVal.toString();
    };


    static Supplier<String> iLoveJava = ()-> "I love Java!";



}
