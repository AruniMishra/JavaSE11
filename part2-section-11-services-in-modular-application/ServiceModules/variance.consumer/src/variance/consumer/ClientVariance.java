/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 10: Services in Modular Application
Topic:  Service Extras
*/

package variance.consumer;

import variance.spi.MyService1;
import variance.spi.MyService2;

import java.util.ServiceLoader;

public class ClientVariance {
    public static void main(String[] args) {
        /*
        From this example, you can see that you can have a single
        provider that implements multiple service provider interfaces.
         */

        MyService2 s1 = ServiceLoader.load(MyService2.class)
                // ServiceLoader.findFirst() returns an Optional
                .findFirst()
                // Need to use .get() on Optional to get a PayOffService
                .get();

        MyService1 s2 = ServiceLoader.load(MyService1.class)
                // ServiceLoader.findFirst() returns an Optional
                .findFirst()
                // Need to use .get() on Optional to get a PayOffService
                .get();

        s1.doSomething();
        s2.doSomething();
    }
}
