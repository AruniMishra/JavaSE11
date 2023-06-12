/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 10: Services in Modular Application
Topic:  Describing Service Components, The Service Provider
*/

package gamble.slots.spi;

// This is the Service Provider Interface which represents
// the PayOff Service - in this case they are the same interface.
public interface PayOffService {
    // Methods which describe different types of payoffs.
    public void hitTheJackPot();

    public void threeInRow(SlotType s);

    public void twoInRow(SlotType s);

    // Enum representing slot machine images
    enum SlotType {
        FRUIT, JACKPOT, GOLDBAR_ONE, GOLDBAR_TWO, GOLDBAR_THREE;
    }
}
