package Java.abstraction;

public class Circle extends GraphicObject{
    @Override
    void draw() {
        System.out.println("draw a circle");
    }

    @Override
    void reSize() {
        System.out.println("resizing a circle");
    }
}
