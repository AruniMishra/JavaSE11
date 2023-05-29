package OutOfTheOrdinary;


/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 13:  I/O (Fundamentals and NIO2)
Topic: Using Scanner
*/

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ScannerExamples {
    public static void main(String[] args) throws
            FileNotFoundException, IOException {

        Path path = Paths.get("SomeData.csv");

        // Create the File if it
        createTheFile(path);

        // Create some local variables
        String line;
        String word;

        // Using a Scanner, using constructor with a Path.
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                System.out.println(line);

                // Using a scanner, constructed with a simple String.
                try (Scanner lineScanner = new Scanner(line)
                        // You can specify a different delimiter
                        .useDelimiter(",")) {
                    while (lineScanner.hasNext()) {
                        word = lineScanner.next();
                        System.out.println("\t" + word);
                    }
                }
            }
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
