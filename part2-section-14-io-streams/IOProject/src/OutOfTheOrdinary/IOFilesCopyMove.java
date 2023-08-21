package OutOfTheOrdinary;


/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 13:  I/O (Fundamentals and NIO2)
Topic: Using Files.copy
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

public class IOFilesCopyMove {

    // Use File walker to print information about Directory
    private static void printDir(Path p) throws IOException {
        System.out.println(p + " is directory? " +
                Files.isDirectory(p));
        if (Files.isDirectory(p)) {
            try (Stream<Path> str = Files.walk(p)) {
                str.forEach((s) -> System.out.println("\t\t" + s));
            }
        }
    }

    // Executes Files.copy(Path source, Path target, CopyOption... options)
    private static void copyMethod(Path source, Path target)
            throws IOException {

        // Path is returned from this Files.copy method
        Path result = null;
        try {
            // Make first attempt without options
            System.out.println("First attempt, no options");
            result = Files.copy(source, target);

        } catch (IOException io) {

            System.out.println("\tFirst attempt failed: " + io);
            System.out.println("\tSecond attempt, Use REPLACE_EXISTING");
            try {
                // Make Second attempt with REPLACE_EXISTING options
                result = Files.copy(source, target,
                        StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ioNested) {
                System.out.println("\t\tSecond attempt failed: " + ioNested);
            }
        }
        if (result != null) {
            // Print information about result
            System.out.println("\tCopy was successful: " + result +
                    " : " + (Files.isDirectory(result) ? " Directory" : "File"));
            if (Files.isDirectory(result)) printDir(result);

        }
    }

    // Tests copying file to file
    private static void testFileToFile() throws IOException {
        Path fileSource = Path.of("copiedFrom.txt");
        Path fileTarget = Path.of("copiedTo.txt");

        // Delete source file if it exists.
        Files.deleteIfExists(fileSource);
        Files.deleteIfExists(fileTarget);

        // Create source file, add a String
        Files.writeString(fileSource, "Hello");

        // First Test - copy existing source file to a
        // non-existing target file
        System.out.println("--------------------------------------");
        System.out.println("Existing File to Non-Existing File");
        System.out.println("--------------------------------------");
        copyMethod(fileSource, fileTarget);

        // Second Test - copy existing source file to an
        // existing target file
        System.out.println("\n--------------------------------------");
        System.out.println("Existing File to Existing File");
        System.out.println("--------------------------------------");
        copyMethod(fileSource, fileTarget);
    }

    // Uses Files.walk recursively to delete all elements in a directory.
    private static void deleteDir(Path p) throws IOException {

        if (Files.isDirectory(p)) {
            // Walk using only a depth of 1
            try (Stream<Path> str = Files.walk(p, 1)) {
                str
                        // remember that walk returns a reference to current path
                        // filter it out
                        .filter((s) -> !s.equals(p))
                        // Recursively execute this method.
                        .forEach((s) ->
                        {
                            try {
                                IOFilesCopyMove.deleteDir(s);
                            } catch (IOException io) {

                            }
                        });
            }
        }
        // Finally delete current element
        Files.deleteIfExists(p);
    }

    // Tests copying a File to a existing Directory
    private static void testFileToDir() throws IOException {
        Path fileSource = Path.of("copiedFrom.txt");
        Path directoryTarget = Path.of("copiedToDir");

        // Delete source file if it exists.
        Files.deleteIfExists(fileSource);
        // Create source file, add a String
        Files.writeString(fileSource, "Hello");

        // Delete target directory if it exists.
        deleteDir(directoryTarget);
        // Recreate target directory
        Files.createDirectory(directoryTarget);

        System.out.println("\n\n--------------------------------------");
        System.out.println("Existing File to Existing Empty Directory");
        System.out.println("--------------------------------------");
        // First Test - copy existing source file to a
        // existing directory
        printDir(directoryTarget);
        copyMethod(fileSource, directoryTarget); // copiedToDir is a File here.

        System.out.println("\n--------------------------------------");
        System.out.println("Existing File to Existing Non-Empty Directory");
        System.out.println("--------------------------------------");
        // Second Test - copy existing source file to a directory that
        // is not empty (has a subdirectory)
        Files.deleteIfExists(directoryTarget);
        directoryTarget = Path.of("copiedToDir/subDirectory");
        // Create a directory with a sub directory
        Files.createDirectories(directoryTarget);
        // Use the printDir method to print contents of copied directory
        printDir(directoryTarget.getParent());
        copyMethod(fileSource, directoryTarget.getParent());

    }


    // Tests copying a Directory to a existing File
    private static void testDirToFile() throws IOException {
        Path fileTarget = Path.of("copiedFrom.txt");
        Path directorySource = Path.of("copiedFromDir");

        // Delete source file if it exists.
        Files.deleteIfExists(fileTarget);
        // Create source file, add a String
        Files.writeString(fileTarget, "Hello");


        // Delete target directory if it exists.
        deleteDir(directorySource);
        // Recreate target directory
        Files.createDirectory(directorySource);

        System.out.println("\n\n--------------------------------------");
        System.out.println("Existing Empty Directory to Existing File");
        System.out.println("--------------------------------------");
        // First Test - copy existing directoy to a target that
        // is an existing file
        printDir(directorySource);
        copyMethod(directorySource, fileTarget);


        System.out.println("--------------------------------------");
        System.out.println("Existing Non-Empty Directory to Existing File");
        System.out.println("--------------------------------------");
        // Second Test -copy existing directoy to a target that
        // is an existing file, directory is not empty.
        Files.deleteIfExists(directorySource);
        directorySource = Path.of("copiedFromDir/subDirectory");
        Files.createDirectories(directorySource);
        printDir(directorySource.getParent());
        copyMethod(directorySource.getParent(), fileTarget);

    }


    // Test Files.copy(Path source, OutputStream out)
    public static void copyPathToOutputStream() throws IOException {

        Path fileSource = Path.of("copiedFrom.txt");

        // Delete source file if it exists.
        Files.deleteIfExists(fileSource);
        // Create source file, add a String
        Files.writeString(fileSource, "Hello");

        Files.deleteIfExists(Path.of("copiedTo.txt"));

        long copiedBytes = -1;

        System.out.println("--------------------------------------");
        System.out.println("Existing file to non-existing " +
                "file using OutputStream");
        System.out.println("--------------------------------------");
        // Copy to a file that doesn't exist
        // Use try-with-resources to auto close the FileOutputStream
        try (FileOutputStream fos = new FileOutputStream("copiedTo.txt")) {
            copiedBytes = Files.copy(fileSource, fos);
            System.out.println("copiedBytes = " + copiedBytes);
        }

        System.out.println("--------------------------------------");
        System.out.println("Existing file to existing " +
                "file using OutputStream");
        System.out.println("--------------------------------------");
        // Copy to a file that exists
        // Use try-with-resources to close the OutputStream
        try (FileOutputStream fos = new FileOutputStream("copiedTo.txt")) {
            copiedBytes = Files.copy(fileSource, fos);
            System.out.println("copiedBytes = " + copiedBytes);
        }


        System.out.println("--------------------------------------");
        System.out.println("Existing file to existing " +
                "file using OutputStream with append = true");
        System.out.println("--------------------------------------");
        // Copy to a file that exists
        // Use try-with-resources to close the OutputStream
        try (FileOutputStream fos = new FileOutputStream("copiedTo.txt", true)) {
            copiedBytes = Files.copy(fileSource, fos);
            System.out.println("copiedBytes = " + copiedBytes);
            Files.readAllLines(Path.of("copiedTo.txt"))
                    .forEach(System.out::println);
        }

    }

    // Test Files.copy(InputStream source, Path target, CopyOption... options)
    public static void copyInputStreamToPath() throws IOException {

        Path fileSource = Path.of("copiedFrom.txt");

        // Delete source file if it exists.
        Files.deleteIfExists(fileSource);
        // Create source file, add a String
        Files.writeString(fileSource, "Hello");

        Path fileTarget = Path.of("copiedTo.txt");

        // Delete source file if it exists.
        Files.deleteIfExists(fileTarget);

        System.out.println("--------------------------------------");
        System.out.println("Existing file to non-existing " +
                "file using InputStream ");
        System.out.println("--------------------------------------");
        // Copy to a file that does not exist
        // Use try-with-resources to close the InputStream
        try (FileInputStream fis = new FileInputStream(
                fileSource.toString())) {
            long copiedBytes = Files.copy(fis, fileTarget);
            System.out.println("copiedBytes = " + copiedBytes);
            Files.readAllLines(Path.of("copiedTo.txt"))
                    .forEach(System.out::println);
        }

        System.out.println("\n--------------------------------------");
        System.out.println("Existing file to existing file using " +
                "InputStream and no options on target Path ");
        System.out.println("--------------------------------------");
        // Copy to a file that does not exist
        // Use try-with-resources to close the InputStream
        try (FileInputStream fis = new FileInputStream(
                fileSource.toString())) {
            long copiedBytes = Files.copy(fis, fileTarget);
            System.out.println("copiedBytes = " + copiedBytes);
            Files.readAllLines(Path.of("copiedTo.txt"))
                    .forEach(System.out::println);
        } catch (IOException io) {
            System.out.println(io);

        }

        System.out.println("\n--------------------------------------");
        System.out.println("Existing file to existing file using " +
                "InputStream and REPLACE_EXISTING option on target Path ");
        System.out.println("--------------------------------------");
        // Copy to a file that does not exist
        // Use try-with-resources to close the InputStream
        try (FileInputStream fis = new FileInputStream(
                fileSource.toString())) {
            long copiedBytes = Files.copy(fis, fileTarget,
                    StandardCopyOption.REPLACE_EXISTING);
            System.out.println("copiedBytes = " + copiedBytes);
            Files.readAllLines(Path.of("copiedTo.txt"))
                    .forEach(System.out::println);
        } catch (IOException io) {
            System.out.println(io);

        }
    }


    public static void main(String[] args) throws IOException {
        testFileToFile();

        // testFileToDir();

        // testDirToFile();

        // copyPathToOutputStream();

        // copyInputStreamToPath();
    }
}

