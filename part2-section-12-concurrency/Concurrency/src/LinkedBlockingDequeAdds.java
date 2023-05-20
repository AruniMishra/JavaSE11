/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 11: Concurrency
Topic:  LinkedBlockingDequeAdds
*/

import java.util.concurrent.*;

public class LinkedBlockingDequeAdds {
    public static void main(String[] args) throws InterruptedException {

        // Create a blocking deque with an initial capacity
        BlockingDeque<String> dequeBlocked = new LinkedBlockingDeque<>(4);

        // Test various Offer Methods
        useOfferMethods(dequeBlocked);
        dequeBlocked.clear();

        // Test various Add Methods
        useAddMethods(dequeBlocked);
        dequeBlocked.clear();

        // Test Push Method, returns void, available for deque
        usePushMethod(dequeBlocked);
        dequeBlocked.clear();

        System.out.println("\n\n--put/offer--");
        // Test Put Methods // code hangs for put
        // usePutMethods(dequeBlocked);
        // dequeBlocked.clear();


        // Fix hang for put
        // Schedule a thread to pop an element from the queue
        ScheduledExecutorService scheduledService =
                Executors.newScheduledThreadPool(1);

        var thread = scheduledService.scheduleAtFixedRate(() -> {
            System.out.println("popping queue");
            System.out.println("Got " + dequeBlocked.pop());
            System.out.println("dequeBlocked " + dequeBlocked);

        }, 2, 2, TimeUnit.SECONDS);

        // Test Put Methods
        // usePutMethods(dequeBlocked);

        // Test offer methods with timeout
        useOfferMethodsTimed(dequeBlocked);

        Thread.sleep(5000);
        scheduledService.shutdown();

        // Wait no longer than 20 seconds for completion confirmation
        scheduledService.awaitTermination(20, TimeUnit.SECONDS);

    }

    // This method uses offer, offerFirst, offerLast methods and tests
    // what happens when queue capacity is reached.
    private static void useOfferMethods(
            BlockingDeque<String> dequeBlocked) {

        // Adding data with offer, adds data to the tail of the queue
        boolean wasSuccessful = dequeBlocked.offer("Jane");
        wasSuccessful = dequeBlocked.offer("Anne");

        // offerLast is equivalent to offer, adds data to the tail
        wasSuccessful = dequeBlocked.offerLast("John");

        // offerFirst adds data to the head
        wasSuccessful = dequeBlocked.offerFirst("Mary");
        System.out.println(dequeBlocked);

        // Any offer method will return a false if unable to add element
        wasSuccessful = dequeBlocked.offer("Harold");
        if (wasSuccessful)
            System.out.println("Harold was added successfully");
        else System.out.println("Harold could not be added");
    }

    // This method uses add, addFirst, addLast methods and tests what
    // happens when queue capacity is reached.
    private static void useAddMethods(BlockingDeque<String> dequeBlocked) {
        // Adding data with add, adds data to the tail of the queue,
        // returns boolean
        boolean wasSuccessful = dequeBlocked.add("Jane");
        wasSuccessful = dequeBlocked.add("Anne");

        // addLast is similar to add, adds data to the tail,
        // but does NOT return a boolean, is void
        dequeBlocked.addLast("John");

        // addFirst adds data to the head, void return
        dequeBlocked.addFirst("Mary");
        System.out.println(dequeBlocked);

        try {

            // Any of the add methods will throw exception
            wasSuccessful = dequeBlocked.add("Harold");
            if (wasSuccessful) System.out.println("Harold was added");

        } catch (IllegalStateException ise) {
            System.out.println("Harold could not be added: " + ise);
        }
    }

    // This method uses push (a deque only method) which returns void
    // and tests what happens when queue capacity is reached.
    private static void usePushMethod(
            BlockingDeque<String> dequeBlocked) {

        // Adding data with push, adds data to the head of the queue
        dequeBlocked.push("Mary");
        dequeBlocked.push("Jane");
        dequeBlocked.push("Anne");
        dequeBlocked.push("John");

        System.out.println(dequeBlocked);
        try {
            // push method returns void, throws exception if not successful
            dequeBlocked.push("Harold");
            System.out.println("Harold was added");

        } catch (IllegalStateException ise) {
            System.out.println("Harold could not be added: " + ise);
        }
    }

    private static void usePutMethods(BlockingDeque<String> dequeBlocked) throws InterruptedException {
        // Adding data with put, adds data to the tail of the queue
        // All the add methods return a void
        dequeBlocked.put("Jane");
        dequeBlocked.put("Anne");

        // putLast is equivalent to put, adds data to the tail
        dequeBlocked.putLast("John");

        // putFirst adds data to the head
        dequeBlocked.putFirst("Mary");
        System.out.println(dequeBlocked);

        // A put method will block thread if not successful
        // and wait until queue has more capacity.
        // This application just hangs, because noting will change the capacity of the queue
        dequeBlocked.put("Harold");

        // System.out.println(dequeBlocked);
    }

    // This method uses the timeout versions of offer methods
    private static void useOfferMethodsTimed(
            BlockingDeque<String> dequeBlocked)
            throws InterruptedException {
        // Adding data with offer, adds data to the tail of the queue
        boolean wasSuccessful = dequeBlocked.offer("Jane", 1, TimeUnit.SECONDS);
        dequeBlocked.offer("Anne", 1, TimeUnit.SECONDS);

        // offerLast is equivalent to offer, adds data to the tail
        wasSuccessful = dequeBlocked.offerLast("John", 1, TimeUnit.SECONDS);

        // offerFirst adds data to the head
        wasSuccessful = dequeBlocked.offerFirst("Mary", 1, TimeUnit.SECONDS);
        System.out.println(dequeBlocked);

        // Any offer method will return a false if unable to add element
        wasSuccessful =
                dequeBlocked.offer("Harold", 1, TimeUnit.SECONDS);
        if (wasSuccessful)
            System.out.println("Harold was added successfully");
        else
            System.out.println("Harold decided not to wait longer" +
                    " than 1 second");

        wasSuccessful = dequeBlocked.offerFirst("Ida", 15, TimeUnit.SECONDS);
        if (wasSuccessful)
            System.out.println("Ida was added successfully");
        else
            System.out.println("Ida decided not to wait longer" +
                    " than 15 seconds");
    }

}