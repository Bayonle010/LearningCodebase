package Java.lamda;

import java.util.Arrays;
import java.util.function.Consumer;

public class LambdaExercise {

    public static void main(String[] args) {

        Consumer<String> printTheParts = new Consumer<String>() {
            @Override
            public void accept(String sentence) {
                String[] parts = sentence.split(" ");

                for (String part : parts) {
                    System.out.println(part);
                }
            }
        };
        printTheParts.accept("Bayo is boy");



        Consumer<String> printWordsLambda = sentence -> {
            String[] parts = sentence.split(" ");

            for (String part : parts) {
                System.out.println(part);
            }

        };
        printWordsLambda.accept("Bayo is a boy");



        Consumer<String> printWordsForEach = sentence-> {
            String[] parts = sentence.split(" ");
            Arrays.asList(parts).forEach(s-> System.out.println(s));
        };
        printWordsForEach.accept("Bayo is a boy");




        Consumer<String> printWordConcise = sentence-> {
            Arrays.asList(sentence.split(" ")).forEach(s-> System.out.println(s));
        };
        printWordConcise.accept("Bayo is a boy");
    }


}
