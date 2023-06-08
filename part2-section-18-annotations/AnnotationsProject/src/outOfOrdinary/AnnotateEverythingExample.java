package outOfOrdinary;

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 17 -Annotations
Topic:  Reviewing what can be annotated
*/

// Annotating a class
@TypeAnnotation
public class AnnotateEverythingExample {

    // Annotating a field
    @AttributeAnnotation
    private String aField;

    // Annotating a constructor
    @ConstructorAnnotation
    AnnotateEverythingExample() {

    }

    public static void main(String[] args) {

        // Annotating a use of a type (TYPE_USE) in a new object
        AnnotateEverythingExample e = new @TypeUseAnnotation AnnotateEverythingExample();
        Object o = e;

        // Annotating a use of a type (TYPE_USE) while casting
        AnnotateEverythingExample e2 = (@TypeUseAnnotation AnnotateEverythingExample) o;
        e.doSomething("Hello");

    }

    // Annotating a method
    @MethodAnnotation
    // Annotating a method parameter
    void doSomething(@MethodParameterAnnotation String s) {

        // Annotating a local variable
        @LocalVariableAnnotation
        var localVariable = 1;

        System.out.println(s);

    }

    // Annotating a type parameter
    <@TypeParameterAnnotation T> T getSomething(T t) {
        return t;
    }
}

