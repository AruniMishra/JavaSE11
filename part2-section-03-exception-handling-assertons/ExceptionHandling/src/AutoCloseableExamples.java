/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 3: Exception Handling and Assertions
Topic:  Use try-with-resources construct
Sub-Topic:  Implementing AutoCloseable
*/

// Make the Door AutoCloseable
class Door implements AutoCloseable {

    // Must Implement close() method, which is invoked in the
    // implicit finally clause of try-with-resources statement
    public void close() {
        System.out.println("Executing close(): The door is closing");
    }

    // Forcing an Exception to see what happens
    public void doSomething() throws NullPointerException {
        throw new NullPointerException(this.getClass().getName() +
                " is null");
    }
}

// Make the Alarm AutoCloseable
class Alarm implements AutoCloseable {

    // Must Implement close() method, which is invoked in the
    // implicit finally clause of try-with-resources statement
    public void close() {
        System.out.println("Executing close(): The alarm is armed");
    }
}

// Class to test basic try-with-resources statement
public class AutoCloseableExamples {
    public static void main(String[] args) {

        // Very simple example, to confirm that resources are
        // closed in reverse order of their declaration here...
        try (Alarm a = new Alarm();
             Door d = new Door()) {

            d.doSomething();

        } catch (NullPointerException ne) {
            System.out.println(ne);
        }
        // We can use finally clause with try-with-resources
        finally {
            System.out.println("Resources are closed so I can go.");
        }

    }
}
