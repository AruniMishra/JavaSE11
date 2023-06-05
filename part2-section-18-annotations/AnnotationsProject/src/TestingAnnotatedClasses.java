/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 17 -Annotations
Topic:  Annotations

In the output folder:
javac -d . -cp . -processor AnnotationProcessor ..\..\..\src\TestingAnnotatedClasses.java

*/

import annotations.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;


/*
not inherited (i.e. not through an interface)
 */
@MySecondInheritedAnnotation
interface SomeInterface {

    @MySecondInheritedAnnotation
    void interfaceMethod();
}

/*
MyFirstInheritedAnnotation, which annotated the ParentClass and not
the "TestingAnnotatedClasses" is considered an annotation of the "TestingAnnotatedClasses" and is inherited,
if the @Inherited annotation is used on the annotation declaration.

The inherited annotation is only inherited at the type level and only for a class(not for method,
fields, parameter, etc)
 */
@MyFirstInheritedAnnotation
abstract class ParentClass {

    @MyFirstInheritedAnnotation
    public abstract void abstractMethod();
}


// -----------------------------------------------------------------------------------------------------------------
// Apply annotations to the class
// @MyClassAnnotation() // this becomes invalid if 'MyClassAnnotation' annotated with @Target(ElementType.FIELD)
// @MySourceAnnotation() // this becomes invalid if 'MySourceAnnotation' annotated with @Target(ElementType.METHOD)
@MyRuntimeAnnotation(author = "Aruni", version = 0.1, description = "testing annotations")

// --Marker Annotation,  Repeatable
@MyRepeatableAnnotation // first occurrence

// --Single Element Annotation,  Repeatable
// Do not have to specify element name if it is 'value'
@MyRepeatableAnnotation(10) // value passed is 10; 2nd occurrence
@MyRepeatableAnnotation(2) // 3rd occurrence
@MyRepeatableAnnotation(value = 132)
public class TestingAnnotatedClasses
        extends ParentClass
        implements SomeInterface {

    @MyClassAnnotation() // valid here
    String MyField = "AnnotatedField";

    public static void main(String[] args) {
        new TestingAnnotatedClasses().printRuntimeAnnotations();

        MyRepeatableAnnotation[] myRepeatableAnnotations =
                TestingAnnotatedClasses.class.getAnnotationsByType(MyRepeatableAnnotation.class);
        Arrays.stream(myRepeatableAnnotations).map(myRepeatableAnnotation -> "value: " + myRepeatableAnnotation.value()).forEach(System.out::println);
    }

    // reflection methods used to get information about class, methods,
    // fields
    @MySourceAnnotation()
    public void printRuntimeAnnotations() {
        Class c = this.getClass();

        showAnnotations(c);
        for (Method method : c.getDeclaredMethods()) {
            showAnnotations(method);
        }
        for (Field field : c.getDeclaredFields()) {
            showAnnotations(field);
        }
    }

    // Gets declared annotations, not inherited ones
    public void showAnnotations(Object e) {
        Annotation[] annotations = null;


        if (e instanceof Class) {
            // annotations = ((Class) e).getDeclaredAnnotations();
            annotations = ((Class) e).getAnnotations();

        } else if (e instanceof Method) {
            // annotations = ((Method) e).getDeclaredAnnotations();
            annotations = ((Method) e).getAnnotations();
        } else if (e instanceof Field) {
            // annotations = ((Field) e).getDeclaredAnnotations();
            annotations = ((Field) e).getAnnotations();
        }

        for (Annotation annotation : annotations) {
            System.out.println(e.getClass().getSimpleName() + " Annotation: " + annotation);
        }


    }


    // Implementing abstract method of ParentClass
    public void abstractMethod() {
        System.out.println("Implemented abstractMethod");
    }

    // Implementing interface's Method
    public void interfaceMethod() {
        System.out.println("Implemented interfaceMethod");
    }

}
