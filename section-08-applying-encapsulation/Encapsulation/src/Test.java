class SuperClass {  // Line 1 //you cannot use the access modifier 'protected' (or 'private') on an outer class.
    static void testMe() { System.out.println("SuperClass"); }
}

public class Test extends SuperClass {
    protected static void testMe() { System.out.println("Test"); }  //Line 2

    public static void main(String[] args) {
        testMe();  // Line 3
        //super.testMe();  // Line 4 //you cannot use 'super' in a static method.
    }
}