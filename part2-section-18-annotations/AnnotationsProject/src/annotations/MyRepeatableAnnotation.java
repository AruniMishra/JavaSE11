/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 17 -Annotations
Topic:  Repeatable Annotation
*/

package annotations;

import java.lang.annotation.Repeatable;

// Repeatable Annotation Type requires containing annotation

/*
@Repeatable annotation
remember that to make an annotation repeatable,
you'll need to create two annotations.
One is the repeatable annotation using the @Repeatable annotation and the other
is a container for an array of the Repeatable annotation.
 */
@Repeatable(MyRepeatableAnnotations.class)
public @interface MyRepeatableAnnotation {
    int value() default 0;
}