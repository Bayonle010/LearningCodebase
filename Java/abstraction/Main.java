package Java.abstraction;

public class Main {

//    An abstract class is a class that is declared 'abstract'. It may or may not include abstract methods
//    Abstract classes cannot be instantiated, but they can be subclassed;
//    An abstract method is a method that is declared without an implementation e.g abstract void doSomething(int number, String text);
//    If a class includes an abstract method, the class itself must be declared abstract
//    NOTE: JAVA does not support multiple inheritance(i.e no such scenario where a child class will be extending from two or base classes (diamond problem), it only does with the help of Java.interfaces. )


    public static void main(String[] args) {
        GraphicObject circle = new Circle();
        circle.draw();
        circle.reSize();

        GraphicObject rectangle = new Rectangle();
        rectangle.draw();
        rectangle.reSize();
    }
}
