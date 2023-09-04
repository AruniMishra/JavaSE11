/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 11: Concurrency
Topic:  Submitting Callable vs Runnable vs Supplier
*/

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;

// Don't forget that Thread implements Runnable interface but
// Thread itself has a run() method which does nothing in this instance
class ThreadDoesNothing extends Thread {
    ThreadDoesNothing() {
        System.out.println("ThreadDoesNothing created");
    }
}

// Custom thread overrides the run() method
class ThreadDoesSomething extends Thread {

    public void run() {
        // Unchecked Exception
        throw new RuntimeException("Extended Thread chokes");

        // checked exception now, then need to throw exception, but can't do it for run()!
        // hence invalid.
        // throw new Exception("Extended Thread chokes");
    }

}

public class ThreadInterfacesReview {
    public static void main(String[] args) {

        //  Custom Thread does not override Thread's run() method
        new ThreadDoesNothing().start();

        // Custom Thread implements run(), throws RuntimeException
        new ThreadDoesSomething().start();


        // Get instance of SingleThreadExecutor
        ExecutorService service = Executors.newSingleThreadExecutor();

        // Call execute on service, and pass it an instance of Thread
        service.execute(new ThreadDoesNothing());

        // Call submit on service, and pass it an instance of Thread
        Future<?> f = service.submit(new ThreadDoesSomething());


        // Runnable variable assigned a lambda expression that
        // throws unchecked exception
        Runnable r1 = () -> {
            throw new RuntimeException(
                    "Runnable chokes in service.execute()");
        };
        try {
            // execute method called which is void
            service.execute(r1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Runnable variable assigned a lambda expression that
        // throws unchecked exception(RuntimeException)
        Runnable r2 = () -> {
            throw new RuntimeException(
                    // throw new Exception( // not valid
                    "Runnable chokes in service.submit()");
        };
        // submit method called which returns a Future
        Future<?> f1 = service.submit(r2);

        // Callable variable assigned a lambda expression that
        // throws unchecked exception
        Callable c = () -> {
            throw new RuntimeException(
                    // throw new Exception( // also valid.
                    // Cannot override a method that declares an exception in its throws clause
                    // with a less specific exception that we're trying to do here.
                    // i.e An overriding method cannot throw a superclass exception,
                    // throw new Throwable(
                    "Callable chokes in service.submit()");
            // return null;
        };
        // submit method called returns a Future
        Future f2 = service.submit(c);

        /*
        The execute method only takes a Runnable argument
        and, therefore,the lambda expression has to satisfy the same requirements for the run method,
        so it's a compiler error to have it throw a checked exception.
         */

        // service.execute(() -> {
        //     throw new Exception(
        //             "Callable chokes in service.submit()");
        // });


        // this is fine
        service.execute(() -> {
            try {
                throw new Exception(
                        "Callable chokes in service.submit()");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        // this is fine too, callable's call throws Exception
        service.submit(() -> {
            throw new Exception(
                    "Callable chokes in service.submit()");
        });


        class MyTask implements Callable<String> {
            public String call()
                    // throws Exception // valid, but can be commented
            {

                // do something
                return "Data from callable";
            }
        }

        // Supplier
        Supplier s = () -> {
            throw new RuntimeException(
                    "Suppplier::get chokes in service.submit()");
        };
        // Future f3 = service.submit(s); // invalid; submit takes callable or runnable
        Future f3 = service.submit(s::get);

        service.shutdown();

        System.out.println(f);
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);

        new Thread(() -> {
            throw new RuntimeException(

            /*
            a runnable cannot throw an (any)checked
            Exception and a thread is only constructed with a Runnable, hence the error.
             */
                    // throw new Exception(
                    "Lambda chokes in Thread constructed with Runnable");
        }).start();

    }
}