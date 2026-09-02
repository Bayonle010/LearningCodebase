package Java.JavaCollections.linkedlistPQ;

public class RemoveDuplicates83 {

    static void main() {
        RemoveDuplicates83 list = new RemoveDuplicates83();
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(2);
        list.insertFirst(1);
        list.insertFirst(1);

        list.display();
        list.removeDuplicate();
        list.display();
    }



    private Node head;
    private Node tail;

    public void removeDuplicate(){
        Node node = head;

        while (node.next != null){
            if (node.value == node.next.value){
                node.next = node.next.next;
            }else {
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }


    public void display(){
        Node current = head;

        while (current != null){
            System.out.print(current.value + "-->");
            current = current.next;
        }
        System.out.println("END");
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null){
            tail = head;
        }
    }



    class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }

}
