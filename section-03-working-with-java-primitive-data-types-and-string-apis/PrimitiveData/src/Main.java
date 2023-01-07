public class Main {

    boolean bool2;
    public static void main(String[] args) {
        Main m1 = new Main();
        System.out.println("Hello world!");

        char c = 0x41;
        float f1 = 1_1.27_123e01_2f;
        System.out.println(f1);

        byte b1= 0b11111_11;
        System.out.println(b1);

        short s1 = 0177; // octal prefix 0
        System.out.println(s1);

        int i1 = 0x007F; // hex prefix 0x
        System.out.println(i1);

        boolean bool1; // need to initialize
        // System.out.println(bool1);

        System.out.println(m1.bool2);
    }
}