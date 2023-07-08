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
}

public class Tester {
    public static void main(String[] args) {
        B b = new B();
        b.callDisplay();
        System.out.println(b.x);
        System.out.println("1 end--------\n");

        A a1 = new A();
        a1.callDisplay();
        System.out.println(a1.x);
        System.out.println("2 end--------\n");

        A a = new B();
        a.callDisplay();
        System.out.println(a.x);
        System.out.println("3 end--------\n");

        a.staticMethod();
    }
}