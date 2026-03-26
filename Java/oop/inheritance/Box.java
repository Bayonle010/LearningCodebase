package Java.oop.inheritance;

public class Box {
    private double l;
    double w;
    double h;


    Box(){
        this.l = l;
        this.w = w;
        this.h = h;
    }

    Box(double l, double w, double h){
        this.l = l;
        this.w = w;
        this.h = h;
    }

    Box(Box old){
        this.l = old.l;
        this.w = old.w;
        this.h = old.h;

    }
}
