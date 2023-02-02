class A {
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
        System.out.println("--------");

        A a1 = new A();
        a1.callDisplay();
        System.out.println("--------");

        A a = new B();
        a.callDisplay();
        System.out.println("--------");

        a.staticMethod();

    }
}