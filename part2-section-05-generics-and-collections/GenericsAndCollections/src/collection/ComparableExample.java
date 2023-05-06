package collection;/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Comparable interface
*/

import java.util.Set;
import java.util.TreeSet;

// Class orders dogs by how smart they are claimed to be
class SmartDog implements Comparable<SmartDog> {

    // dogType determines smart Factor
    public DogType dogType;

    // Constructor takes a dog type
    public SmartDog(DogType t) {
        this.dogType = t;
    }

    // Overrides Comparable compareTo method with custom implementation
    public int compareTo(SmartDog o) {
        System.out.println("Comparing " + this + " with argument " + o +
                " = " + (this.dogType.smartLevel - o.dogType.smartLevel));
        return this.dogType.smartLevel - o.dogType.smartLevel;
    }

    public String toString() {
        return this.dogType.toString();
    }

    // Enum represents how smart dogs are from 1 to 6, 6 being the dumbest
    public enum DogType {
        POODLE(1),
        LABRADOODLE(2),
        COLLIE(3),
        LABRADOR(4),
        PUG(5);

        // default dogs to the dumbest level
        int smartLevel = 6;

        DogType(int smartLevel) {
            this.smartLevel = smartLevel;
        }
    }
}

// Class tests which dogs are the smartest
public class ComparableExample {
    public static void main(String[] args) {

        // --Option1
        System.out.println("-----TreeSet start constructing -------");
        Set<SmartDog> dogSet = new TreeSet<>(
                Set.of(
                        new SmartDog(SmartDog.DogType.COLLIE),
                        new SmartDog(SmartDog.DogType.LABRADOODLE),
                        new SmartDog(SmartDog.DogType.PUG),
                        new SmartDog(SmartDog.DogType.POODLE),
                        new SmartDog(SmartDog.DogType.LABRADOR))
        );

        System.out.println("-----TreeSet constructed-------");
        System.out.println("Sorted Dogs " + dogSet);
        // --Option1 end


        /*
        // --Option2
        Or, using SmartDogComparator implements Comparator<collection.SmartDog>
         */

        // ArrayList<collection.SmartDog> al = new ArrayList<collection.SmartDog>();
        // al.add(new collection.SmartDog(collection.SmartDog.DogType.COLLIE));
        // al.add(new collection.SmartDog(collection.SmartDog.DogType.LABRADOODLE));
        // al.add(new collection.SmartDog(collection.SmartDog.DogType.PUG));
        // al.add(new collection.SmartDog(collection.SmartDog.DogType.POODLE));
        // al.add(new collection.SmartDog(collection.SmartDog.DogType.LABRADOR));
        // Collections.sort(al, new SmartDogComparator());
        // System.out.println("Sorted Dogs " + al);

        // --Option2 end
    }
}

