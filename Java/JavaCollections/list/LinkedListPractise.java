package Java.JavaCollections.list;

import java.util.LinkedList;

public class LinkedListPractise {

    private Node head;
    private Node tail;


     void main() {
        LinkedList<Integer> hmm = new LinkedList<>();
        hmm.add(1);
        hmm.add(2);
        hmm.add(3);
        hmm.add(4);

        display();


    }


    public void display(){
        Node temp = head;

        while (temp != null){
            System.out.print(temp.value + "-->");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void insertFirst(int value){
        Node temp = new  Node(value);
        temp.next = head;
        head = temp;

        if (tail == null){
            tail = head;
        }
    }

    public void insertLast(int value){
        if (tail == null){
            insertFirst(value);
            return;
        }
        Node temp = new Node(value);
        tail.next = temp;
        tail = temp;
    }

    public  void reverse(){
        Node previous = null;
        Node current = head;

        while (current != null){
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }







    class Node{
        private int value;
        private Node next;


        public Node(int value){
            this.value = value;
        }

    }

}
