interface Rideable {
    void ride(String name);
}

interface X1 {
    default void print() {
        System.out.println("X1");
    }

}

interface X2 extends X1 {
    /*
    An interface in java can override the default method of super type with abstract modifier.
     */
    void print();
}

interface X3 extends X2 {
    /*
    An interface in java can implement the abstract method of super type with default modifier.
     */
    default void print() {
        System.out.println("X3");
    }
}

class Animal1 {
}

class Horse extends Animal1 implements Rideable {
    public void ride(String name) {
        System.out.println(name.toUpperCase() + " IS RIDING THE HORSE");
    }
}

public class Test21 {
    public static void main(String[] args) {
        Animal1 horse = new Horse();
        /*INSERT*/

        ((Horse) horse).ride("");
        ((Rideable) horse).ride("");
        ((Rideable) (Horse) horse).ride("");

        ((Horse) (Rideable) horse).ride("");

    }
}


 abstract interface Printable {
     public static final int x = 10;
     public final int y = 20;
     int z = 30;
 }