// The MixAndMatch class has 3 constructors to demonstrate
// constructor overloading and constructor chaining
class MixAndMatch {
    static int counter = 0;
    String mix;
    String match;
    String mixAndMatch;

    // MixAndMatch constructor, no parameters
    MixAndMatch() {
        counter++;
    }

    /*
    There is a difference between super() and this().

    super()- calls the base class constructor whereas
    this()- calls current class constructor.

    Both this() and super() are constructor calls.
    Constructor call must always be the first statement. So you either have super() or this() as first statement.
     */

    // MixAndMatch constructor, one parameter
    MixAndMatch(String mixAndMatch) {
        // constructor chaining - call the no args constructor
        this();
        this.mixAndMatch = mixAndMatch;
        System.out.println("mixAndMatch = " + this.mixAndMatch +
                " for instance # " + counter);
    }

    // MixAndMatch constructor, two parameters
    MixAndMatch(String mix, String match) {
        // constructor chaining - call the single parameter constructor
        this(mix + " and " + match);
        this.mix = mix;
        this.match = match;
    }
}

public class ConstructorOverload {
    public static void main(String[] args) {

        // Test a variety of constructors
        new MixAndMatch("Mix", "Match");
        new MixAndMatch("Mix or Match");
        new MixAndMatch();
        new MixAndMatch("Not this", "Not that");

    }
}