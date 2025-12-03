package Java.JavaCollections.list;
import java.util.*;
public class LinkedlistExample {
//    The LinkedList class implements the List interface as well as the Deque interface.
//    The LinkedList is the class implementation of the linked list data structure, where every element has a pointer to the next element forming a link.
//    Since each element has an address of the next element, the linked list elements, referred to as nodes, can be stored at non-contiguous locations in memory.

    public static void main(String[] args) {

        // Instantiate LinkedList named strLinkedList
        LinkedList<String> strLinkedList = new LinkedList<String>();

        // Add elements to the LinkedList using add()
        strLinkedList.add("This");
        strLinkedList.add("is");
        strLinkedList.add("a");
        strLinkedList.add("LinkedList");

        // The elements are retrieved using the get() method
        System.out.println("The contents of strLinkedList : ");
        for(int i = 0; i < strLinkedList.size(); i++)
        {
            System.out.print(strLinkedList.get(i) + " ");
        }

        // The elements are removed using remove()
        strLinkedList.remove(0);
        strLinkedList.remove(1);

        System.out.println("\n\nThe contents of strLinkedList after remove operation : ");
        for(int i = 0; i < strLinkedList.size(); i++)
        {
            System.out.print(strLinkedList.get(i) + " ");
        }

    }
}
