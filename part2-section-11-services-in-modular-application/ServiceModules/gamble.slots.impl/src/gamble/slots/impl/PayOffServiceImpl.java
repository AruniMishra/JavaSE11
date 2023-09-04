/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 10: Services in Modular Application
Topic:  Implementing the Service
*/

package gamble.slots.impl;

import gamble.slots.spi.PayOffService;

// This class implements the PayOffService
public class PayOffServiceImpl implements PayOffService {


    String className = this.getClass().getSimpleName().concat(" :: ");

    // This is a static provider method, one of the two ways to
    // configure a Provider


    public static PayOffService provider() {
        System.out.println("PayOffServiceImpl is getting loaded" +
                " by provider method");
        return new PayOffServiceImpl();
    }

    // Provide implementations of the PayOffService's methods
    public void hitTheJackPot() {
        System.out.println(className + "Whoo Hoo!  Quit your job baby.");
    }

    public void threeInRow(SlotType s) {
        System.out.println(className + "Dinner is on the house");
    }

    public void twoInRow(SlotType s) {
        System.out.println(className + "10 Credits to keep betting");
    }
}


/*
Also,
If a service provider has public static provider() method, then it is not required for the service provider to be
a subtype of the service type. Only the provider method should return a subtype of the service type
 */
class PayOffServiceImpl2 {

    public static PayOffService provider() {
        System.out.println("PayOffServiceImpl is getting loaded" +
                " by provider method");
        return new PayOffService() {
            @Override
            public void hitTheJackPot() {

            }

            @Override
            public void threeInRow(SlotType s) {

            }

            @Override
            public void twoInRow(SlotType s) {

            }
        };
    }
}
