import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class A {

    // A() {
    //     System.out.println("A' constructor");
    //     callDisplay();
    // }

    /*
    instance variables CANNOT be overridden in Java. In Java, only methods can be overridden.
     */
    public int x = 0;

    public static void staticMethod() {
        System.out.println("A.staticMethod");
    }

    private void privateADisplay() {
        System.out.println("A.privateADisplay");
    }

    public void callDisplay() {
        System.out.println("A.callDisplay");
        privateADisplay();
    }

    public void foo(Collection arg) {
        System.out.println("A's Collection foo");
    }
}

class B extends A {

    // B() {
    //     System.out.println("B' constructor");
    //     callDisplay();
    // }

    public int x = 1;

    public static void staticMethod() {
        System.out.println("B.staticMethod");
    }

    private void privateBDisplay() {
        System.out.println("B.privateBDisplay");
    }

    public void callDisplay() {
        System.out.println("B.callDisplay");
        privateBDisplay();
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

        A a = new A();
        a.callDisplay();
        a.staticMethod();
        System.out.println(a.x);
        System.out.println("1 end--------\n");

        B b = new B();
        System.out.println("calling b.callDisplay()");
        b.callDisplay();
        b.staticMethod();
        System.out.println(b.x);
        System.out.println("2 end--------\n");

        A aToB = new B();
        aToB.callDisplay();
        aToB.staticMethod(); // A.staticMethod
        System.out.println(aToB.x);
        System.out.println("3 end--------\n");


        // superclass object cannot be assigned to subclass
        // i.e. subtype can't refer to an instance of super type
        // B b1 = (B) new A(); // invalid, ClassCastException
        // b = (B) new A(); // invalid, ClassCastException
        // b = (B) a; // invalid, ClassCastException

        // note: below, superclass reference points to subclass object.
        b = (B) aToB; // ok, superclass reference cannot be assigned to subclass(or interface) reference without explicit cast.
        System.out.println("4 end--------\n");


        List<String> list = new ArrayList<>();
        b.foo(list); // B's List foo
        // because the reference type(Base class) determines which method will be called so
        // overridden method will be called by the compiler.
        aToB.foo(list); // B's Collection foo
        System.out.println("6 end--------\n");


        // a = (A) b; // valid, comment this for below code
        // a = b; // valid, without casting, comment this for below code

        b = (B) a; // ClassCastException
        // b.callDisplay();
    }


}


/*
Note that method print() is overridden in class B. Due to polymorphism, the method to be executed is selected depending on the class of the actual object.
Here, when an object of class B is created, first B's default constructor (which is not visible in the code but is automatically provided by the compiler because B does not define any constructor explicitly) is called. The first line of this constructor is a call to super(), which invokes A's constructor. A's constructor in turn calls print(). Now, print is a non-private instance method and is therefore polymorphic, which means, the selection of the method to be executed depends on the class of actual object on which it is invoked. Here, since the class of actual object is B, B's print is selected instead of A's print. At this point of time, variable i has not been initialized (because we are still in the middle of initializing A), so its default value i.e. 0 is printed.


Finally, 4 is printed.
 */

class A1 {
    int a = 1;

    A1() {
        print();
    }

    void print() {
        System.out.print("A ");
    }
}

class B1 extends A1 {


    int i = 4; // Try this code after declaring i in class B as final and observe the output.

    public static void main(String[] args) {
        A1 a = new B1();
        System.out.println(a.a);
        a.print();
    }

    void print() {
        System.out.println("B: " + i + " ");
    }
}


interface A2 {
    static int a = 0;
    static void method(){
        System.out.println(a);
    }
}

interface B2 extends A2{
    // int a = 2;

    public default void method(){
        System.out.println(a);
    }
}

class C2 implements B2{
    @Override
    public void method(){
        System.out.println(a);
    }
}

class C3 extends C2{
    public void method(){
        System.out.println(a);
    }
}


//----------


interface A59 {
   public Iterable a();
}

interface B59 extends A59{
    public Collection a();
}

interface C59 extends A59{
    @Override
    public Path a();
}

// interface D59 extends B59, C59{
//
// }




class q58 {
    public static void main(String[] args) {
        AnotherClass ac = new AnotherClass();
        SomeClass sc = new AnotherClass();
        ac = (AnotherClass) sc;
        // sc = ac;
        sc.methodA();
        ac.methodA();
    }
}

class SomeClass {
    public void methodA() {
        System.out.println("Some Class #methodA ()");
    }
}

class AnotherClass extends SomeClass {
    public void methodA() {
        System.out.println("AnotherClass#methodA() ");
    }
}
