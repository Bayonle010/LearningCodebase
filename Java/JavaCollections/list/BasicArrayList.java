package Java.JavaCollections.list;// An example for ArrayList
// All of the classes and
// Java.interfaces of the collection
// framework are bundled into 
// the java.util package
import java.util.*;

public class BasicArrayList {

//    The ArrayList class implements the List interface. The objects of this class are dynamic arrays. The ArrayList is essentially a resizable implementation of List.
//        It implements all of the List methods and allows all elements even null elements.
//    The ArrayList objects have a capacity, which is initially equal to the size but increases dynamically as new elements are added.
//    An ArrayList is unsynchronised, which means multiple threads can access them at the same time. A thread is a unit of sequential flow control that can be processed in the Operating System.

    // main method
    public static void main(String[] args) {

        // Instantiate an ArrayList Object
        // Integer is a wrapper class for 
        // the basic datatype int
        ArrayList<Integer> intArr = new ArrayList<Integer>();

        // Add elements using add() method
        intArr.add(10);
        intArr.add(12);
        intArr.add(25);
        intArr.add(19);
        intArr.add(11);
        intArr.add(3);

        // Print the ArrayList on the console
        System.out.println(intArr);

        // Remove elements at index 1 and 4
        intArr.remove(1);
        intArr.remove(4);

        // Print the ArrayList on the console
        System.out.println(intArr);

        // Check if intArr contains the element 25
        if(intArr.contains(25))
        {
            System.out.println("The ArrayList contains 25");
        }
        else
        {
            System.out.println("No such element exists");
        }

        // Use get method to get the element at index 1
        int elementAt1 = intArr.get(1);
        System.out.println("The Element at index 1 now is " + elementAt1);

    }

}