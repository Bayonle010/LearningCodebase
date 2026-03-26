package Java.oop.inheritance;

public class BoxWeight extends Box{
    double weight;

    BoxWeight(){
        this.weight = -1;
    }

    BoxWeight(double l, double w, double h, double weight){
        super(l,w,h);
        this.weight = weight;
    }
}
