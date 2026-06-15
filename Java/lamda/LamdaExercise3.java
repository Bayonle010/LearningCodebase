package Java.lamda;

import java.util.Arrays;

public class LamdaExercise3 {
    public static void main(String[] args) {
        String[] names = {"Alamu", "Bayo", "Caroline", "Dauda"};

        Arrays.setAll(names, i-> names[i].toUpperCase());

        System.out.println("--> Transform to upper case");
        System.out.println(Arrays.toString(names));
    }
}
