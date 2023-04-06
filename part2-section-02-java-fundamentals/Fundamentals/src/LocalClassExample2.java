interface Executable {
    void doSomething();
}

abstract class AbstractClass {

    int a;

    public abstract void doSomething();
}

public class LocalClassExample2 {
    String name = "Doe";

    public static void main(String[] args) {
        String name = "Smith";

        // Local class can extend any class, including abstract one
        class A extends AbstractClass {
            public void doSomething() {
                System.out.println("name = " + name);
            }
        }

        // Local class can implement interfaces
        class B implements Executable {

            public void doSomething() {
                System.out.println("name = " + name);
            }
        }

        // Declaring a local abstract class
        abstract class C extends AbstractClass {

        }

        // Create a local class extending another local class
        class D extends C {
            public void doSomething() {
                System.out.println("name = " + name);
            }
        }

        // Execute code on instances of local classes
        new A().doSomething();
        new B().doSomething();
        new D().doSomething();
    }
}
