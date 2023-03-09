class SuperClass {  // Line 1 //you cannot use the access modifier 'protected' (or 'private') on an outer class.
    static void testMe() {
        System.out.println("SuperClass");
    }
}

public class Test extends SuperClass {
    protected static void testMe() {
        System.out.println("Test");
    }  //Line 2

    public static void main(String[] args) {
        testMe();  // Line 3

        /*
         the "super" keyword in Java is used as a reference to the object of the superclass. This implies that to use
         "super" the method should be invoked by an object, which static methods are not.
         Therefore, you cannot use the "super" keyword from a static method.
         */
        //super.testMe();  // Line 4 //you cannot use 'super' in a static method.
        SuperClass.testMe(); // valid
    }
}