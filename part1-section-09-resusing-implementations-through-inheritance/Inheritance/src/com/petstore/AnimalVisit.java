
package com.petstore;

import java.time.LocalDate;

class Dog extends Animal {

    // Supplement fields
    private int pedigreeId;

    // Hide field on superclass
    private LocalDate chipDate;

    // Constructors are not inherited, create one, pass thru to super
    public Dog(String name, String owner, String breed,
               AnimalType type, int pedigreeId) {
        super(name, owner, breed, type);
        this.pedigreeId = pedigreeId;
    }

    // override toString method and extend functionality of the superclass
    public String toString() {
        String str = super.toString();
        if (pedigreeId > 0) {
            str += " (pedigree Id = " + pedigreeId + ")";
        }
        return str;
    }

    public static void examineAnimal() {
        System.out.println("Examine for breathing problems");
    }

    public LocalDate getChildChipDate() {
        System.out.println("child getChildChipDate");
        return chipDate;
    }

//    public LocalDate getChipDate() {
//        System.out.println("child getChipDate");
//        return chipDate;
//    }

    // Hides method on parent
    public void setChipDate(LocalDate chipDate) {
        this.chipDate = chipDate;
    }
}

public class AnimalVisit {
    public static void main(String[] args) {

        // Create a Dog
        Dog pug = new Dog("George", "Ralph", "Pug", Animal.AnimalType.DOG, 775533);

        // Call a method on the superclass from the subclass instance
        pug.setChipDate(LocalDate.now());

        // Call the overridden method (note that toString() is implied
        System.out.println(pug);

        // Call the overridden method
        System.out.println("Chip Date = " + pug.getChipDate());

        // Try to force the call to the parent's method
        Animal a = pug;
        System.out.println("Chip Date = " + a.getChipDate());

        // Call the supplemented method
        System.out.println("Chip Date = " + pug.getChildChipDate());

        // Call the static methods
        Animal.examineAnimal();
        Dog.examineAnimal();
    }
}