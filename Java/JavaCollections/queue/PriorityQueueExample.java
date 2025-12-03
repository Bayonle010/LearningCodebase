package Java.JavaCollections.queue;

import  java.util.*;
public class PriorityQueueExample {
//    The PriorityQueue class implements the Queue interface.
//    The elements of a PriorityQueue are either ordered in natural order or in an order specified by a Comparator, which depends on the constructor used.
//    The PriorityQueue is unbounded but there is a capacity that dictates the size of the array in which the elements are stored.
//    The initial capacity is equal to the size of the array but as new elements are added it expands dynamically.

    public static void main(String[] args) {

        // Instantiate PriorityQueue object named intPriorityQueue
        PriorityQueue<Integer> intPriorityQueue = new PriorityQueue<Integer>();

        // Add elements using add()
        intPriorityQueue.add(17);
        intPriorityQueue.add(20);
        intPriorityQueue.add(1);
        intPriorityQueue.add(13);
        intPriorityQueue.add(87);

        // Print the contents of PriorityQueue
        System.out.println("The contents of intPriorityQueue : ");
        System.out.println(intPriorityQueue);

        // The peek() method is used to retrieve
        // the head of the PriorityQueue
        System.out.println("\nThe head of the PriorityQueue : " + intPriorityQueue.peek());

        // The remove() method is used
        // to remove a single instance
        // of the specified object
        intPriorityQueue.remove(17);

        // Print the contents of PriorityQueue
        System.out.println("\nThe contents of intPriorityQueue after removing 17 : ");
        System.out.println(intPriorityQueue);

        // The poll() method is used
        // to retrieve and remove the
        // element at the head of the PriorityQueue
        Integer head = intPriorityQueue.poll();
        System.out.println("\nThe head of the PriorityQueue was : " + head);

        // Print the contents of PriorityQueue
        System.out.println("\nThe contents of intPriorityQueue after poll : ");
        System.out.println(intPriorityQueue);
    }

}



