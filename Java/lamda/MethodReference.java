package Java.lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class MethodReference {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of(
                "Anna", "Bayo", "Charles"
        ));

        list.forEach(System.out::println);
        calculator(Integer::sum, 10 , 20);
        calculator((a,b) -> a - b, 10.2, 4.3);

    }

    private static <T> void calculator(BinaryOperator<T> function, T value1, T value2){
        T result = function.apply(value1, value2);
        System.out.println("Result of operation: " + result);
    }
}
