package inner;

// Enclosing Class
public class EnclosingClass {

    // instance field on enclosing class
    public String outerName = "outer";

    // instance field of the type of the inner class
    public InnerMemberClass innerMemberClass = new InnerMemberClass();


    // Add Constructor
    EnclosingClass(String name) {
        this.outerName = name;
    }

    // instance method on enclosing class
    public void doSomethingOnInstance() {
        System.out.print("doSomethingOnInstance invoked: ");
        // invoke nested class's method via class reference
        System.out.println(new InnerMemberClass().getInstanceName());
    }

    // Begin declaration of non-static inner member class named InnerMemberClass
    public class InnerMemberClass {

        // valid: static final field
        public static final String staticName = "staticName";
        // instance field
        public String instanceName = "InnerMemberClass.instanceName";

        // outerName = "outer"; // invalid here
        // shadow the outer class attribute
        public String outerName = "outer";

        // instance method
        public String getInstanceName() {
            outerName = "outer"; // valid here
            return "getInstanceName() = " + this.instanceName;
        }


        /*
        Java 17 OCP exam inner classes now can have static members, however static members generate runtime error;
        Static declarations in inner classes are not supported at language level '11';
        'static' is only allowed in constant variable declarations
         */

        // invalid: static field
        // public static String staticName1 = "staticName";

        // invalid: static method: Inner(non-static) classes can't have static methods though
        // public static String getStaticName() { return "getStaticName() = " + staticName; }



        /*
        enum and interface implicit are static hence not valid
         */
        // public enum Colors { RED, BLUE, YELLOW }

        // public interface NestedInterface {}

        // Every non-static inner class object has a reference to its outer class object which can be accessed by doing OuterClass.this.
        public String getOuterName() {
            // Local variable shadows inner class member which in turn
            // shadows outer class's member.  Here we access all 3
            String outerName = "local_outerName";
            return outerName + " : " +
                    this.outerName + " : " +
                    EnclosingClass.this.outerName;
        }


    }  // Ends declaration of the inner member class

}

// This class tests the EnclosingClass and it's inner member class
// using a disassociated class.
class TestEnclosingClass {

    public static void main(String[] args) {
        EnclosingClass e = new EnclosingClass("e's instance");
        e.doSomethingOnInstance();

        // new EnclosingClass.InnerMemberClass().getInstanceName(); invalid


        // InnerMemberClass i; // need to import class
        // We can declare a local variable of the inner class
        EnclosingClass.InnerMemberClass i; // InnerMemberClass is not a static class, it must have an associated outer class instance.


        // But instantiating this way does not work...
        /*
        an inner member class can't exist without an instance of the enclosing class existing first.
         */
        // i = new EnclosingClass.InnerMemberClass();
        // i = new e.InnerMemberClass();

        // You must use the instance new operator, much like a method.
        i = e.new InnerMemberClass();
        i = new EnclosingClass("e's instance").new InnerMemberClass();


        System.out.println("-----------------------------------------");

        // Use local variable referencing the inner member class to
        // access method on the inner class
        System.out.println("Invoking i.getOuterName: " + i.getOuterName());

        // Create another instance of the Enclosing Class
        EnclosingClass f = new EnclosingClass("f's Instance");

        // Declare and Assign a variable to the inner member class of
        // new instance in a single statement
        EnclosingClass.InnerMemberClass j = f.new InnerMemberClass();
        System.out.println("Invoking j.getOuterName: " + j.getOuterName());


        // invalid with class name (InnerMemberClass)
        // e.InnerMemberClass.instanceName = "Testing";
        // System.out.println(e.InnerMemberClass.getInstanceName());

        // valid, using the instance field
        e.innerMemberClass.instanceName = "Testing";
        System.out.println(e.innerMemberClass.getInstanceName());

    }
}

class TestClass {
    public static void main(String[] args) {
        class C {
        }

        new TestClass().new A(); // class A is not static inner class of TestClass. So it cannot exist without an outer instance of TestClass.
        // this.new A(); // Keyword 'this' is not allowed inside static main method.
        // new A(); // 'inner.TestClass.this' cannot be referenced from a static context,
        // new TestClass.A();

        new B(); // for static allowed
        new TestClass.B();
        // new TestClass().new B();

        new C();
        // new TestClass().new C();
        // new TestClass.C();
    }

    void nonstaticUseClasses() {
        // the method useClasses() is an instance method. So, it already has instance of outer class associated with it.
        // So, new A(); is also valid. new TestClass.A(); is same as new A().
        new TestClass().new A();
        this.new A();
        new A();
        new TestClass.A();

        TestClass.A a = new TestClass().new A();
        A a2 = new TestClass().new A();

        new B();
        new TestClass.B();
        // new TestClass().new B(); // Qualified new of static class
    }

    public static class B {
    }

    class A {
    }
}

class Test {
    public static void main(String[] args) {
        //Insert statement here
        TestClass.A a = new TestClass().new A();

        // main method is outside Outer class only, so inner class's name can be referred by 2 ways only: Outer.Inner or var.
        // A a2 = new TestClass().new A();


        // new B();
        new TestClass.B();
    }
}
