package Java.singleton;

// only one instance of this class is created

public class Singleton {
    private Singleton (){};

    private static Singleton instance;

    public static Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }

}
