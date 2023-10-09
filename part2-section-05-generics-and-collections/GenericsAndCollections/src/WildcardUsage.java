/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Generics, wildcards
*/

import java.util.List;

class WildcardTests<T> {
    private int val;

    public WildcardTests() {

    }

    public WildcardTests(int val) {
        this.val = val;
    }

    public static <U> void doSomething(U u) {
        System.out.println(u);
    }


    // public <? extends WildcardTests> void doSomethingElse() {
    //     System.out.println("cannot do this");
    // }
}

public class WildcardUsage {

    // wildcard used in type argument of static field declaration
    static List<?> staticList;
    // wildcard used in type argument of field declaration
    List<?> instanceList;
    // wildcard can be used nested in another type argument.
    List<WildcardTests<?>> tests;

    // wildcard used in return type of static method parameter
    private static List<?> getList(List<?> list) {
        return list;
    }

    public static void main(String[] args) {
        WildcardUsage swu = new WildcardUsage();

        // Set up some test data
        List<WildcardTests> wildList =
                List.of(new WildcardTests(1), new WildcardTests(2));

        // wildcard used in type argument of local variable declaration
        List<?> unboundedList =
                List.of(1, 1.2f, true, 50, false, "Yes", new Exception());

        swu.setList(wildList);
        staticList = getList(wildList);

        System.out.println(staticList);
        System.out.println(swu.instanceList);
        System.out.println(unboundedList);


        WildcardTests.doSomething("Hello");
        WildcardTests.<String>doSomething("Hello");
        // WildcardTests.<?>doSomething("Hello");


        WildcardTests<String> test1 = new WildcardTests<>(1);
        WildcardTests<?> test2 = new WildcardTests<String>(2);
        // WildcardTests<String> test3 = new WildcardTests<?>(3);

    }

    // wildcard used in type argument of instance method parameter
    private void setList(List<?> list) {
        instanceList = list;
    }
}

// class AnotherClass extends WildcardTests<?> {}


// You can't use a wildcard in a type argument of a generic class.
// class AnotherClass<? extends WildcardTests> {
//
// }

