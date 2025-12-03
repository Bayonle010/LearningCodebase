package Java.serializationconcept;

import java.io.*;

public class Main {
   /* Serialization of an Object is the process of converting the state of the object to a byte stream so that the byte stream can be reverted into a copy of the object

    Deserialization is the process of converting the serialized form of an object  back into a copy of the object

    */

    public static void main(String[] args) {

        Profile object = new Profile(5, "Bayonle");

        String fileName = "file.txt";

        // SERIALIZATION

        try{
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(object);
            out.close();
            file.close();
            System.out.println("Object has been serialized");

        }catch (IOException e){
            System.out.println("IOE exception caught with message  ----->> " + e.getMessage());
        }

        Profile object1 = null;
        //DESERIALIZATION
        try {
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);

            object1 = (Profile) in.readObject();
            in.close();
            file.close();

            System.out.println("Object has been deserialized " );
            System.out.println("age = " + object1.getAge());
            System.out.println("name = " + object1.getName());

        } catch (IOException e) {
            System.out.println("IOE exception caught with message ---->>  " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFound exception is caught with message ---->> " + e.getMessage());
        }

    }
}
