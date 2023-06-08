package outOfOrdinary;/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 17 -Annotations
Topic:  Testing Inherited Annotations
*/

// Annotate an Interface with one that had meta-annotation @Inherited
@InheritedInterfaceAnnotation // this is not inherited
interface SuperInterface {

}

// Annotate a Class with one that had meta-annotation @Inherited
@InheritedClassAnnotation
class SuperClass {

}

// Do not annotate this class, which extends outOfOrdinary.SuperClass and implements
// outOfOrdinary.SuperInterface
public class InheritedAnnotationExample extends SuperClass
        implements SuperInterface {
    public static void main(String[] args) {
        System.out.println("Testing meta-annotations");
    }
}