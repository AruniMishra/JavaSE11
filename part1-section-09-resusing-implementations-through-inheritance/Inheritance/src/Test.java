abstract class AbstractClass {

    static void printFamilyTree() {

    }

    final void myOwnMethod() {  // Line 1
        System.out.println("my own");
    }

    void familyMethod() {
        System.out.println("my family");
        printFamilyTree();  // Line 2
    }
}

public abstract class Test extends AbstractClass {  // Line 3
    public static void main(String[] args) {
        printFamilyTree();
    }


    protected static void printFamilyTree() {   // Line 4
//        Test t = new Test();   // Line 5 //cannot create an instance of an abstract class.
        Test.printFamilyTree();  // Line 6
    }
}