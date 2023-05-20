/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 11: Concurrency
Topic:  LinkedBlockingDeque, peek, element, getFirst, getLast methods
*/

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class LinkedBlockingDequePeeks {
    public static void main(String[] args) throws InterruptedException {

        List staticList = List.of("Jane", "Ralph", "Anne", "Mary", "Ralph",
                "Anne", "Harold", "Anne", "John", "Carol");
        // Create a blocking deque with no specified capacity

        BlockingDeque<String> dequeBlocked =
                new LinkedBlockingDeque<>(staticList);

        // Test Peek Methods
        usePeekMethods(dequeBlocked);
        dequeBlocked.addAll(staticList);

        // Test Get Methods
        useGetMethods(dequeBlocked);
        dequeBlocked.addAll(staticList);

        // Test Element Method
        useElementMethod(dequeBlocked);
        dequeBlocked.addAll(staticList);

    }

    // This method uses getFirst, getLast methods
    private static void useGetMethods(BlockingDeque<String> dequeBlocked) {
        System.out.println("------------ Get Methods -------------");
        System.out.println("Original state of Deque: " + dequeBlocked);

        // getLast queries data from the tail
        String dequedPerson = dequeBlocked.getLast();
        System.out.println("getLast() returns " + dequedPerson +
                ", Queue unchanged: " + dequeBlocked);

        // getFirst queries data from the head, same as remove()
        dequedPerson = dequeBlocked.getFirst();
        System.out.println("getFirst() returns " + dequedPerson +
                ", Queue unchanged: " + dequeBlocked);

        try {
            dequeBlocked.clear();
            System.out.println("After clearing the deque");
            // Either getFirst() or getList will
            // throw exception if queue is empty
            dequedPerson = dequeBlocked.getFirst();

        } catch (NoSuchElementException ise) {
            System.out.println("Queue empty: " + ise);
        }
    }

    // This method uses peek, peekFirst, peekLast methods
    private static void usePeekMethods(BlockingDeque<String> dequeBlocked) {
        System.out.println("------------ Peek Methods -------------");
        System.out.println("Original state of Deque: " + dequeBlocked);

        // Querying data with peek, queries the head of the queue
        String dequedPerson = dequeBlocked.peek();
        System.out.println("Peeked at " + dequedPerson +
                " , Queue unchanged : " + dequeBlocked);

        // peekLast queries data from the tail
        dequedPerson = dequeBlocked.peekLast();
        System.out.println("Peeked at last element " + dequedPerson +
                " , Queue unchanged: " + dequeBlocked);

        // peekFirst queries data from the head, same as peek()
        dequedPerson = dequeBlocked.peekFirst();
        System.out.println("Peeked at first element " + dequedPerson +
                " , Queue unchanged: " + dequeBlocked);

        dequeBlocked.clear();
        System.out.println("After clearing the deque");
        // Any peek method will return a false if unable to remove element
        dequedPerson = dequeBlocked.peek();
        System.out.println("After peek(), " + dequedPerson);
    }

    // This method uses element
    private static void useElementMethod(BlockingDeque<String> dequeBlocked) {
        System.out.println("------------ Element  Method -------------");
        System.out.println("Original state of Deque: " + dequeBlocked);

        // Using the element() method
        String dequedPerson = dequeBlocked.element();
        System.out.println("element() returns " + dequedPerson +
                ", Queue unchanged: " + dequeBlocked);

        try {
            dequeBlocked.clear();
            System.out.println("After clearing the deque");
            // element method on empty queue throws exception
            dequedPerson = dequeBlocked.element();

        } catch (NoSuchElementException ise) {
            System.out.println("Queue empty: " + ise);
        }
    }
}
