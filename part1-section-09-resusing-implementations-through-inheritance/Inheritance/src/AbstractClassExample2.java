// Abstract Class
abstract class ConceptualClass {

    // protected no args Constructor
    private ConceptualClass() {
        // not visible in child class
    }


    /**
     * it is said that the abstract class can force the call of an abstract method, in the instantiation of an object,
     * that is forced to implement the method.
     *
     * @param s1
     */
    protected ConceptualClass(String s1) {
        printSomething(s1);
    }

    // abstract method
     abstract void printSomething(String s1);
}

// Concrete Class
class RealClass extends ConceptualClass {


    RealClass(String s1) {
        super(s1);
    }

    RealClass(String s1, String s2) {
        super(s1);
    }


    // implements abstract method
    protected void printSomething(String s1) {
        System.out.println(s1);
    }
}

public class AbstractClassExample2 {
    public static void main(String[] args) {

        // Create an instance of Concrete class with no args constructor
        RealClass c = new RealClass("test");

        // Execute method on object with the standard text.
        c.printSomething("Hello World");

    }
}