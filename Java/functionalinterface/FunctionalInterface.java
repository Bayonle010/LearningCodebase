package Java.functionalinterface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterface {

    public static void main(String[] args) {
        System.out.println(f.toString());
        System.out.println(isEven);
        System.out.println(print);
        System.out.println(random);
    }

    // Input -> Output
    static Function<Integer, String> f =  x -> "String" + x;

    // Input -> boolean
    static Predicate<Integer> isEven = x -> x%2 == 0;

    //input -> no return
    static Consumer<String> print = s-> System.out.println(s);

    // input -> output
    static Supplier<Double> random = () -> Math.random();

}
