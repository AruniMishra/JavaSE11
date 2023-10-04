/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 2: Java Fundamentals
Topic:  Enum Extras
*/
enum PrimaryColor {
    RED(1) {
        {
            // initializer for the individual class constants
            System.out.println(this + " initialized");
        }
    },
    BLUE(2) {

        {
            // initializer for the individual class constants
            System.out.println(this + " initialized");
        }
    },
    YELLOW(3) {
        {
            // initializer for the individual class constants
            System.out.println(this + " initialized");
        }
    };

    int rating = 0;

    // static initializer for the PrimaryColor class (enum)
    static {
        System.out.println("Enum Class Initialization");
    }

    // initializer for
    // all the anonymous class constants
    {
        System.out.println("---\nEnum Body Initialization for " + this);
    }

    // Constructor
    PrimaryColor(int rating) {
        // Enum constructor is invoked once for every constant.
        System.out.println("Primary Color constructor for " + this);
        this.rating = rating;
    }
}

public class EnumExtras {
    public static void main(String[] args) {
        // for (PrimaryColor color : PrimaryColor.values()) {
        //     System.out.println(color);
        // }

        System.out.println(PrimaryColor.RED);
        System.out.println(PrimaryColor.BLUE);
        System.out.println(PrimaryColor.YELLOW);
    }
}