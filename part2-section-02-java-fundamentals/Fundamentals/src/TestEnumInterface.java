/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 2: Java Fundamentals
Topic:  Enum implementing interface
*/

//  create an interface with a single method
interface DoItInterface {
    public void doIt();
}

// Declare an enum that implements an interface
enum SecondaryColors implements DoItInterface {
    ORANGE,
    PURPLE {
        // You can implement interface method in the enum constant body
        public void doIt() {
            System.out.println(this + " wants to be different");
        }
    },
    GREEN;

    // You can implement interface method in the enum body
    public void doIt() {
        System.out.println(this + " is implementing an interface's method ");
    }
}



public class TestEnumInterface {

    public static void main(String[] args) {
        TestEnumInterface e = new TestEnumInterface();

        // You can pass enum constants to a method that takes the
        // interface typed parameter
        e.printData(SecondaryColors.ORANGE);
        e.printData(SecondaryColors.PURPLE);
    }

    // This method accepts an interface typed parameter
    public void printData(DoItInterface o) {
        o.doIt();
    }
}
