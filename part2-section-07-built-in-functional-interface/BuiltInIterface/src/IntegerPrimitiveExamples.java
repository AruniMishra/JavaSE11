/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 6: Built-in Functional Interfaces
Topic:  Primitive Data Functional Interfaces
*/

import java.util.function.*;

public class IntegerPrimitiveExamples {
    public static void main(String[] args) {

        // IntUnaryOperator Operator takes primitive int and returns an int
        IntUnaryOperator iuo = (int i) -> i++ + i--;
        System.out.println("IntUnaryOperator.applyAsInt(10) returns " +
                "int: " + iuo.applyAsInt(10));

        // IntBinaryOperator takes two primitive int parameters
        // and returns a int
        IntBinaryOperator ibo = (int d, int e) -> d + 5 * e + d;
        System.out.println("IntBinaryOperator.applyAsInt(15,1) " +
                "returns int: " + ibo.applyAsInt(15, 1));

        // IntFunction<R> takes a primitive int as parameter and
        // returns an object determined by <R> generic type

        IntFunction<String> intf = (int i) ->
                String.format("Value of Integer.MAX_VALUE = %d", i);
        System.out.println("IntFunction.apply() returns String: " +
                intf.apply(Integer.MAX_VALUE));

        // IntToDoubleFunction takes a primitive int as parameter and
        // returns an double
        IntToDoubleFunction idf = (int i) -> (double) i;
        System.out.println(
                "IntToDoubleFunction.applyAsInt(Integer.MAX_VALUE) " +
                        "returns double: " + idf.applyAsDouble(Integer.MAX_VALUE));

        // IntToLongFunction takes a primitive int as parameter and
        // returns a long
        IntToLongFunction ilf = (int d) -> (long) d;
        System.out.println(
                "IntToLongFunction.applyAsLong(Integer.MAX_VALUE) " +
                        "returns long: " + ilf.applyAsLong(Integer.MAX_VALUE));

        // ToIntFunction<T> takes a parameter of specified type and
        // returns a primitive int
        ToIntFunction<String> tdf = (String s) -> Integer.parseInt(s);
        System.out.println("ToIntFunction<String>." +
                "applyAsInt(\"98765\") returns int: " +
                tdf.applyAsInt("98765"));

        // ToIntBiFunction<T, U> takes parameters of specified types and
        // returns a primitive int
        ToIntBiFunction<String, String> tdb =
                (String s, String t) -> Integer.parseInt(s) +
                        Integer.parseInt(t);

        System.out.println("ToIntBiFunction<String,String>" +
                ".applyAsInt(\"1098765\",\"2\") returns int: "
                + tdb.applyAsInt("1098765", "2"));

        // IntPredicate takes a primitive int data type
        IntPredicate dp = (int d) -> d == Integer.MAX_VALUE;
        System.out.println("IntPredicate.test(Integer.MAX_VALUE) returns"
                + " boolean: " + dp.test(Integer.MAX_VALUE));

        // IntConsumer takes a primitive int data type
        IntConsumer ic = (int i) ->
                System.out.println("Do something with " + i);
        System.out.print(
                "IntConsumer.accept(Integer.MAX_VALUE)) returns void: ");
        ic.accept(Integer.MAX_VALUE);

        // ObjIntConsumer (this is like BiConsumer) takes a type <T>
        // and primitive int parameter
        ObjIntConsumer<Object> ico = (Object s, int i) ->
                System.out.println((String) s + " " + i);
        System.out.print("ObjIntConsumer.accept(\"Integer.MAX_VALUE " +
                " equals\",Integer.MAX_VALUE) returns Object: ");
        ico.accept("Integer.MAX_VALUE equals", Integer.MAX_VALUE);

        // IntSupplier returns int value as return type
        IntSupplier is = () -> Integer.parseInt("100");
        System.out.print("IntSupplier.getAsInt(\"100\")) " +
                "returns int: " + is.getAsInt());

    }
}