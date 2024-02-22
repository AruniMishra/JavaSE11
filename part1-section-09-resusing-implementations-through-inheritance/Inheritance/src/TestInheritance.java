

public class TestInheritance {
    public static void main(String[] args) {
        Super s = new Super();
        Sub sub = new Sub();
        Super ss = new Sub();
        // Sub sub1 = (Sub) new Super(); //ClassCastException: class Super cannot be cast to class Sub


        ss.notDeclaredInSubClass();

        sub.instanceMethod(); //sub instance method
        sub.staticMethod(); // sub static method

        ss.instanceMethod(); //sub instance method
        ss.staticMethod(); //super static method

        /**
         * static methods cannot be overridden.
         * referring to compilation rather than overriding (even though we says overriding).
         */

    }
}

class Super {
    static int b = 11; // static field
    int a = 11; // instance field

    public static void staticMethod() { // static method
        System.out.println("super static method");
    }

    public void instanceMethod() { // instance method
        System.out.println("super instance method");
    }

    public void notDeclaredInSubClass() {
        System.out.println("not declared in subclass");
    }
}

class Sub extends Super {
    static int b = 3; // static field
    int a = 3; // instance field

    public static void staticMethod() { // static method
        System.out.println("sub static method");
    }

    public void instanceMethod() { // instance method
        System.out.println("sub instance method");
    }
}