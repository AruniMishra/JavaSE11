/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 8: Migration to Modular Application
Topic:  Using Jdeps to identify issues before running on modular jdk
*/

package pkg.util;

public class Utilities {
    public static void doUniversalStuff() {
        System.out.println("module com.a.util: pkg.util.Utilities does something");
    }
}
