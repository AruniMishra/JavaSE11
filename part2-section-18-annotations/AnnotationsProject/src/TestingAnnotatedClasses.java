/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 17 -Annotations
Topic:  Annotations

In the output folder:
javac -d . -cp . -processor AnnotationProcessor ..\..\..\src\TestingAnnotatedClasses.java

*/

import annotations.MyClassAnnotation;
import annotations.MyRuntimeAnnotation;
import annotations.MySourceAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// Apply annotations to the class
// @MyClassAnnotation() // this becomes invalid if 'MyClassAnnotation' annotated with @Target(ElementType.FIELD)
// @MySourceAnnotation() // this becomes invalid if 'MySourceAnnotation' annotated with @Target(ElementType.METHOD)
@MyRuntimeAnnotation(author = "Aruni", version = 0.1, description = "testing annotations")
public class TestingAnnotatedClasses {

    @MyClassAnnotation() // valid here
    String MyField = "AnnotatedField";

    public static void main(String[] args) {
        new TestingAnnotatedClasses().printRuntimeAnnotations();

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
        if (e instanceof Class) annotations =
                ((Class) e).getDeclaredAnnotations();
        else if (e instanceof Method) annotations =
                ((Method) e).getDeclaredAnnotations();
        else if (e instanceof Field) annotations =
                ((Field) e).getDeclaredAnnotations();

        for (Annotation annotation : annotations) {
            System.out.println(e.getClass().getSimpleName() +
                    " Annotation: " + annotation);
        }
    }
}
