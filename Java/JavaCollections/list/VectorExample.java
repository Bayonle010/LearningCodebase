package Java.JavaCollections.list;// An example for Vector
import java.util.*;

public class VectorExample {

    public static void main(String[] args) {

        // Instantiate Vector object
        Vector<Integer> intVector = new Vector<Integer>();

        // Print the initial size of the Vector
        System.out.println("The initial size of the Vector = " + intVector.size());
        System.out.println();

        // Add elements using add method
        intVector.add(11);
        intVector.add(18);
        intVector.add(1);
        intVector.add(87);
        intVector.add(19);
        intVector.add(11);

        // Print the Vector on the console
        System.out.println("The Vector intVector : ");
        System.out.println(intVector);
        System.out.println("Size of intVector : " + intVector.size());

        System.out.println();

        // Remove the element at index 2
        intVector.remove(2);

        // Print the vector again on the console
        System.out.println("The Vector intVector after removing element at 2 : ");
        System.out.println(intVector);

        System.out.println();

        // Clear all elements of the Vector and
        // Print the Vector on the console
        intVector.clear();
        System.out.println("The Vector intVector after using clear : ");
        System.out.println(intVector);

    }

}