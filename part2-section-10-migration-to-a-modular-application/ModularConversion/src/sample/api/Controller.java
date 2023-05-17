/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 9: Migration to Modular System.
*/
package sample.api;

import sample.core.UtilityClass;
import sample.entity.EntityOne;
import sample.service.ServiceOne;

public class Controller {

    ServiceOne s = new ServiceOne("Controller has a service");
    EntityOne e = new EntityOne("Controller has an entity");

    // Constructor
    Controller(String s) {
        UtilityClass.doSomethingStatic("Controller instantiated with " + s);
    }

    // main method and executes queryModuleData on classes in different packages
    // and modules.
    public static void main(String[] args) {

        // query the module UtilityClass is in
        queryModuleData(UtilityClass.class);

        // query the module current class is in
        queryModuleData(Controller.class);

        // query the java.util.logging.Logger class
        queryModuleData(java.util.logging.Logger.class);

    }

    private static void queryModuleData(Class cls) {
        System.out.println("\n------------ class: " + cls);
        Module module = cls.getModule();
        System.out.println("Module: " + module);
        System.out.println("Module Name: " + module.getName());
        System.out.println("isNamed: " + module.isNamed());
        System.out.println("Module Descriptor: " + module.getDescriptor());
        if (module.getDescriptor() != null)
            System.out.println("isAutomatic: " + module.getDescriptor().isAutomatic());
    }
}