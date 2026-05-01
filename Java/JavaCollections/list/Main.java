package Java.JavaCollections.list;

public class Main {
    public static void main(String[] args) {
//        CustomLinkedList list = new CustomLinkedList();
//        list.insertFirst(3);
//        list.insertFirst(7);
//        list.insertFirst(8);
//        list.insertFirst(10);
//        list.insertFirst(12);
//        list.insertLast(99);
//        list.insertFirst(15);
//        list.display();
//        System.out.println(list.deleteFirst());
//        list.display();
//        System.out.println(list.deleteLast());
//        list.display();
//        list.delete(2);
//        list.display();
//
//        list.get(0);

        DoublyLinkedList list = new DoublyLinkedList();
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(8);
        list.insertFirst(17);
        list.insertLast(20);
        list.insert(2,5);

        list.display();


    }
}
