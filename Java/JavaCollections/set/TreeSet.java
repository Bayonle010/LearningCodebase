//package Java.JavaCollections.set;
//
//import java.util.*;
//public class TreeSet {
//    public static void main(String[] args) {
//
//        // Instantiate an object of TreeSet named intTreeSet
//        TreeSet<Integer> intTreeSet = new TreeSet<Integer>();
//
//        // Add elements using add()
//        intTreeSet.add(18);
//        intTreeSet.add(13);
//        intTreeSet.add(29);
//        intTreeSet.add(56);
//        intTreeSet.add(73);
//
//        // Try to add a duplicate
//        // Observe output as it will not be added
//        intTreeSet.add(18);
//
//        // Print the TreeSet on the console
//        System.out.println("The contents of intTreeSet : ");
//        System.out.println(intTreeSet);
//
//        // Remove 18 using remove()
//        if(intTreeSet.remove(18))
//        {
//            System.out.println("\nElement 18 has been removed");
//        }
//        else
//        {
//            System.out.println("\nNo such element exists");
//        }
//
//        // Try to remove a non-existent element
//        if(intTreeSet.remove(12))
//        {
//            System.out.println("\nElement 18 has been removed");
//        }
//        else
//        {
//            System.out.println("\nNo such element exists");
//        }
//
//        System.out.println();
//
//        // Print the TreeSet on the console
//        System.out.println("The contents of intTreeSet : ");
//        System.out.println(intTreeSet);
//
//    }
//
//}
