class MixItUpClass {
    static int statementOrder;

    int a = clarify("assigning a", statementOrder);
    // we reference variable declared above in declaration and assignment
    int b = clarify("assigning b", this.a);
    // we reference variable declared above in declaration and assignment
    int c = clarify("assigning c", this.b);
    int d;

    //  initializer 1
    {
        // we reference variable declared above in initializer statement
        clarify("initializer 1", this.a);
    }

    //  initializer 2
    {
        // we reference variable declared above in initializer statement
        clarify("initializer 2", this.b);
    }

    //  initializer 3
    {
        // we reference variable declared above in initializer statement
        clarify("initializer 3", this.c);
    }

    // Constructor
    MixItUpClass() {
        // we reference variable declared below in constructor statement
        d = clarify("constructor", this.d);
    }

    int clarify(String message, int passedVariable) {
        statementOrder++;
        System.out.println(statementOrder + " " + message);
        return statementOrder;
    }

    public String toString() {
        return this.a + ", " + this.b + ", " + this.c + ", " + this.d;
    }
}

public class InitializerOrderMore {
    public static void main(String[] args) {
        System.out.println(new MixItUpClass());
    }
}