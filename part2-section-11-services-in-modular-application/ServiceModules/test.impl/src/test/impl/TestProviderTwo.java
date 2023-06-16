/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 10: Services in Modular Application
Topic:  Service extras
*/

package test.impl;

// This class implements the TestService interface
public class TestProviderTwo implements
        // test.spi.TestService {

        // confirms that you can supply a provider that implements
        // the sub-interface of the interface specified in the provides directive(test.impl.TestProviderTwo).
        test.impl.EnhancedTestService {

    // Public explicit no args constructor
    public TestProviderTwo() {
        System.out.println("TestProviderTwo constructor");
    }

    // method overrides the abstract method from TestService interface
    public void provideTheService() {
        System.out.println("TestProviderTwo");
    }
}
