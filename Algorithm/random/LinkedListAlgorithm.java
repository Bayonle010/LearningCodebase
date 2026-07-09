package Algorithm.random;

public class LinkedListAlgorithm {

    private Node head;
    private Node tail;
    private int size;

    public static void main(String[] args) {
        LinkedListAlgorithm list = new LinkedListAlgorithm();
        list.insertLast(1);
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);

        // before duplicate removal
        list.display();

        list.removeDuplicate();

        // after duplicate removal
        list.display();

    }



    public void removeDuplicate(){
        Node temp = head;

        while (temp != null && temp.next != null){
            if (temp.val == temp.next.val){
                temp.next = temp.next.next;

                size--;
            }else  {
                temp = temp.next;
            }
        }
    }

    public  void display(){
        Node temp = head;
        while( temp != null){
            System.out.print(temp.val + "-->");
            temp = temp.next;
        }
        System.out.println("END");
    }


    public void insert(int val, int index){
        if (index == 0){
            insertFirst(val);
        }
        if (index == size){
            insertLast(val);
        }


        Node temp = head;

        for (int i = 1; i< index; i++ ){
            temp = temp.next;
        }

        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;


    }

    public void insertFirst(int val){
        Node temp = new Node(val);

        temp.next = head;
        head = temp;

        if (tail == null){
            tail = head;
        }
        size++;
    }

    public void insertLast(int val){
        Node temp =  new Node(val);

        if (tail == null){
            insertFirst(val);
            return;
        }

        tail.next = temp;
        tail = temp;
        size++;
    }



    private class Node{
        int val;
        Node next;

        public Node(int val){
            this.val = val;
        }

        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }

}
