/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 7: Creating and Using Methods
Topic: Create Methods and Constructors
Sub-Topic: Overloaded Methods
*/
class WhichOne {
    /*
    Phase 1:
    subtypes are consider to climb up either of the branches
    - byte, short, int
    - char, int, long, float, double
    <br>

    Phase 2:
    Allows boxing and unboxing

    Phase 3:
    Allows overloading to be combined with variable arity
     */

    public String thisOne(Integer i) {
        return "Integer matched";
    }

    public String thisOne(long i) {
        return "long matched";
    }

    public String thisOne(short s) {
        return "short matched";
    }

    public String thisOne(char... c) {
        return "char matched";
    }

    // Adding a method with matching wrapper
    public String thisOne(Character c) {
        return "Character matched";
    }
}

public class OverloadMatches {
    public static void main(String[] args) {
        WhichOne whichOne = new WhichOne();
        char c = 'a';
        System.out.println("Method (" + whichOne.thisOne(c) +
                ") was executed for " + c);

    }
}