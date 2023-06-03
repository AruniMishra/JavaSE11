/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 16:  Localization
Topic:  Class to be used as a Resource Element
*/

public class Employee {
    private String name;
    private String dept;
    private String title;

    // Constructor
    Employee(String name,
             String dept,
             String title) {
        System.out.println("Constructing Employee");
        this.name = name;
        this.dept = dept;
        this.title = title;
    }

    // override toString
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}