package Java.abstraction;

public abstract class GraphicObject {
    int x,y;

    void move(int newX, int newY){
        System.out.println("move to x: " + x + "and" + y);
    }

    abstract void draw();
    abstract void reSize();

}
