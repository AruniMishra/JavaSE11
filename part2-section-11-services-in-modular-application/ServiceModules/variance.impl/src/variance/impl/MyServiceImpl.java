/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 10: Services in Modular Application
Topic:  Service Extras
*/

package variance.impl;

import variance.spi.MyService1;
import variance.spi.MyService2;

public class MyServiceImpl implements MyService1, MyService2 {

    /*
    From this example, you can see that you can have a single
    provider that implements multiple service provider interfaces.
     */

    public void doSomething() {
        System.out.println("MyServiceImpl is Doing Something");
    }
}
