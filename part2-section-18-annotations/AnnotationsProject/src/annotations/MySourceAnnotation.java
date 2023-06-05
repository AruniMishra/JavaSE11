/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 17 -Annotations
Topic:  Annotation retained only in source file
*/

package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Annotation with Source Retention Policy
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.METHOD)
public @interface MySourceAnnotation {
}
