/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Generics, Confusing type parameters
*/

// class Container, a generic class with one type parameter
class Container<Number> {

    // instance variable
    Number myNumber; // T and not Number

    // Constructor
    Container(Number myNumber) {
        this.myNumber = myNumber;
        System.out.println(this);
    }

    // overridden toString() method
    public String toString() {
        return myNumber.toString();
    }

}

public class GenericsConfusion {
    public static void main(String[] args) {
        // Declare Container with String type argument
        Container<String> c1 = new Container<>("Hello");

        // Declare Container with String type argument
        Container<Integer[]> c2 = new Container<>(new Integer[]{1, 2, 3, 4});

        // Declare Container with UnknownError type argument
        Container<UnknownError> c3 =
                new Container<>(new UnknownError("Testing"));


        // which constructor is going to be invoked?
        CardboardContainer<String> n1 =
                new CardboardContainer<String>("Hello");

        // the compiler used type inference to determine
        // that it was the second constructor that should be called.
        CardboardContainer<String> n2 =
                new CardboardContainer<String>(3);


        CardboardContainer<String> n3 =
                new <Integer>CardboardContainer<String>(3);

        CardboardContainer<Integer> n4 =
                new <Integer>CardboardContainer<Integer>(3);

        // invalid; Cannot use diamonds with explicit type parameters for constructor
        // new <Integer>CardboardContainer<>(3);

    }
}

class CardboardContainer<T> {
    T myField;

    CardboardContainer(T myField) {
        System.out.println("In T constructor");
        this.myField = myField;
    }


    // the second constructor is using a method type parameter T,
    // which hides the type parameter T of the class
    // when used in this particular constructor.
    // So this means the type of the parameter
    // passed to this constructor may not be the same type
    // of the instance field, my field.
    // This is why the constructor declaration was allowed,
    // the overloaded constructors do not have the same signature.
    <T extends Number> CardboardContainer(T myField) {
        System.out.println("In T2 constructor");
        // this.myField = myField;
    }
}
