/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 8: Lambda Operations on Stream
Topic: Element to be used in sample streams
*/

package element;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Class Course will represent a parent, child relationship
public class Course {

    // Course has a name and some students
    private String courseName;
    private List<Student> studentList;

    // Constructor takes course name and a number which will
    // generate that number of randomly named students.
    public Course(String courseName, int studentNumber) {
        this.courseName = courseName;
        // Creating a studentList using generate
        this.studentList =
                Stream.generate(Student::new)
                        // Limiting to the number passed as argument
                        .limit(studentNumber)
                        // Adding course name to student name using map
                        .map((s) -> {
                            s.setName(s.getName() + " : " + courseName);
                            return s;
                        })
                        // returns stream as List<Student>
                        .collect(Collectors.toList());
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    // toString method shows course name and students
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ",studentList=" + studentList +
                '}';
    }
}