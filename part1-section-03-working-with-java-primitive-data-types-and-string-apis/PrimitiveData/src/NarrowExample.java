public class NarrowExample {
    public static void main(String[] args) {

        // First lets print out some ranges:
        System.out.println("A byte has a range of " + Byte.MIN_VALUE + " to " + Byte.MAX_VALUE);

        // We'll show character ranges both as unicode ranges and int ranges
        System.out.println("A char has a range of " + String.format("\\u%04x  to \\u%04x", (int) Character.MIN_VALUE, (int) Character.MAX_VALUE));
        System.out.println("A char has a range of " + (int) Character.MIN_VALUE + "  to " + (int) Character.MAX_VALUE);
        System.out.println("A short has a range of " + Short.MIN_VALUE + " to " + Short.MAX_VALUE);
        System.out.println("An int has a range of " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE);
        System.out.println("A long has a range of " + Long.MIN_VALUE + " to " + Long.MAX_VALUE);

        System.out.println("A float has a range of " + Float.MIN_VALUE + " to " + Float.MAX_VALUE);
        System.out.println("A double has a range of " + Double.MIN_VALUE + " to " + Double.MAX_VALUE);

        // We will set each variable to its maximum value in its value range
        byte b = 127;
        char c = 65535;
        short s = 32767;



        /*
        Implicit narrowing occurs only between for byte, char, short, and int (for literals and final variable).
        Remember that it does not occur for long, float, or double. So, this will not compile: int i = 129L;
        However, an implicit widening conversion from long to a float or a double is valid:

        long l = 10L;
        float f = l; //valid
        double d = l; //valid
         */

        // Implicit narrowing can no longer be done because the literal does not fit the container it is assigned to.
        // byte b1 = 128;
        // char c1 = 65536;
        // short s1 = 32768;

        double d1 = 0.0;
        // float f2 = 0.0;
        // byte b2 = 0.0;
        // char c2 = 0.0;
        // short s2 = 0.0;
        // int i2 = 0.0;
        // long l2 = 0.0;


        int myIntVariable = 1; // below is valid, if this is declared as final int
        // byte b2 = myIntVariable;
        // char c2 = myIntVariable;
        // short s2 = myIntVariable;

    }
}