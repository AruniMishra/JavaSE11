package collection;

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Generics & Wildcards
*/

import java.util.ArrayList;
import java.util.List;

public class GenericContainer<T> {

    // Container wraps an ArrayList
    List<T> wrappedList; // ONLY valid
    // List<?> wrappedList1 ;
    // List<Object> wrappedList2 ;
    // List<? extends T> wrappedList3 ;
    // List<? super T> wrappedList4 ;
    // List wrappedList5 ;

    // Constructor
    GenericContainer(List<T> wrappedList) {
        this.wrappedList = wrappedList;
    }

    // Main method declares and constructs an instance
    public static void main(String[] args) {
        // List l = new ArrayList();
        List<CharSequence> l = new ArrayList<CharSequence>();
        // GenericContainer g = new GenericContainer(l);

        GenericContainer<CharSequence> g =
                new GenericContainer<>(l);

        // Add elements to wrapped List
        g.myAdd("hi");


        // Get first element from wrapped List
        Object o = g.myGet(0);
        System.out.println("Element 0 = " + o);

        // Print List
        System.out.println("Wrapped List = " + g);
    }

    // Wrap get method with custom one

    // the retrieval needs to be broad enough to get an object out of an array-list that could hold a T element.
    public T myGet(int index) {
        return wrappedList.get(index);
    }

    // Wrap add method with custom one
    // public void myAdd(Object o) {
    // add has to be restrictive to lower-bound T (consumer - general - super)
    public void myAdd(T o) {
        wrappedList.add(o);
    }


    // Wrap ArrayList.toString()
    public String toString() {
        return wrappedList.toString();
    }

}
