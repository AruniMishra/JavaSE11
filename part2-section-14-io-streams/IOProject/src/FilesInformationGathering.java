/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 13:  I/O (Fundamentals and NIO2)
Topic: Using Files class to learn about a path or directory
*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class FilesInformationGathering {
    public static void main(String[] args) {

        // Create a path to a file in current working directory;
        Path testFile = Path.of("TestingFile.txt");

        // Execute tests for existence on the file
        System.out.println("FilesManagement " + testFile + " exists? " +
                Files.exists(testFile));
        System.out.println("FilesManagement " + testFile + " does not exist? " +
                Files.notExists(testFile));

        // Create a path to a relative directory that should exist
        Path outPath = Path.of("out//production");

        // Execute tests for existence on the path
        System.out.println("Path " + outPath + " exists? " +
                Files.exists(outPath));
        System.out.println("Path " + outPath + " does not exist? " +
                Files.notExists(outPath));


        // Gather information about a file
        getInformation(testFile);

        // Gather information about a directory
        getInformation(outPath);

    }


    // Uses Files methods to test information about a Path instance
    private static void getInformation(Path p) {
        System.out.println("\n\n--- Information for " + p + "---");

        // Is element represented by Path a regular file
        // (not a directory, opaque content)
        System.out.println("Files.isRegularFile(p) = "
                + Files.isRegularFile(p));

        // Is element represented by Path a directory?
        System.out.println("Files.isDirectory(p) = "
                + Files.isDirectory(p));

        // Is element represented by Path  readable?
        System.out.println("Files.isReadable(p) = "
                + Files.isReadable(p));

        // Is element represented by Path  executable?
        System.out.println("Files.isExecutable(p) = "
                + Files.isExecutable(p));

        // Is element represented by Path writable?
        System.out.println("Files.isWritable(p) = "
                + Files.isWritable(p));

        // Is element represented by Path a symbolic link?
        System.out.println("Files.isSymbolicLink(p) = "
                + Files.isSymbolicLink(p));

        try {

            // get File size in bytes
            System.out.println("Files.size(p) = "
                    + Files.size(p) + " bytes");

            // Get last modified date (FileTime object)
            System.out.println("Files.getLastModifiedTime(p) = " +
                    Files.getLastModifiedTime(p));

            // Get attribute (lastAccessTime) from item, returns FileTime
            // lastAccessTime may or not be supported by OS File System
            LocalDateTime ldt = LocalDateTime.ofInstant(
                    ((FileTime) Files.getAttribute(p, "lastAccessTime"))
                            .toInstant(),
                    ZoneId.systemDefault());

            // Format date returned using custom pattern
            System.out.println("Files.getAttribute(p, \"lastAccessTime\") = "
                    + ldt.format(DateTimeFormatter
                    .ofPattern("y-MM-dd:hh:mm:ss a")));

        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
