/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 9: Migration to Modular System.
*/
package sample.service;

import sample.core.UtilityClass;
import sample.entity.EntityOne;

public class ServiceOne {
    // has a private attribute of EntityOne
    private EntityOne e = new EntityOne("ServiceOne has an entity");

    // Constructor which uses UtilityClass
    public ServiceOne(String s) {
        UtilityClass.doSomethingStatic("ServiceOne instantiated with " + s);
    }
}