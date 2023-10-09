package collection;

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Wrappers and Generics
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WrapperLimits {
    public static void main(String[] args) {

        // Here a float literal can be assigned to a double variable
        double d = 32.0f;

        // Here a float literal can be part of array initialization for
        // a double array
        double[] doubleArray = new double[]{32.0f};

        System.out.println("Primitive assignment, float to double: " + d);
        System.out.println("Primitive array initialization assignment," + " float to double: " + Arrays.toString(doubleArray));


        // An autoboxed float -> Float cannot be assigned to a Double
        // Double wrapper= 32.0f;

        // An array of double wrappers cannot be initialized to array
        // of primitive float
        // Double[] wrappedArray = new Double[]{32.0f};


        // An autoboxed float -> Float cannot be assigned to a Double
        Float wrapper = 32.0f; // valid

        // An array of double wrappers cannot be initialized to array
        // of primitive float
        Float[] wrappedArray = new Float[]{32.0f}; // valid


        // A List of float literals cannot be passed to constructor of Double
        // List<Double> doubleList = new ArrayList<Double>(List.of(32.2f));

        // Cannot add a literal float to a List of Double
        // List<Double> doubleList2 = new ArrayList<Double>();
        // doubleList2.add(32.2f);


        // Only double literals can be passed to constructor of Double
        List<Double> doubleList = new ArrayList<Double>(List.of(32.2));

        // Only double literal can be added to List of Double
        List<Double> doubleList2 = new ArrayList<Double>();
        doubleList2.add(32.2);


        // Typing only on the assignment side does not place compiler error
        // restrictions on elements added.
        List numberList = new ArrayList<Integer>();
        numberList.add("Hello");
        numberList.add(3.2f);
        numberList.add(List.of("a", "b"));


        System.out.println(numberList); // valid both at compile and run time


        Number number;
        Integer integer = 10;
        number = integer;
        // List<Number> integerList = new ArrayList<Integer>(); // incompatible
        // List integerList = new ArrayList<Integer>(); // valid here


        //  integer lists can be assigned any array list of any type, including, for example, an exception that
        //  adding an int to an array-list of exception would cause a compiler error and that's what we're getting here.
        List<?> integerList = new ArrayList<Integer>();
        // integerList.add(5); // invalid: "'Required type: capture of ?'  &  'Provided: int'"

        // this doesn't fix the compiler error,
        // on trying to add data to the integer list again, integer list
        // could actually reference an array-list of short for example,
        // and adding 5 to an array list of type short would produce a compiler error.
        List<? extends Number> integerList1 = new ArrayList<Integer>();
        // integer List1.add(5);


        List<? super Integer> integerList2 = new ArrayList<Integer>();
        // only Integer value allowed in the below numberList?.
        /*
        Lower bounds and upper bounds are tricky and the thought process is actually counter-intuitive.
        Initial thoughts when we see <? super Integer> (lower bound) is that we can add any type
        that is a super type of Integer (including Integer itself).

        But the problem is that if we allowed Number to be added, we could also add Double, Float etc.,
        because they too are a Number (IS A relationship). And Double, Float, etc. are not super types of Integer.

        Therefore, when you see <? super ...> in the exam, and you're trying to figure out what you can
        add() to the list, remember that it means:

        "any type of ..."
        not:
        "a super type of ...".
         */
        // integerList2.add((Number) 127); // invalid
        integerList2.add(5); // valid

        // integerList.add(10L);
        integerList2.add((int) 10L);
        // integerList.add((Integer) 10L); // invalid, trying to cast a literal long to an integer wrapper.

    }
}
