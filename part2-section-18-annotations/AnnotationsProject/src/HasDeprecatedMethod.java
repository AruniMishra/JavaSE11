/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 17 -Annotations
Topic:  Using annotations in java.lang package.
*/

import java.util.ArrayList;
import java.util.List;

// Create a class with a method marked as deprecated
public class HasDeprecatedMethod {
    /*
    @Deprecated annotation has 2 attributes: 'since' and 'forRemoval'.
    Default value of 'since' is empty string "" and  default value of 'forRemoval' is false.
    Javadoc comment for this method uses @deprecated tag to provide documentation about the deprecation.
     */


    /**
     * Using javadoc tag @deprecated
     *
     * @deprecated As of release 1.2, replaced by {@link #doThat()}
     */
    // Using annotation @Deprecated
    @Deprecated(
            since = "1.3",
            forRemoval = true)
    public void doThis() {
        System.out.println("Doing this");
    }


    /**
     * Using javadoc tag @deprecated
     *
     * @deprecated As of release 1.5
     */
    @Deprecated(
            since = "1.5")
    public void doThisAlso() {
        System.out.println("Doing this also");
    }


    public void doThat() {
        System.out.println("Doing that");
    }
}

class JavaLangAnnotations {

    // @SuppressWarnings must support three values: unchecked, deprecation, and removal

    // @SuppressWarnings // SuppressWarnings annotation has one 'value' attribute of String [] type and
    // it doesn't provide any default value. Hence, @SuppressWarnings causes compilation error.

    @SuppressWarnings({"deprecation", "removal"})
    // @SuppressWarnings({"deprecated", "removal"}) // valid, but "deprecated" is not a valid value.
    /*
    @SuppressWarnings("deprecation") => As we are passing just one value, "deprecation" to String [],
    hence {} can be omitted
     */
    // @SuppressWarnings({"removal"})
    // @SuppressWarnings({"deprecation"})
    public static void main(String[] args) {
        HasDeprecatedMethod hasDeprecatedMethod = new HasDeprecatedMethod();
        // Deprecated method usage...
        hasDeprecatedMethod.doThis();


        // Deprecated method usage...
        // hasDeprecatedMethod.doThisAlso();

    }
}


class Test {
    /*
    Compiler issues unchecked warnings for the code, which mixes generic and raw types.
    Return type of method create() is List (raw type) and statement `List<Integer> list = create();`
    inside main(String[]) method assigns the return value to List<Integer> type, which is of generic type.
    Hence, compiler issues warning for code inside main(String[]) method.

    Replacing '/*INSERT-1*'/ with @SuppressWarnings("unchecked") will suppress the warning
     */

    /*INSERT-1*/
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<Integer> list = create();
    }

    /*INSERT-2*/
    // @SuppressWarnings("unchecked")
    private static List create() {
        return new ArrayList();
    }
}



class Animal {
    @Deprecated
    public void eat() { //Line n1
        System.out.println("Generic Animal eating");
    }
    @Deprecated
    public void speak() { //Line n2
        System.out.println("Generic Animal speaking");
    }
}

class Dog extends Animal {
    @Override
    public void eat() { //Line n3
        System.out.println("Dog is eating biscuits");
    }

    @Override
    public void speak() { //Line n4
        System.out.println("Dog is barking");
    }
}

class TestDemo {
    public static void main(String[] args) {
        Dog animal = new Dog();
        animal.speak(); //Line n5
        animal.eat(); //Line n6
    }
}