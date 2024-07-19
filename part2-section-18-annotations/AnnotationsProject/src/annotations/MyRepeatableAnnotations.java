/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 17 -Annotations
Topic:  Container for a Repeatable annotation
*/
package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Containing Annotation Type has value which is array of
// annotation which will be repeated
@Retention(RetentionPolicy.RUNTIME)
public @interface MyRepeatableAnnotations {
    MyRepeatableAnnotation[] value(); // The name of the MyRepeatableAnnotation[] array should be value()
}
