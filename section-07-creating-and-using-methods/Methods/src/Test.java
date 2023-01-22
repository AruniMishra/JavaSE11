public class Test {
    String getMyName() {
        return myName;   // Line 1
    }

    static String myName = "Test";

    public static void main(String[] args) {

        try {
            Test t1 = new Test();
            Test t2 = null;
            System.out.print(Test.myName);
            System.out.print(t1.myName);  // Line 2
            System.out.print(t1.getMyName());

            System.out.print(t2.myName);  // Line 3
            System.out.print(t2.getMyName());    // Line 4
        } catch (Exception e) {
            System.out.println();
        }
    }
}