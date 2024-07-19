/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 2: Java Fundamentals
Topic:  Nested Class, local Class, effectively final review
*/

// Simple class demonstrating a local class in a method
public class EffectivelyFinal {

    static int a = 0;
    int b = 0;

    public static void main(String[] args) {

        // Create a local variable and assign it a value
        // Variable 'efinal' is accessed from within method local inner class, needs to be final or effectively final
        int efinal = 1;
        // efinal++;

        // Local Class created with a single method that
        // uses the efinal local variable just created
        class LocalClass {
            public void printValue() {
                // efinal++;
                a++;
                System.out.println("efinal = " + efinal);
            }
        }

        // not permitted here
        // efinal++;

        // Execute method on the local class
        new LocalClass().printValue();
    }

    class LocalClass2 {
        public void printValue() {
            // efinal++;
            b++;
            System.out.println("b = " + b);
        }
    }
}