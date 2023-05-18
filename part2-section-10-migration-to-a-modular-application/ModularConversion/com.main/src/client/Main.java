/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 8: Migration to Modular Application
Topic:  Using Jdeps to identify issues before running on modular jdk
*/
package client;

import pkg.util.StaticStuff;
import pkg.util.Utilities;

public class Main {
    public static void main(String[] args) {
        Utilities.doUniversalStuff();
        StaticStuff.doStaticStuff();
    }
}
