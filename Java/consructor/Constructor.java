package Java.consructor;

public class Constructor {
    public static void main(String[] args) {
        Person a = new Person("A");
        Person b = new Person("B");
        swap(a, b);
        System.out.println(a.name + ", " +b.name);
    }

    static void swap(Person p1, Person p2) {
        Person temp = p1;
        p1 = p2;
        p2 = temp;
    }
}
