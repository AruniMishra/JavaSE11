/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 11: Concurrency
Topic:  LinkedBlockingDeque, Poll/Remove methods
*/

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class LinkedBlockingDequePolls {
    public static void main(String[] args) throws InterruptedException {

        List staticList = List.of("Jane", "Ralph", "Anne", "Mary", "Ralph",
                "Anne", "Harold", "Anne", "John", "Carol");

        // Create an empty blocking deque with no initial capacity
        BlockingDeque<String> dequeBlocked =
                new LinkedBlockingDeque<>(staticList);

        // Test Poll Methods
        usePollMethods(dequeBlocked);
        dequeBlocked.addAll(staticList);

        // Test Remove Methods
        useRemoveMethods(dequeBlocked);
        dequeBlocked.addAll(staticList);

        // Test Pop Method
        usePopMethod(dequeBlocked);
        dequeBlocked.addAll(staticList);


        // Test Take Methods
        useTakeMethods(dequeBlocked);

        //Test Poll Methods
        usePollMethodsWithTimeout(dequeBlocked);
    }

    // This method uses poll, pollFirst, pollLast methods
    private static void usePollMethods(BlockingDeque<String> dequeBlocked) {
        System.out.println("------------ Poll Methods -------------");
        System.out.println("Original state of Deque: " + dequeBlocked);

        // Removing data with remove, removes data from the head of the queue
        String dequedPerson = dequeBlocked.poll();
        System.out.println("After poll(), " + dequedPerson +
                " was removed: " + dequeBlocked);

        // removeLast removes data from the tail
        dequedPerson = dequeBlocked.pollLast();
        System.out.println("After pollLast(), " + dequedPerson +
                " was removed: " + dequeBlocked);

        // removeFirst removes data from the head, same as remove()
        dequedPerson = dequeBlocked.pollFirst();
        System.out.println("After pollFirst(), " + dequedPerson +
                " was removed: " + dequeBlocked);

        dequeBlocked.clear();
        System.out.println("After clearing the deque");
        // Any remove method will return a false if unable to remove element
        dequedPerson = dequeBlocked.poll();
        System.out.println("After poll(), " + dequedPerson +
                " was removed: " + dequeBlocked);
    }

    // This method uses remove(), remove(e), removeFirst(), removeLast(),
    // also removeFirstOccurrence(e) and removeLastOccurrence(e)
    private static void useRemoveMethods(
            BlockingDeque<String> dequeBlocked) {
        System.out.println("------------ Remove Methods -------------");
        System.out.println("Original state of Deque: " + dequeBlocked);

        // Removing data with remove, removes data from the head of queue
        String dequedPerson = dequeBlocked.remove();
        System.out.println("After remove(), " + dequedPerson +
                " was removed: " + dequeBlocked);

        // Removing data with remove, passing an object, removes 1st element
        // that equals object passed, returns a boolean, and not the element
        boolean wasRemoved = dequeBlocked.remove("Ralph");
        System.out.println("After remove(Ralph), wasRemoved = "
                + wasRemoved + " : " + dequeBlocked);

        // removeLast removes data from the tail
        dequedPerson = dequeBlocked.removeLast();
        System.out.println("After removeLast(), " + dequedPerson +
                " was removed: " + dequeBlocked);

        // removeFirst removes data from the head, same as remove()
        dequedPerson = dequeBlocked.removeFirst();
        System.out.println("After removeFirst(), " + dequedPerson +
                " was removed: " + dequeBlocked);

        // removeFirstOccurrence(Object o) is same as removeFirst(Object o)
        wasRemoved = dequeBlocked.removeFirstOccurrence("Anne");
        System.out.println(
                "After removeFirstOccurrence(Anne), wasRemoved = "
                        + wasRemoved + " : " + dequeBlocked);

        // removeLastOccurrence removes last occurrence
        wasRemoved = dequeBlocked.removeLastOccurrence("Anne");
        System.out.println(
                "After removeLastOccurrence(Anne), wasRemoved = "
                        + wasRemoved + " : " + dequeBlocked);

        wasRemoved = dequeBlocked.removeLastOccurrence("Anne");
        System.out.println("" +
                "After removeLastOccurrence(Anne), wasRemoved = "
                + wasRemoved + " : " + dequeBlocked);
        try {
            dequeBlocked.clear();
            System.out.println("After clearing the deque");
            // Any noargs remove method (remove, removeFirst(),
            // removeLast()) throws exception if queue is empty
            dequedPerson = dequeBlocked.remove();

        } catch (NoSuchElementException ise) {
            System.out.println("Queue empty: " + ise);
        }

        // Other remove methods that accept an argument return false
        // if queue is empty.
        wasRemoved = dequeBlocked.removeLastOccurrence("Anne");
        System.out.println(
                "After removeLastOccurrence(Anne), wasRemoved = "
                        + wasRemoved + " : " + dequeBlocked);

    }

    // This method uses pop
    private static void usePopMethod(BlockingDeque<String> dequeBlocked) {
        System.out.println("------------ Pop Method -------------");
        System.out.println("Original state of Deque: " + dequeBlocked);

        // pop() is same as remove(), removes element from head and
        // returns element.
        String dequedPerson = dequeBlocked.pop();
        System.out.println("After pop(), " + dequedPerson +
                " was removed: " + dequeBlocked);

        try {
            dequeBlocked.clear();
            System.out.println("After clearing the deque");
            // pop method on empty queue throws exception, like remove()
            dequedPerson = dequeBlocked.pop();

        } catch (NoSuchElementException ise) {
            System.out.println("Queue empty: " + ise);
        }
    }


    // This method uses take, takeFirst, takeLast methods which block
    // when queue is empty
    private static void useTakeMethods(BlockingDeque<String> dequeBlocked)
            throws InterruptedException {
        System.out.println("------------ Take Methods -------------");
        System.out.println("Original state of Deque: " + dequeBlocked);

        // Removing data with take, removes data from the head of the queue
        String dequedPerson = dequeBlocked.take();
        System.out.println("After take(), " + dequedPerson +
                " was removed: " + dequeBlocked);

        // takeLast removes data from the tail
        dequedPerson = dequeBlocked.takeLast();
        System.out.println("After takeLast(), " + dequedPerson +
                " was removed: " + dequeBlocked);

        // takeFirst removes data from the head, same as take()
        dequedPerson = dequeBlocked.takeFirst();
        System.out.println("After takeFirst(), " + dequedPerson +
                " was removed: " + dequeBlocked);

        dequeBlocked.clear();
        System.out.println("After clearing the deque");
        // Any take method will block if queue is empty; code hangs here.
        /*
        for fix see, usePollMethodsWithTimeout(dequeBlocked);
         */
        // dequedPerson = dequeBlocked.take();
        // System.out.println("After take(), " + dequedPerson +
        //         " was removed: " + dequeBlocked);
    }


    // This method uses poll, pollFirst, pollLast methods with
    // timeout time span defined
    private static void usePollMethodsWithTimeout(
            BlockingDeque<String> dequeBlocked)
            throws InterruptedException {
        System.out.println("-------- Timed out Poll Methods ---------");
        System.out.println("Original state of Deque: " + dequeBlocked);

        // Removing data with poll, removes data from the head of the queue
        String dequedPerson = dequeBlocked.poll(1, TimeUnit.SECONDS);
        System.out.println("After poll(), " + dequedPerson +
                " was removed: " + dequeBlocked);

        // pollLast removes data from the tail
        dequedPerson = dequeBlocked.pollLast(1, TimeUnit.SECONDS);
        System.out.println("After pollLast(), " + dequedPerson +
                " was removed: " + dequeBlocked);

        // pollFirst removes data from the head
        dequedPerson = dequeBlocked.pollFirst(1, TimeUnit.SECONDS);
        System.out.println("After pollFirst(), " + dequedPerson +
                " was removed: " + dequeBlocked);

        dequeBlocked.clear();
        System.out.println("After clearing the deque");
        // Any remove method will return a null if timeout occurs
        dequedPerson = dequeBlocked.poll(1, TimeUnit.SECONDS);
        System.out.println("After poll(), " + dequedPerson +
                " was removed: " + dequeBlocked);
    }


}