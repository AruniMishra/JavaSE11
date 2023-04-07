/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 2: Java Fundamentals
Topic: Enum Type
*/

public enum PinochleMeld {
    // -- Begin the enum constants list
    PINOCHLE(4) {
        // describe() overrides abstract method declared in enum body
        public void describe() {
            System.out.println(this + ": Jack of Diamonds, Queen of Spades");
        }

        // Declaring a public method does not mean it will be
        // accessible to the outside world...
        public void printSomeAdditionalInfo() {
            System.out.println("Two pinochles is rare and is 30 points");
        }


    },
    MARRIAGE(2) {
        // This method declared in an enum constant body block
        int adjustScore() {
            return 2;
        }

        // describe() overrides abstract method declared in enum body
        public void describe() {
            System.out.println(this + ": King and Queen of a single suit");
        }
    },
    //..... ADDITIONAL ITEMS would go here ....
    NINE_OF_TRUMP(1) {
        // describe() overrides abstract method declared in enum body
        public void describe() {
            System.out.println(this + ": Nine of trump suit");
        }
    };  // Note the semi-colon here end of constants.

    // -- Begin the enum body declaration
    protected int score;

    PinochleMeld(int score) {
        this.score = score;
    }

    // An enum body can have a concrete method which the enum constant
    // bodies can optionally override.
    int adjustScore() {
        return 0;
    }

    // Method each constant would need to override...
    abstract public void describe();
}

class PinochleGame {

    // main method demonstrates use of an enum constant method
    public static void main(String[] args) {
        int count = 0;

        // You can declare an array of the enum type...
        PinochleMeld[] hand = {
                PinochleMeld.PINOCHLE,
                PinochleMeld.MARRIAGE,
                PinochleMeld.NINE_OF_TRUMP};

        // Loop through player's hand (represented by the array hand)
        for (PinochleMeld points : hand) {

            System.out.println(points + " points.score: " + points.score +
                    ",  points.adjustScore(): " + points.adjustScore());
            // Add up scores using the adjustScore in the enum
            // constant (if it overrides the one in the enum body.
            count += (points.score + points.adjustScore());

            // Accessing an enum constant's public method only allowed if
            // the method is declared in enum body with appropriate modifiers
            // points.printSomeAdditionalInfo();

        }

        System.out.println("Example meld score = " + count);
    }
}
