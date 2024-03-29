/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Generics, Inheritance and Polymorphism
*/

import java.util.ArrayList;
import java.util.List;

public class GenericsInheritance {

    private static void methodOne(Number number) {
        System.out.println("Declared parameter type is Number, " +
                "Actual Type is " + number.getClass().getName());
    }

    private static void methodTwo(ArrayList<Number> numberList) {
        System.out.println("Declared parameter type is ArrayList<Number>, " +
                "Actual Type is " + numberList.getClass().getName());
    }

    private static void methodTwo2(ArrayList<? extends Number> numberList) {
        System.out.println(
                "Declared parameter type is ArrayList<? extends Number>, " +
                        "Actual Type is " + numberList.getClass().getName());
    }


    private static void methodThree(List<Integer> integerList) {
        System.out.println("Declared parameter type is List<Integer>, " +
                "Actual Type is " + integerList.getClass().getName());
    }

    public static void main(String[] args) {

        Integer i = 1;

        // Assigning an Integer to a Number variable works
        Number n = i;

        // Casting a Number variable to an Integer
        Integer i2 = (Integer) n;

        // Invoking a method using an Integer in place of a Number
        // parameter
        methodOne(i);


        ArrayList<Integer> intArray = new ArrayList<>();

        // Cannot assign :  Incompatible types
        // ArrayList<Number> numberList0 =  intArray; // option 1, generates compile error here, and line 1&2

        // Generics allow us to express a hierarchical relationship for
        // contained class using wildcards.
        // we know that A<S> is a valid subtype of A<? extends T> (where S is a subtype of T).
        ArrayList<? extends Number> numberList = intArray; // option 2, use with methodTwo2

        // Cannot cast:  Incontrovertible types without casting
        ArrayList<Integer> intArray2 = (ArrayList<Integer>) numberList; // line 1

        // Cannot invoke method which expects ArrayList<Number> with
        // an ArrayList<Integer>
        // methodTwo(intArray); // line 2


        methodTwo2(intArray);


        // You can assign an ArrayList<Integer> to a List<Integer>
        List<Integer> intList = intArray;

        // You can cast
        ArrayList<Integer> intList2 = (ArrayList<Integer>) intList;

        // You can invoke a method passing an ArrayList<Integer> for
        // a parameter declared as a List<Integer>
        methodThree(intArray);


    }

}
