package outOfOrdinary;


/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 17 - Annotations
Topic:  Reviewing where TYPE_USE annotation can be used
*/

interface ContainingInterface<@TypeUseAnnotation T> {

    public T doThat();

    // Using TYPE_USE Annotation for a method parameter
    public default <S> S doThis(@TypeUseAnnotation S s) {
        return s;
    }
}

// Using TYPE_USE Annotation for a type
@TypeUseAnnotation
class ParentOfClass {

    // Using TYPE_USE Annotation fo a Constructor
    @TypeUseAnnotation ParentOfClass() {

    }
}

// USING TYPE_USE at the TYPE level
@TypeUseAnnotation
// Using TYPE_USE Annotation in extends and implements clauses
public class TypeUseAnnotationsExample extends @TypeUseAnnotation ParentOfClass
        implements @TypeUseAnnotation ContainingInterface<ParentOfClass> {

    // Using TYPE_USE to annotate type for a field
    private @TypeUseAnnotation String privateAttribute;

    public static void main(String[] args) {

        // Using TYPE_USE when creating a variable using a type argument.
        ContainingInterface<@TypeUseAnnotation String> c;

        try {
            System.out.println("Testing Type Use");
            // Using TYPE_USE annotation in a catch clause
        } catch (@TypeUseAnnotation Exception e) {
            // Using TYPE_USE annotation in a throws clause
            throw new @TypeUseAnnotation RuntimeException("whoops");
        }
    }

    // Using TYPE_USE for a method return type
    public @TypeUseAnnotation TypeUseAnnotationsExample doThat() {
        return this;
    }
}
