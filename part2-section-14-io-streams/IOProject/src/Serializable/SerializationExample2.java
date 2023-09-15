package Serializable;

import java.io.*;

class Boo {
    public Boo() {
        System.out.println("In Boo");
    }
}

class BooBoo extends Boo {
    public BooBoo() {
        System.out.println("In BooBoo");
    }
}

class Moo extends BooBoo implements Serializable {
    int moo = 10;

    {
        System.out.println("moo set to 10");
    }

    public Moo() {
        System.out.println("In Moo");
    }

    @Override
    public String toString() {
        return "Moo{" +
                "moo=" + moo +
                "} ";
    }
}

public class SerializationExample2 {

    /*
    During deserialization, the constructor of the class (or any static or instance blocks) is not executed.
    However, if the super class does not implement Serializable, its constructor is called.
    So here, BooBoo and Boo are not Serializable. So, their constructor is invoked.
     */

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String fileName = "moo1.ser";
        Moo moo = new Moo();
        moo.moo = 20;
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(moo);
        os.close();

        System.out.println("-----------");

        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream is = new ObjectInputStream(fis);
        Moo moo2 = (Moo) is.readObject();
        is.close();
        System.out.println(moo2);

    }
}
