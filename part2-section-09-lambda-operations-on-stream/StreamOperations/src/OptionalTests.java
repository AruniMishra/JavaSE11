/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 8: Lambda Operations on Stream
Topic: Using the Optional Class
*/

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

// Create a CollegeStudent with a name & gpa
class CollegeStudent {

    // private Float gpa;
    private Optional<Float> gpa = Optional.empty();
    private String name;

    // Constructor
    CollegeStudent(String name) {
        this.name = name;
    }

    CollegeStudent(String name, float gpa) {
        this.name = name;
        // this.gpa = gpa;
        this.gpa = Optional.of(gpa);
    }

    // public Float getGpa() {
    public Optional<Float> getGpa() {
        return gpa;
    }

    public void setGpa(Float gpa) {
        // this.gpa = gpa;
        this.gpa = Optional.ofNullable(gpa);
    }

    public String getName() {
        return name;
    }

}

// Class to Test retrieving Gpa
public class OptionalTests {

    private static float getGpaEstimate() {
        System.out.println("--- in getGpaEstimate method");
        return 2.0f;
    }

    public static void main(String[] args) {
        CollegeStudent joe = new CollegeStudent("Joe", 3.2f);
        CollegeStudent jane = new CollegeStudent("Jane");

        List.of(joe, jane)
                .stream()
                .forEach(OptionalTests::printStatus);

        System.out.println("\n---------------------");

        Stream.of(joe, jane)
                .filter(s -> s.getGpa().isPresent())
                // .filter(s -> !s.getGpa().isEmpty()) // Can be replaced with 'isPresent()'
                .forEach(s -> System.out.println(s.getName() +
                        (s.getGpa().get() >= 2.0f
                                ? " in good standing" :
                                " on academic probation")));

        System.out.println("\nor()---------------------");


        List.of(joe, jane)
                .stream()
                .forEach(s -> System.out.println(s.getName() +
                        (s.getGpa()
                                // .or(() -> Optional.of(2.0f)) // valid
                                .or(() -> {
                                    System.out.println(
                                            "In Supplier Code for " + s.getName());
                                    return Optional.of(1.0f);
                                })
                                .get() >= 2.0f
                                ? " in good standing" :
                                " on academic probation")));

        System.out.println("Joe's gpa = " + joe.getGpa());
        System.out.println("Jane's gpa = " + jane.getGpa());


        System.out.println("\norElse---------------------");
        List.of(joe, jane)
                .stream()
                .forEach(s -> System.out.println(s.getName() +
                        (s.getGpa()
                                // .orElse(2.0f)
                                // .orElse(OptionalTests.getGpaEstimate()) // this will be called for both cases
                                // .orElseThrow() // NoSuchElementException
                                .orElseGet(OptionalTests::getGpaEstimate)
                                >= 2.0f
                                ? " in good standing" :
                                " on academic probation")));

    }

    /*
    // Print's student's academic status
    private static void printStatus1(CollegeStudent student) {
        System.out.print(student.getName());

        if (student.getGpa() < 2.0) { // java.lang.NullPointerException
            System.out.println(" is on academic probation");
        } else {
            System.out.println(" is in good standing");
        }
    }
    */

    /*
    // valid, without Optional
    // Print's student's academic status
    private static void printStatus(CollegeStudent student) {
        System.out.print(student.getName());

        if (student.getGpa() != null) {
            if (student.getGpa() < 2.0) {
                System.out.println(" is on academic probation");
            } else {
                System.out.println(" is in good standing");
            }
        } else System.out.println(" has an unknown gpa");
    }
    */


    // Print's student's academic status
    private static void printStatus(CollegeStudent student) {
        System.out.print(student.getName());
        Optional<Float> gpa;
        if ((gpa = student.getGpa()).isPresent()) {
            if (gpa.get() < 2.0) {
                System.out.println(" is on academic probation");
            } else {
                System.out.println(" is in good standing");
            }
        } else System.out.println(" has an unknown gpa");
    }
}

