package collection;/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Collections, Queue: ArrayDeque, LinkedList
*/

import java.util.*;

public class QueueExample {

    public static void main(String[] args) {
        List<Integer> initialData = List.of(10, 20, 50, 40, 30);

        // LinkedList supports null elements, whereas ArrayDeque does not.
        // both allowed duplicates
        System.out.println("\n----------- ArrayDeque -----------");
        System.out.println("Original values entered: " + initialData);

        Queue<Integer> arrayQueue = new ArrayDeque<>(initialData);
        CollectionTests.doStuffWithCollection(arrayQueue, 60, 50, 10);

        System.out.println("\n----------- LinkedList -----------");
        System.out.println("Original values entered: " + initialData);

        Queue<Integer> linkedList = new LinkedList<>(initialData);
        CollectionTests.doStuffWithCollection(linkedList, 60, 50, 10);


        System.out.println("\n----------- ArrayDeque -----------");
        System.out.println("Additional Methods, initialData : " + arrayQueue);
        testBasicQueueMethods(arrayQueue);

        System.out.println("\n----------- LinkedList -----------");
        System.out.println("Additional Methods, initialData : " + linkedList);
        testBasicQueueMethods(linkedList);


        System.out.println("\n----------- ArrayDeque -----------");
        System.out.println("Deque Methods, initialData : " + arrayQueue);

        testDequeMethods((ArrayDeque<Integer>) arrayQueue);

        System.out.println("\n----------- LinkedList -----------");
        System.out.println("Deque Methods, initialData : " + linkedList);

        testDequeMethods((LinkedList<Integer>) linkedList);


    }

    public static void testBasicQueueMethods(Queue<Integer> q) {

        /*
        add() will throw an IllegalStateException if no space is currently available in the Queue,
        otherwise add method will return true. offer() method will return false if the element cannot be inserted due to capacity restrictions.
         */
        // Add elements using both add and offer
        System.out.println("After add(100) : " + q.add(100) + " : " + q);

        System.out.println("After offer(101) : " + q.offer(101) + " : " + q);

        try {
            System.out.println("After offer(null) : " + q.offer(null) + " : " + q);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        // Retrieve an element using element or peek
        System.out.println("element() returns : " + q.element() + " : " + q);
        System.out.println("peek() returns(no exception) : " + q.peek() + " : " + q);

        // Retrieve and remove an element from the queue
        // using poll and remove
        System.out.println("poll() returns(no exception) : " + q.poll() + " : " + q);
        System.out.println("remove() returns : " + q.remove() + " : " + q);
    }

    // The following methods work both with Deque and LinkedList
    public static void testDequeMethods(Deque q) {

        // Dequeue has a push method that adds element to the head
        // of the queue (opposite of add and offer)
        q.push(199);
        System.out.println("After push(199) : " + q);

        // Dequeue has a pop method that retrieves element at
        // the head of the queue
        // There is no difference. In fact, pop() and remove() methods both call removeFirst.
        System.out.println("pop() returns : " + q.pop() + " : " + q);

        // .addFirst() throws an (unchecked) exception,
        // .offerFirst() returns false.

        // Adding Methods, addFirst, offerFirst, addLast, offerLast
        q.addFirst(200);
        System.out.println("After addFirst(200) : " + q);

        System.out.println("After offerFirst(201) : " + q.offerFirst(201) + " : " + q);

        q.addLast(300);
        System.out.println("After addLast(300) : " + q);

        System.out.println("After offerLast(301) : " + q.offerLast(301) + " : " + q);

        // Retrieval Methods, getFirst, getLast, peekFirst, peekLast
        System.out.println("getFirst() returns : " + q.getFirst() + " : " + q);

        System.out.println("getLast() returns : " + q.getLast() + " : " + q);

        System.out.println("peekFirst() returns : " + q.peekFirst() + " : " + q);

        System.out.println("peekLast() returns : " + q.peekLast() + " : " + q);

        // Removal methods, pollFirst, pollLast, removeFirst, removeLast
        System.out.println("pollFirst() returns : " + q.pollFirst() + " : " + q);

        System.out.println("pollLast() returns : " + q.pollLast() + " : " + q);

        System.out.println("removeFirst() returns : " + q.removeFirst() + " : " + q);
        System.out.println("removeLast() returns : " + q.removeLast() + " : " + q);
    }
}

// exception:
// 1. addFirst
// 2. getFirst
// 3. removeFirst



