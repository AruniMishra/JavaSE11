/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 13:  I/O (Fundamentals and NIO2)
Topic: Serialization / Deserialization
*/
package Serializable;

import java.io.*;

/*
When a superclass does not implement Serializable,
its attributes are not serialized,
but the constructor is called during deserialization.
 */
// class Serializable.Animal implements Serializable {
class Animal {
    int age;
    int weight;

    // default no-args constructor is must, if this class doesn't "implements Serializable"
    // even if this is not invoked.
    Animal() {
        System.out.println("Inside no args Serializable.Animal no args constructor");
    }

    Animal(int age) {
        System.out.println("Inside no args Serializable.Animal parameterized constructor");
    }
}


// Class must implement Serializable if it does not extend
// a class that implements Serializable...
// by default, all non-static and non-transient are persisted
// class Serializable.Pet implements Serializable {
class Pet extends Animal implements Serializable { // pet is Serializable, is Super class is Serializable

    /*
    We're going to comment out the code that's writing the file again.
    We're going to go back and change the value of pet.count from 10 to 55.
    So we're not rewriting it out again now. Run it again.
    You can see that count will be whatever pet.count's current value is
    upon deserialization.
    Remember static values are not part of an object state, but the classes.

    and,
    While de-serializing, transient fields are initialized to default values
    (null for reference type and respective Zeros for primitive types) and static fields refer to current value.
     */
    static int count;
    private String name;

    // add below field once "Brandy.ser" is created,
    // and then comment outputStream.writeObject(originalPet);
    // private String breed = "Unknown"; // then deserialization fails
    private String type;
    /*
    the transient modifier indicates that the attribute
    will not be part of the persistent state of an object serialization
    or deserialization
     */
    private transient String breed = "Unknown"; // however this works with out.writeUTF(breed);

    // No arguments constructor
    Pet() {
        super(0);
        System.out.println("Inside no args Serializable.Pet constructor");
    }

    // Constructor takes name and type of Serializable.Pet
    Pet(String name, String type) {
        super(0);
        this.name = name;
        this.type = type;
        System.out.println("Inside Serializable.Pet(name,type) constructor");
    }

    /// Use IntelliJ generated toString() method
    public String toString() {
        return "Serializable.Pet{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", breed='" + breed + '\'' +
                ", age='" + age + '\'' + // from Serializable.Animal class
                ", weight ='" + weight + '\'' +
                ", count ='" + count + '\'' +
                '}';
    }


    // overrides default method on Serializable
    private void writeObject(java.io.ObjectOutputStream out)
            throws IOException {
        out.defaultWriteObject(); // until this line, has no effect, (Serializable.Animal is not serialized)
        out.writeInt(age); // now serialized
        out.writeInt(weight);
        out.writeUTF(breed); // here transient also gets serialized
    }

    // overrides default method on Serializable
    private void readObject(java.io.ObjectInputStream in)
            throws IOException, ClassNotFoundException {
        /*
        The objects must be read back from the corresponding ObjectInputstream with the same types
        and in the same order as they were written.
         */
        in.defaultReadObject(); // Read the non-static and non-transient fields of the current class from this stream.
        age = in.readInt();
        weight = in.readInt();
        breed = in.readUTF(); // note: transient being read here.
    }


}

public class SerializationExample {
    public static void main(String[] args) throws IOException,
            ClassNotFoundException {

        String fileName = "Brandy.ser";

        Pet originalPet = new Pet("Brandy", "Dog");
        originalPet.age = 5; // did not serialize, if Serializable.Animal is not serialized
        originalPet.weight = 30; // // did not serialize, if Serializable.Animal is not serialized
        Pet.count = 10;
        System.out.println("\n--------- Original State -----------");
        System.out.println(originalPet);

        System.out.println("\n-- Serializing started...");
        // Use try with resources (automatically closes file) to output
        // the Serializable.Pet object
        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream(fileName))) {
            // write the Serializable.Pet to a file
            outputStream.writeObject(originalPet);
        }
        System.out.println("-- Serializing done.");

        System.out.println("\n\n------- Deserializing started ------");
        Pet deserializedPet = null;
        // Use try with resources (automatically closes file) to input
        // the Serializable.Pet object
        try (ObjectInputStream inStream = new ObjectInputStream(
                new FileInputStream(fileName))) {
            try {
                // read the Serializable.Pet from a file
                deserializedPet = (Pet) inStream.readObject();

                // Need to check for EOFException
            } catch (EOFException e) {
                // Ignore, end of file
            }
        }

        System.out.println("\n------- Deserialized State ------");
        System.out.println(deserializedPet);

    }
}


/*

Only 4 methods are used to serialize/de-serialize objects:
Object readObject(ObjectInputStream ois), void writeObject(ObjectOutputStream oos),
Object writeReplace() & Object readResolve().
 */