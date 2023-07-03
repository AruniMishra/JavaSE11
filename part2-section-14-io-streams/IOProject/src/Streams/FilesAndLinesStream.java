package Streams;

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 13:  I/O (Fundamentals and NIO2)
Topic: Files static methods reading files that return Stream
*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesAndLinesStream {
    public static void main(String[] args) {

        Path p = Paths.get("SomeData.csv");
        createTheFile(p);

        System.out.println("\n---- Reading lines from a file" +
                " with Files.readAllLines ----");

        // Opening/Closing file seamless and does not require being
        // part of try with resources.  Throws IOException
        try {
            Files.readAllLines(p).forEach(System.out::println);
        } catch (IOException io) {
            System.out.println(io);
        }

        System.out.println("\n---- Reading lines from a file" +
                " with Files.lines ----");

        // File stays open while stream is open.  This method needs to be
        // enclosed in try-with-resources or similar.  Throws IOException
        try (Stream<String> str = Files.lines(p)) {
            str
                    .forEach(System.out::println);
        } catch (IOException io) {
            System.out.println(io);
        }

        p = Paths.get("src/Streams/FilesAndLinesStream.java");
        System.out.println("\n---- Comments in " +
                "FilesAndLinesStream.java  ----");

        // File stays open while stream is open.  This method needs to be
        // enclosed in try-with-resources or similar.
        try (Stream<String> str = Files.lines(p)) {
            str
                    .map(s -> s.strip())
                    .filter((s) -> s.startsWith("//"))
                    .map(s -> s.replaceAll("//", "~"))
                    .forEach(System.out::println);
        } catch (IOException io) {
            System.out.println(io);
        }


        p = Paths.get("SomeData.csv");
        System.out.println("\n------ Using pipeline reduction (count) " +
                "on a file ----");

        long recordCount;
        // Count the lines (records) in a file
        try (Stream<String> str = Files.lines(p)) {
            recordCount = str
                    .count();

            System.out.println("records in " + p + " = " + recordCount);
        } catch (IOException io) {
            System.out.println(io);
        }


        System.out.println("\n------ Using pipeline collect (groupingBY) " +
                "on a file ----");
        try (Stream<String> str = Files.lines(p)) {
            str
                    // Collecting data into a TreeMap<String, Map<String,String>,
                    .collect(Collectors.groupingBy((s) -> s.split(",")[2],
                            TreeMap::new,
                            Collectors.toMap(
                                    // sub map is Id, Name
                                    (s) -> s.split(",")[0],
                                    (s) -> s.split(",")[1])

                    ))
                    // entrySet() is method on TreeMap
                    .entrySet()
                    // Get a stream from the entries
                    .stream()
                    // Print each element
                    .forEach(System.out::println);

        } catch (IOException io) {
            System.out.println(io);
        }
    }

    // Create a test file.
    private static void createTheFile(Path p) {

        try {
            // Delete test file if it exists
            Files.deleteIfExists(p);

            List<String> list = List.of(
                    "1,George,ABC",
                    "2,Carol,DEF",
                    "3,Mary,EFG",
                    "4,Ralph,ABC",
                    "5,Arthur,ABC",
                    "6,Maggie,DEF",
                    "7,Brandy,EFG"
            );

            // Write List<String to the file in a single line
            Files.write(p, list);

        } catch (IOException io) {
            System.out.println(io);
        }
    }
}
