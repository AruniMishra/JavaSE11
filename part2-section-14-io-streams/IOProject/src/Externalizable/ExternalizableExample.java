/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 13:  I/O (Fundamentals and NIO2)
Topic: Serialization / Deserialization
*/
package Externalizable;

import java.io.*;


class Animal2 {
    int age;
    int weight;

    // default no-args constructor is must, if this class doesn't "implements Serializable"
    Animal2() {
        System.out.println("Inside no args Serializable.Animal constructor");
    }

    Animal2(int age) {
        System.out.println("Inside no args Serializable.Animal constructor");
    }
}


// Class must implement Serializable if it does not extend
// a class that implements Serializable...
// by default, None including non-static and non-transient are persisted.
// class Serializable.Pet implements Serializable {
class Pet2 extends Animal2 implements Externalizable { // pet is Serializable, is Super class is Serializable

    /*
    We're going to comment out the code that's writing the file again.
    We're going to go back and change the value of pet.count from 10 to 55.
    So we're not rewriting it out again now. Run it again.
    You can see that count will be whatever pet.count's current value is
    upon deserialization.
    Remember static values are not part of an object state, but the classes.
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
    private transient String breed = "Unknown"; // however this works

    // No arguments constructor
    public Pet2() { // must be public
        super(0);
        System.out.println("Inside no args Serializable.Pet constructor");
    }

    // Constructor takes name and type of Serializable.Pet
    Pet2(String name, String type) {
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
    private void writeObject(ObjectOutputStream out)
            throws IOException {
        out.defaultWriteObject(); // until this line, has no effect, (Serializable.Animal is not serialized)
        out.writeInt(age); // now serialized
        out.writeInt(weight);
    }

    // overrides default method on Serializable
    private void readObject(ObjectInputStream in)
            throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        age = in.readInt();
        weight = in.readInt();
    }

    // Manually write the code to output what you want...
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("writeExternal");
        out.writeObject(name);
        out.writeObject(breed);
        out.write(age);
    }

    // Manually write the code to input same data
    public void readExternal(ObjectInput in) throws IOException,
            ClassNotFoundException {
        System.out.println("readExternal");
        name = (String) in.readObject();
        breed = (String) in.readObject();
        age = in.read();
    }

}

public class ExternalizableExample {
    public static void main(String[] args) throws IOException,
            ClassNotFoundException {

        String fileName = "Brandy.ser";

        Pet2 originalPet = new Pet2("Brandy", "Dog");
        originalPet.age = 5; // did not serialize, if Serializable.Animal is not serialized
        originalPet.weight = 30; // // did not serialize, if Serializable.Animal is not serialized
        Pet2.count = 10;
        System.out.println("\n--------- Original State -----------");
        System.out.println(originalPet);

        // Use try with resources (automatically closes file) to output
        // the Serializable.Pet object
        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream(fileName))) {
            // write the Serializable.Pet to a file
            outputStream.writeObject(originalPet);
        }

        Pet2 deserializedPet = null;
        // Use try with resources (automatically closes file) to input
        // the Serializable.Pet object
        try (ObjectInputStream inStream = new ObjectInputStream(
                new FileInputStream(fileName))) {
            try {
                // read the Serializable.Pet from a file
                deserializedPet = (Pet2) inStream.readObject();

                // Need to check for EOFException
            } catch (EOFException e) {
                // Ignore, end of file
            }
        }

        System.out.println("\n------- Deserialized State ------");
        System.out.println(deserializedPet);

    }
}
