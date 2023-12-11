/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 11: Concurrency
Topic:  Subclassing Thread
*/

import java.util.Random;
import java.util.stream.Stream;

// Create a custom thread that extends Thread
class MyCustomThread extends Thread {
    // Passing a seed value, code will print numbers in increments
    // of the seed value
    private int seed = 0;

    // Constructor accepts a seed value
    MyCustomThread(String threadName, int seed) {
        // Chaining Thread constructor, passing thread name.
        super(threadName);
        this.seed = seed;
    }

    // Method overrides Thread.run.  This is implementation of task
    // to be executed
    public void run() {

        // Infinite stream of numbers, defined by seed attribute
        Stream<Integer> infiniteStream = Stream.iterate(this.seed, (t) -> t + this.seed);
        try {
            infiniteStream.forEach(s -> {
                // must satisfy catch/specify for InterruptedException
                try {
                    // numbers printed every half a second
                    sleep(500);
                } catch (InterruptedException ie) {
                    // throws an unchecked method when interrupted
                    throw new RuntimeException("interrupted");
                }
                // print numbers and include thread name
                System.out.print(this.getName() + ": " + s + "; ");
            });
        } catch (RuntimeException re) {
            // Print a statement and terminate cleanly
            System.out.println("\nInterrupted " + this.getName() + "'s execution");
        }
    }
}

public class CustomThreadCreation {

    // Main method will spawn two asynchronous threads.  Thread.sleep
    // throws InterruptedException, declared in throws clause here
    public static void main(String[] args) throws InterruptedException {

        // This task will print numbers out in increments of 5
        Thread t = new MyCustomThread("Fives-", 5);

        // This task will print numbers out in increments of 7
        Thread v = new MyCustomThread("Sevens", 7);

        // Start both tasks using Thread.start() - which executes run
        t.start();
        v.start();

        // Pauses current thread(main) for 3 seconds allowing other asynchronous
        // tasks time to run a bit
        Thread.sleep(3000);

        // interrupt one of the threads
        v.interrupt();

        // Do some work in the current thread slowly..
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1500);
            System.out.println("\nmain thread executing: " + i);
        }
        // Pause current thread again..
        Thread.sleep(3000);

        // Interrupt second asynchronous thread
        t.interrupt(); // doesn't guarantee when the thread will interrupt

        while (t.isAlive()) {
            System.out.println("\nWaiting for " + t.getName() + " to terminate");
            Thread.sleep(150);
        }

        System.out.println("\nAll threads interrupted, Terminating");


        System.out.println("\n\n---Demonstrating using join");

        // Create local class of type Thread,  implement the run() method
        // creating a stream of 10 random numbers between 1 and 100
        Thread n2 = new Thread() {
            public void run() {
                new Random().ints(10, 1, 100)
                        .forEach(System.out::println);
            }
        };

        // Call start() which executes local class's run()
        n2.start();

        // The join method waits for the thread to complete
        n2.join();
        System.out.println("The status of thread after join: ");
        System.out.println("n2.isAlive=" + n2.isAlive());
        System.out.println("n2.isInterrupted=" + n2.isInterrupted());


    }
}
