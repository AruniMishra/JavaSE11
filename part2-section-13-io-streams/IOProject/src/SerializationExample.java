/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 13:  I/O (Fundamentals and NIO2)
Topic: Serialization / Deserialization
*/

import java.io.*;

/*
When a superclass does not implement Serializable,
its attributes are not serialized,
but the constructor is called during deserialization.
 */
// class Animal implements Serializable {
class Animal {
    int age;
    int weight;

    // default no-args constructor is must, if this class doesn't "implements Serializable"
    Animal() {
        System.out.println("Inside no args Animal constructor");
    }

    Animal(int age) {
        System.out.println("Inside no args Animal constructor");
    }
}


// Class must implement Serializable if it does not extend
// a class that implements Serializable...
// class Pet implements Serializable {
class Pet extends Animal implements Serializable { // pet is Serializable, is Super class is Serializable

    private String name;
    private String type;

    // add below field once "Brandy.ser" is created,
    // and then comment outputStream.writeObject(originalPet);
    // private String breed = "Unknown"; // then deserialization fails

    /*
    the transient modifier indicates that the attribute
    will not be part of the persistent state of an object serialization
    or deserialization
     */
    private transient String breed = "Unknown"; // however this works

    // No arguments constructor
    Pet() {
        super(0);
        System.out.println("Inside no args Pet constructor");
    }

    // Constructor takes name and type of Pet
    Pet(String name, String type) {
        super(0);
        this.name = name;
        this.type = type;
        System.out.println("Inside Pet(name,type) constructor");
    }

    /// Use IntelliJ generated toString() method
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", breed='" + breed + '\'' +
                ", age='" + age + '\'' + // from Animal class
                ", weight ='" + weight + '\'' +
                '}';
    }
}

public class SerializationExample {
    public static void main(String[] args) throws IOException,
            ClassNotFoundException {

        String fileName = "Brandy.ser";

        Pet originalPet = new Pet("Brandy", "Dog");
        originalPet.age = 5; // did not serialize, if Animal is not serialized
        originalPet.weight = 30; // // did not serialize, if Animal is not serialized
        System.out.println("\n--------- Original State -----------");
        System.out.println(originalPet);

        // Use try with resources (automatically closes file) to output
        // the Pet object
        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream(fileName))) {
            // write the Pet to a file
            outputStream.writeObject(originalPet);
        }

        Pet deserializedPet = null;
        // Use try with resources (automatically closes file) to input
        // the Pet object
        try (ObjectInputStream inStream = new ObjectInputStream(
                new FileInputStream(fileName))) {
            try {
                // read the Pet from a file
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
