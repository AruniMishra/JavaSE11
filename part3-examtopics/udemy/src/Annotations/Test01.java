package Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// @Target is not Repeatable annotation, therefore it can appear only once
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
// @Target(ElementType.MODULE)
// @Target(ElementType.METHOD)
@interface Fast21 {
}

public class Test01 {
    public static void main(String[] args) {
        int i = Integer.MAX_VALUE+ 1;
        System.out.println(i);
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

class Test35 {
    public static void main(String[] args) {
        Dog animal = new Dog();
        animal.speak(); //Line n5
        animal.eat(); //Line n6
    }
}


class Test38 {

    /*
    @SafeVarargs annotation can be applied to methods and constructors only it causes error if:
    - If it is applied to a fixed arity method/constructor
    - If it is applied to a variable arity method that is neither static nor final nor private
     */
    @SafeVarargs
    final void Test(String... strings) {} //Line n1

    // @SafeVarargs public void Test2(String msg) {} //Line n2
    //
    // // @SafeVarargs public void greet(String... msg) {} //Line n3
    //
    @SafeVarargs private void print(String... strings) {} //Line n4

    @SafeVarargs final Integer sum(Integer... integers) {return null;} //Line n5
}