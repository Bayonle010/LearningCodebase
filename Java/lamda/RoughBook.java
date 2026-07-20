package Java.lamda;

import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class RoughBook {
    public static void main(String[] args) {


        Calculator addition = (a, b) -> a + b;

        Predicate<Integer> isEven = number -> number % 2 == 0;
        System.out.println(isEven.test(21));


        Function<Integer, String> numberToText = number -> "Number: " + number;
        System.out.println(numberToText.apply(20));

        Consumer<String> printMessage = message -> System.out.println(message);
        printMessage.accept("Hello World");

        Supplier<String> saveMessage = () -> "saved a message";
        saveMessage.get();

        UnaryOperator<Integer> square = number -> number * number;
        System.out.println(square.apply(5));

        BinaryOperator<Integer> sum = (first, second) -> first + second;
        System.out.println(sum.apply(5, 7));

        //METHOD REFERENCES
        //1. static method reference
        Consumer<String> printer = message -> System.out.println(message);
        Consumer<String> printerInMethodReference = System.out::println;

        BinaryOperator<Integer> maximum = (a,b) -> Math.max(a, b);
        BinaryOperator<Integer> maximumMR = Math::max;
        //2. Instance Method Reference
        Function<String, Integer> length = text -> text.length();
        Function<String, Integer> lengthMR = String::length;

        //3. Constructor Reference
        Supplier<ArrayList<String>> creator = () -> new ArrayList();
        Supplier<ArrayList> creatorMT = ArrayList::new;

        // LAMBDA AND COLLECTIONS
        List<String> names = List.of("Afeez", "Bayonle", "John");
        names.forEach(namess -> System.out.println(names));




    }


    @FunctionalInterface
    interface Calculator{
        int calculate (int first, int second);
    }
}

