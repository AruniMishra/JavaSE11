
/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 10: Services in Modular Application
Topic:  Service extras
*/

package test.consumer;

import test.spi.TestService;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class Client {
    public static void main(String[] args) {

        List<TestService> providers = new ArrayList<>();

        // Call the ServiceLoader.Load method to load providers
        ServiceLoader.load(TestService.class).forEach(providers::add);

        TestService serviceImpl = null;
        if (providers.size() > 0) {
            // Print the # of providers found
            System.out.println("Found " + providers.size() + " providers");

            // Print out each Provider
            providers.stream().forEach(System.out::println);

            // Use the last one
            serviceImpl = providers.get(providers.size() - 1);

            // Execute the provideTheService method
            serviceImpl.provideTheService();
        } else {
            // If no providers found, print that
            System.out.println("No provider provided");
        }
    }
}

