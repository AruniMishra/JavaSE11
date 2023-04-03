/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 9: Reusing Implementations Through Inheritance
Topic: Create and use subclasses and superclasses
*/

package com.petstore;

import java.time.LocalDate;

//  Animal is our most generic class.
public class Animal {

    // We describe elements that all instances would have
    private String name = "Unspecified";
    private String owner = "Unspecified";
    private String breed = "Unspecified";
    private AnimalType type = AnimalType.UNKN;

    // It could be argued a locator chip may or may not be on every pet
    // but we add it here
    private LocalDate chipDate;

    // You can define an enum within a class.  Here we
    // define some of the animals we expect to see as subclasses
    static enum AnimalType {

        CAT, DOG, HORSE, HAMSTER, GOAT, SHEEP, UNKN;
    }

    // Constructor is the means we'll use to populate properties
    // on Animal
    Animal(String name, String owner, String breed, AnimalType type) {
        //System.out.println("Animal constructor");
        this.name = name;
        this.owner = owner;
        this.breed = breed;
        this.type = type;
    }

    // toString return's a nice formatted String that describes Animal
    public String toString() {
        return this.owner + "'s " + this.type + " is a " +
                this.breed + " named " + this.name;
    }

    // We limit getters/setters for demo purposes here
    // just to this one particular attribute
    public LocalDate getChipDate() {
        System.out.println("parent getChipDate");
        return chipDate;
    }

    public void setChipDate(LocalDate chipDate) {
        this.chipDate = chipDate;
    }

    // static method describing what steps are required to examine the Animal
    public static void examineAnimal() {
        System.out.println("Check eyes");
        System.out.println("Check teeth");
        System.out.println("Check coat");
    }
}