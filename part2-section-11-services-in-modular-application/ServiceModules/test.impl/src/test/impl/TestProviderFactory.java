/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 10: Services in Modular Application
Topic:  Service extras
*/

package test.impl;

import test.spi.TestService;

import java.util.Random;

// This class does NOT implement the TestService interface
public class TestProviderFactory {

    // This class has a provider method which returns an
    // instance of a TestService
    /*
    If you change the provider method signature in any way by changing the
    access modifier, removing a static keyword or adding a parameter to the
    method, you'll get a compiler error in the module descriptor when you add the
    provides directive for this provider.
     */
    public static TestService provider() {
        System.out.println("TestProviderFactory provider method being executed\n");

        // Maybe you have some logic to figure out which Provider
        // will be used, in this case, it's random
        int choice = new Random().nextInt(2);

        // Return one or the other Providers that implement TestService
        if (choice == 1) return new TestProvider();
        return new TestProviderTwo();
    }
}
