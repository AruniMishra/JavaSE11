/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 8: Lambda Operations on Stream
Topic:  Extract stream data using map, peek and flatMap
*/

import element.Student;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapExamples {

    public static void main(String[] args) {
        PeekExamples p = new PeekExamples();

        // Create a studentList of 5 students
        List<Student> firstList = Stream.generate(Student::new)
                .limit(5).collect(Collectors.toList());

        // Generally, if you want to transform data on a stream, it's better
        // practice to use a mapping function (than peek())
        List<Student> secondList =
                firstList.stream()
                        // Using map to call changeStudent() method
                        .map(MapExamples::changeStudent)
                        // Terminal operation returns List
                        .collect(Collectors.toList());

        System.out.println("firstList = " + firstList);
        System.out.println("secondList = " + secondList);

        System.out.println("Both Lists have the same elements: " +
                firstList.containsAll(secondList));


        Set firstset =
                firstList.stream()
                        // Map a student to an Map.Entry (key,value)
                        .map(MapExamples::mapStudent)
                        // Terminal operations returns a Set
                        .collect(Collectors.toSet());

        System.out.println("firstset = " + firstset);


        // Using an IntStream
        System.out.println("\n\nOutput from an IntStream using map");
        IntStream.iterate(5, (t) -> t + 5).peek((t) -> System.out.print("t:" + t + " "))
                .limit(5)
                .map((s) -> s * 1000)
                .forEach((s) -> System.out.print("s:" + s + " \n"));


        // Using a Stream<Integer> (mapToInt only available for Stream)
        System.out.println("\n\nOutput from an Stream using mapToInt");
        Stream.<Integer>iterate(5, (t) -> t + 5)
                .limit(5)
                .mapToInt((s) -> s * 1000)
                .forEach((s) -> System.out.print(s + " "));


        System.out.println("\n");
        Stream.<Integer>iterate(5, (t) -> t + 5)
                .limit(5)
                .mapToInt((s) -> s * 1000)
                .map((s) -> s / 1000)
                // .mapToInt((s) -> s * 1000) // Cannot resolve method 'mapToInt' in 'IntStream'
                .forEach((s) -> System.out.print(s + " "));


    }

    // This method has side effects, name of student changes
    private static Student changeStudent(Student p) {
        p.setName(p.getName() + " Doe");
        return p;
    }

    // A method that transforms a student to a mapped entry
    private static Map.Entry<Integer, Student> mapStudent(Student p) {
        return new AbstractMap.SimpleEntry<Integer, Student>(p.getStudentId(), p);
    }


}