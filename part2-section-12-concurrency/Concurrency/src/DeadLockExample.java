/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 11: Concurrency
Topic:  DeadLock Example
*/

// Simple Neighbor class, has a name
class Neighbor {
    private final String name;

    // Constructor
    public Neighbor(String name) {
        this.name = name;
    }

    // synchronized method cannot execute if the instance is locked,
    // will lock instance when operation is invoked, and release lock
    // when operation completes
    public synchronized void greet(Neighbor neighbor) {
        System.out.println("Hi " + neighbor.name
                + ", how are you?");
        System.out.println(this.name + "'s thread is blocked, waiting for "
                + neighbor.name + " to respond before releasing lock.");

        // lock on current instance will not be released until this method(respond)
        // completes, but "respond" cannot be invoked because the neighbor
        // instance is blocked waiting for current instance to unlock
        /*
        The execution will deadlock because each thread cannot complete the first operation,
        the "greet", until the second operation is completed the "respond".
        But the second operation cannot be invoked
        because the thread cannot lock the current neighbor because it's already locked.
         */
        neighbor.respond(this);
    }

    // synchronized method cannot execute if the instance is locked,
    // Must wait for lock on instance to be released
    // public synchronized void respond(Neighbor neighbor) { // deadlock now
    public void respond(Neighbor neighbor) { // no deadlock now
        System.out.println("I am fine, " + neighbor.name +
                ", how are the kids? ");
    }

}

// Simple deadlock example
public class DeadLockExample {

    public static void main(String[] args) {
        // Create two neighbors
        Neighbor dave = new Neighbor("Dave");
        Neighbor craig = new Neighbor("Craig");

        // Create and execute two threads, 
        // each has the neighbor greet the other.
        new Thread(() -> dave.greet(craig)).start();
        new Thread(() -> craig.greet(dave)).start();
    }
}