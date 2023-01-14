public class Test {
    static int testVariable;

    public static void main(String[] args) {
        int i, j;
        for (i = 100, j = 0; i <= 300; i += 90, j++) { // Line 1
            testVariable = i % 50;   //  Line 2
            System.out.print(testVariable + " "); // Line 3
        }
        System.out.println(j);
    }
}