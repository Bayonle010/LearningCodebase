package Java.JavaCollections.map;

import java.util.*;
public class MapImplementationExample {
    public static void main(String[] args) {

        /*--------------HashMap---------------*/

        // Instantiate an object of HashMap named hashMap
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

        // Add elements using put()
        hashMap.put(1, "This");
        hashMap.put(2, "is");
        hashMap.put(3, "HashMap");

        // Print the HashMap contents on the console
        System.out.println("Contents of hashMap : ");
        System.out.print(hashMap.entrySet());

        // Add a duplicate key
        hashMap.put(3, "Duplicate");

        // Add a duplicate value
        hashMap.put(4, "This");

        // Print the HashMap contents on the console
        System.out.println("\nContents of hashMap after adding duplicate : ");
        System.out.print(hashMap.entrySet());

        /*--------------Hashtable----------------*/

        // Instantiate an object of Hashtable named hashTable
        Hashtable<Integer, String> hashTable = new Hashtable<Integer, String>();

        // Add elements using put()
        hashTable.put(11, "This");
        hashTable.put(12, "is");
        hashTable.put(13, "Hashtable");

        // Print the Hashtable contents on the console
        System.out.println("\n\nContents of hashTable : ");
        System.out.print(hashTable.entrySet());

        // Add a duplicate key
        hashTable.put(11, "Duplicate");

        // Add a duplicate value
        hashTable.put(14, "is");

        // Print the Hashtable contents on the console
        System.out.println("\nContents of hashTable after adding duplicate : ");
        System.out.print(hashTable.entrySet());

        /*---------------LinkedHashMap---------------*/

        // Instantiate an object of LinkedHashMap named linkedHashMape
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();

        // Add elements using put()
        linkedHashMap.put(21, "This");
        linkedHashMap.put(22, "is");
        linkedHashMap.put(23, "LinkedHashMap");

        // Print the LinkedHashMap contents on the console
        System.out.println("\n\nContents of linkedHashMap : ");
        System.out.print(linkedHashMap.entrySet());

        // Add a duplicate key
        linkedHashMap.put(22, "Duplicate");

        // Add a duplicate value
        linkedHashMap.put(24, "This");

        // Print the LinkedHashMap contents on the console
        System.out.println("\nContents of linkedHashMap after adding duplicate : ");
        System.out.print(linkedHashMap.entrySet());
    }
}
