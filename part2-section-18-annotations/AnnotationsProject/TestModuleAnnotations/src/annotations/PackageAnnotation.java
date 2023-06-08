/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 17 - Annotations
Topic:  Package Annotation
*/

package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Intended for Package
@Retention(RetentionPolicy.RUNTIME)
public @interface PackageAnnotation {

}