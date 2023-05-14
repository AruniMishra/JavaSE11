
/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 8: Lambda Operations on Stream
Topic: Element to be used in sample streams
*/

package element;

import java.util.Random;

public class Student {

    // This String array will be used to create a random name for each
    // Student instance
    private String[] namesArray = {"Allen", "Bob", "Caleb", "Don", "Fred",
            "Greg", "Howard", "Ira", "James", "Kevin"};
    private String name;

    // Create an internal id generator
    private static int lastId = 1000;
    // Student id field
    private int studentId;

    // initializer assigns a name at random and studentId
    {
        int i = new Random().nextInt(10);
        this.name = namesArray[i];
        // Generate new id for new student
        this.studentId = ++lastId;
    }

    public String toString() {
        return "[" + this.studentId + " : " + this.name + "] ";
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }



}