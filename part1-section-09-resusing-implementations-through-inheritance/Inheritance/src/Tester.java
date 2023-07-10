import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class A {

    /*
    instance variables CANNOT be overridden in Java. In Java, only methods can be overridden.
     */
    public int x = 0;

    public static void staticMethod() {
        System.out.println("A.staticMethod");
    }

    private void display() {
        System.out.println("A.display");
    }

    public void callDisplay() {
        System.out.println("A.callDisplay");
        display();
    }

    public void foo(Collection arg) {
        System.out.println(this.getClass().getSimpleName() + "'s Collection foo");
    }
}

class B extends A {

    public int x = 1;

    public static void staticMethod() {
        System.out.println("B.staticMethod");
    }

    private void display() {
        System.out.println("B.display");
    }

    public void callDisplay() {
        System.out.println("B.callDisplay");
        display();
    }

    public void foo(Collection arg) {
        System.out.println(this.getClass().getSimpleName() + "'s Collection foo");
    }

    public void foo(List arg) {
        System.out.println(this.getClass().getSimpleName() + "'s List foo");
    }
}

public class Tester {
    public static void main(String[] args) {
        B b = new B();
        b.callDisplay();
        System.out.println(b.x);
        System.out.println("1 end--------\n");

        A a = new A();
        a.callDisplay();
        System.out.println(a.x);
        System.out.println("2 end--------\n");

        A aToB = new B();
        aToB.callDisplay();
        System.out.println(aToB.x);
        System.out.println("3 end--------\n");


        aToB.staticMethod();
        System.out.println("4 end--------\n");


        b = (B) aToB; // this is ok.
        System.out.println("5 end--------\n");


        List<String> list = new ArrayList<>();

        b.foo(list); // B's List foo

        // because the reference type(Base class) determines which method will be called so
        // overridden method will be called by the compiler.
        aToB.foo(list); // B's Collection foo
        System.out.println("6 end--------\n");

        b = (B) a; // ClassCastException
        b.callDisplay();
    }
}