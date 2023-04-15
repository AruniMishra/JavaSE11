interface Base {

    static void myStaticMethod() {
        System.out.println("my static method");
    }

    default void sayHi() {
        System.out.println("hi from base");
        myStaticMethod();
    }
}

interface Foo extends Base {
    @Override
    default void sayHi() {
        System.out.println("hi from foo");


        // An interface does not inherit static methods from its superinterfaces.
        // myStaticMethod(); // Invalid

        // below is valid:
        Base.myStaticMethod();
    }
}

interface Bar extends Foo, Base {
}

public class MyClass implements Foo, Bar {
    public static void main(String[] args) {
        MyClass c = new MyClass();
        c.sayHi();

        Base.myStaticMethod();
    }
}