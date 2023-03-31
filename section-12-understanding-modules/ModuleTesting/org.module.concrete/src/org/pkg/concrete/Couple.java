
package org.pkg.concrete;

import org.pkg.appglobals.ApplicationConstants;
import org.pkg.util.Countable;

public class Couple implements Countable {

    // Constructor calls the countMe method
    public Couple() {
        countMe();
    }

    // implement countMe method from the interface
    public void countMe() {
        ApplicationConstants.addCounter();
        ApplicationConstants.addCounter();
    }
}