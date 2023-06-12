/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 10: Services in Modular Application
Topic:  Describing Service Components, Additional Provider using
        public no args constructor
*/

package njvirtual.slots.impl;

import gamble.slots.spi.PayOffService;

// This provider implements the PayOffService with different prizes
public class ACPayOffService implements PayOffService {

    // this is a provider class
    // This class has a public no args constructor, and does
    // not declare a static provider method(static PayOffService provider()).
    public ACPayOffService() {
        System.out.println("Atlantic City PayOffService loaded");
    }

    public void hitTheJackPot() {
        System.out.println("Voucher for free week at Caeser's");
    }

    public void threeInRow(SlotType s) {
        System.out.println("Voucher for Free Show at Atlantis");
    }

    public void twoInRow(SlotType s) {
        System.out.println("Voucher for 50 Trump tokens");
    }
}

