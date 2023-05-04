/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Collections, Queue: ArrayDeque, LinkedList
*/

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    }

    public static void testBasicQueueMethods(Queue<Integer> q) {

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

        System.out.println("peek() returns : " + q.peek() + " : " + q);

        // Retrieve and remove an element from the queue
        // using poll and remove
        System.out.println("poll() returns : " + q.poll() + " : " + q);

        System.out.println("remove() returns : " + q.remove() + " : " + q);
    }


}



