package Java.JavaCollections.list;

import java.util.*;
public class StackExample {
//    The stack class extends from the Vector class. The Stack is a last-in-first-out ( LIFO ) structure.
//    You can visualize it as a stack of books on a table the book that is kept first has to e retrieved last, and the book that is kept on the stack last has to be retrieved first.
//    The basic methods of the stack class are push, pop, peek, empty, and search.
public static void main(String[] args) {

    // Instantiate a Stack named strStack
    Stack<String> strStack = new Stack<String>();

    // Add elements using the push() method
    strStack.push("Stack");
    strStack.push("a");
    strStack.push("is");
    strStack.push("This");

    // The size() method gives the
    // number of elements in the Stack
    System.out.println("The size of the Stack is : " + strStack.size());

    // The search() method is
    // used to search an element
    // it returns the position of
    // the element
    int position = strStack.search("a");
    System.out.println("\nThe string 'a' is at position " + position);

    System.out.println("\nThe elements of the stack are : ");
    String temp;
    int num = strStack.size();

    for(int i = 1; i <= num; i++)
    {
        // peek() returns the topmost element
        temp = strStack.peek();
        System.out.print(temp + " ");

        // pop() removes the topmost element
        strStack.pop();

    }

}
}
