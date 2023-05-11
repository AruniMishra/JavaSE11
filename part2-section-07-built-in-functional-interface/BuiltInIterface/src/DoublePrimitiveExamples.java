/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 6: Built-in Functional Interfaces
Topic:  Primitive Data Functional Interfaces
*/

import java.util.function.*;

public class DoublePrimitiveExamples {
    public static void main(String[] args) {

        // DoubleUnaryOperator takes primitive double and returns a double
        DoubleUnaryOperator duo = (d) -> d++ + d--;
        System.out.println("DoubleUnaryOperator.applyAsDouble(3) returns " +
                "double: " + duo.applyAsDouble(3));

        // DoubleBinaryOperator takes two primitive double parameters
        // and returns a double
        DoubleBinaryOperator dbo = (double d, double e) -> d + 5 * e + d;
        System.out.println("DoubleBinaryOperator.applyAsDouble(3,1) " +
                "returns double: " + dbo.applyAsDouble(3d, 1d));

        // DoubleFunction<R> takes a primitive double as parameter and
        // returns an object determined by <R> generic type
        DoubleFunction<String> df =
                (double d) -> String.format("Value of PI = %.2f", d);
        System.out.println("DoubleFunction.apply(Math.PI) returns String: " +
                df.apply(Math.PI));

        // DoubleToIntFunction takes a primitive double as parameter and
        // returns an int
        double a = 1;
        int b = (int) a;
        DoubleToIntFunction dif = (d) -> (int) d;
        System.out.println("DoubleToIntFunction.applyAsInt(Math.PI) " +
                "returns int: " + dif.applyAsInt(Math.PI));

        // DoubleToLongFunction takes a primitive double as parameter and
        // returns a long
        DoubleToLongFunction dil = (double d) -> (long) d;
        System.out.println("DoubleToLongFunction.applyAsLong(Math.PI) " +
                "returns long: " + dil.applyAsLong(Math.PI));

        // ToDoubleFunction<T> takes a parameter of specified type and
        // returns a primitive double
        ToDoubleFunction<String> tdf = (String s) -> Double.parseDouble(s);
        System.out.println("ToDoubleFunction<String>." +
                "applyAsDouble(\"10.98765\") returns double: " +
                tdf.applyAsDouble("10.98765"));

        // ToDoubleBiFunction<T, U> takes parameters of specified types and
        // returns a primitive double
        ToDoubleBiFunction<String, String> tdb =
                (String s, String t) -> Double.parseDouble(s) +
                        Double.parseDouble(t);

        System.out.println("ToDoubleBiFunction<String,String>" +
                ".applyAsDouble(\"10.98765\",\"0.02\") returns double: "
                + tdb.applyAsDouble("10.98765", "0.02"));

        // DoublePredicate takes a primitive double data type
        DoublePredicate dp = (double d) -> d == 0;
        System.out.println("DoublePredicate.test(Math.PI) returns boolean: "
                + dp.test(Math.PI));

        // DoubleConsumer takes a primitive double data type
        DoubleConsumer dc =
                (double d) -> System.out.println("Do something with " + d);
        System.out.print("DoubleConsumer.accept(Math.PI)) returns void: ");
        dc.accept(Math.PI);

        // ObjDoubleConsumer(this is like a BiConsumer) takes a type <T> and
        // primitive double parameter
        ObjDoubleConsumer<Object> dco =
                (Object s, double d) ->
                        System.out.println((String) s + " " + d);
        System.out.print("ObjDoubleConsumer.accept(\"PI equals\",Math.PI) " +
                "returns Object: ");
        dco.accept("PI equals", Math.PI);

        // DoubleSupplier returns double value as return type
        DoubleSupplier ds = () -> Double.parseDouble("10.0");
        System.out.print("DoubleSupplier.getAsDouble(\"10.0\")) " +
                " returns double:  " + ds.getAsDouble());

    }
}
