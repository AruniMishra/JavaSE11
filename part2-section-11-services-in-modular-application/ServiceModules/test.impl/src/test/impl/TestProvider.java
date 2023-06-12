/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 10: Services in Modular Application
Topic:  Service extras
*/

package test.impl;

// Class implements the TestService interface
public class TestProvider implements test.spi.TestService {

    /*
    This provider doesn't declare an explicit constructor or
    implement a provider method.
    The implicit no args constructor is the provider constructor here.
     */

    // Overrides method on the Service, TestService
    public void provideTheService() {
        System.out.println("TestProvider");
    }
}
