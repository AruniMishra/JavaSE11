/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Generics, Generic Class, multiple parameter types.
*/

import java.io.FileNotFoundException;
import java.util.Arrays;

class AnotherGeneric<T, S> {

    // Two instance fields using type parameters
    T firstObject;
    S secondObject;

    // Constructor's arguments use the class's type parameters
    AnotherGeneric(T firstObject, S secondObject) {
        this.firstObject = firstObject;
        this.secondObject = secondObject;
    }

    // method returns the common ancestor lowest in hierarchy
    String getCommonClass() {
        String[] aClasses = getSuperClassesNotObject(firstObject.getClass());
        System.out.println("aClasses: " + Arrays.toString(aClasses));

        String[] bClasses = getSuperClassesNotObject(secondObject.getClass());
        System.out.println("bClasses: " + Arrays.toString(bClasses));

        int mismatch = Arrays.<String>mismatch(aClasses, bClasses);
        System.out.println(mismatch);
        String val = bClasses[mismatch - 1];
        return val;
    }

    // get classes in hierarchy as String array
    String[] getSuperClassesNotObject(Class c) {

        String name;
        String names = "";

        do {
            name = c.getName();
            if (names.length() > 0) names += ",";
            names = name + "," + names;
            c = c.getSuperclass();

        } while (c != null);
        return names.split(",");
    }
}

public class MoreGenerics {

    public static void main(String[] args) {

        // Create some instances of Exceptions
        ArithmeticException mathBug = new ArithmeticException();
        ClassCastException typeBug = new ClassCastException();
        FileNotFoundException ioBug = new FileNotFoundException();
        AbstractMethodError weirdBug = new AbstractMethodError();

        // Common hierarchy of ArithmethicException and ClassCastException
        AnotherGeneric<ArithmeticException, ClassCastException> a =
                new AnotherGeneric<>(mathBug, typeBug);
        System.out.println("The common superclass for ArithmeticException, " +
                "ClassCastException: " + a.getCommonClass());
        System.out.println();

        // Common hierarchy of ArithmethicException and FileNotFoundException
        AnotherGeneric<ArithmeticException, FileNotFoundException> b =
                new AnotherGeneric<>(mathBug, ioBug);
        System.out.println("The common superclass for ArithmeticException, " +
                "FileNotFoundException: " + b.getCommonClass());

        // Common hierarchy of ArithmethicException and AbstractMethodError
        AnotherGeneric<ArithmeticException, AbstractMethodError> c =
                new AnotherGeneric<>(mathBug, weirdBug);
        System.out.println("The common superclass for ArithmeticException, " +
                "AbstractMethodError: " + c.getCommonClass());

        // Common hierarchy of ArithmethicException and Object
        AnotherGeneric<ArithmeticException, Object> d =
                new AnotherGeneric<>(mathBug, new Object());
        System.out.println("The common superclass for ArithmeticException, " +
                "Object: " + d.getCommonClass());
    }
}


