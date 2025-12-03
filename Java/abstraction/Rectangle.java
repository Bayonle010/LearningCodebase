package Java.abstraction;

public class Rectangle extends GraphicObject{
    @Override
    void draw() {
        System.out.println("drawing a rectangle");
    }

    @Override
    void reSize() {
        System.out.println("reSizing a rectangle");
    }
}
