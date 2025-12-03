// An example for HashSet and LinkedHashSet
import java.util.*;

public class HashSetAndLinkedHashSet {

    public static void main(String[] args) {

        /*-----------HashSet-------------*/

        // Instantiate a HashSet object named strHashSet
        HashSet<String> strHashSet = new HashSet<String>();

        // Add elements using add()
        strHashSet.add("This");
        strHashSet.add("is");
        strHashSet.add("a");
        strHashSet.add("HashSet");

        // Create an Iterator to traverse through the HashSet
        Iterator<String> hsIterator = strHashSet.iterator();

        // Print all the elements of the HashSet
        System.out.println("Contents of HashSet : ");
        while(hsIterator.hasNext())
        {
            System.out.print(hsIterator.next() + " ");
        }

        /*---------LinkedHashSet----------*/

        // Instantiate an object of LinkedHashSet named strLinkedHashSet
        // Pass the name of the HashSet created earlier to copy all of the contents
        // of the HashSet to the LinkedHashSet using a constructor
        LinkedHashSet<String> strLinkedHashSet = new LinkedHashSet<String>(strHashSet);

        // Create an Iterator to traverse through the LinkedHashSet
        Iterator<String> lhsIterator = strLinkedHashSet.iterator();

        // Print all the elements of the LinkedHashSet
        System.out.println("\n\nContents of LinkedHashSet : ");
        while(lhsIterator.hasNext())
        {
            System.out.print(lhsIterator.next() + " ");
        }

    }

}