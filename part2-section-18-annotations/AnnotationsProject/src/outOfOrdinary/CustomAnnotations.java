package outOfOrdinary;/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 17 -Annotations
Topic:  Custom Annotations
*/

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface InheritedClassAnnotation {

}

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface InheritedInterfaceAnnotation {

}


// Intended as meta-annotation
@Retention(RetentionPolicy.RUNTIME)
@interface AnnotationAnnotation {

}

// Intended for Attribute
@Retention(RetentionPolicy.RUNTIME)
@interface AttributeAnnotation {

}

// Intended for Constructor
@Retention(RetentionPolicy.RUNTIME)
@interface ConstructorAnnotation {

}

// Intended for Local Variable
@Retention(RetentionPolicy.RUNTIME)
@interface LocalVariableAnnotation {

}

// Intended for Method
@Retention(RetentionPolicy.RUNTIME)
@interface MethodAnnotation {

}

// Intended for Method Parameter
@Retention(RetentionPolicy.RUNTIME)
@interface MethodParameterAnnotation {

}

// Intended for Type (Class, Enum, Interface)
@Retention(RetentionPolicy.RUNTIME)
@interface TypeAnnotation {

}


// these two types need to be specified before they can be used. -1
// Intended for Type Parameter
@Target(ElementType.TYPE_PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@interface TypeParameterAnnotation {

}

// these two types need to be specified before they can be used. -2
// Intended for Type Use
@Target(ElementType.TYPE_USE)
@Retention(RetentionPolicy.RUNTIME)
@interface TypeUseAnnotation {

}