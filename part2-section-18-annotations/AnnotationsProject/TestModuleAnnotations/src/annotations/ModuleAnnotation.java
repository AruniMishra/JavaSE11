/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 17 - Annotations
Topic:  Module Annotations
*/

package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

// Intended for Module
@Target(ElementType.MODULE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ModuleAnnotation {

}

@Target(TYPE)
@interface Resource {}