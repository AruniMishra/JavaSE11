/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 8: Lambda Operations on Stream
Topic:  Extract stream data using map, peek and flatMap
*/

import element.Course;
import element.Student;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExample {
    public static void main(String[] args) {

        // If the parameter in the stream returns a Scalar(eg: customer.getEmail() single email id) then use Map.
        // If the parameter returns a Vector(eg: customer.getPhoneNumbers(), customer.getProductsOrdered()
        // which returns a list) then use FlatMap.
        // Stream of Stream for FlatMap is one more key point to note...


        // Local Variable studentList will contain results
        List<Student> studentList = Stream.of(
                        // Stream of courses created
                        new Course("Geometry 101", 3),
                        new Course("Java 101", 5),
                        new Course("History 101", 4))
                // Map from course object to a stream of student objects, means:
                // flatMap operation to create a stream of student objects using the
                // coursesgetStudentList.stream method.
                .flatMap(course -> course.getStudentList().stream())
                // Terminal operation returns list of student
                .collect(Collectors.toList());

        // Print the entire student list for all courses
        System.out.println("Complete Student Population: ");
        studentList.forEach(System.out::println);
    }
}
