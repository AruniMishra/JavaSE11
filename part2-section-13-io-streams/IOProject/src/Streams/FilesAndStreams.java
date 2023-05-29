package Streams;

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 13:  I/O (Fundamentals and NIO2)
Topic: Files static methods that return Stream
*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FilesAndStreams {
    public static void main(String[] args) {

        Path src = Paths.get("src");
        System.out.println("-----------------------------------");
        System.out.println("Listing of " + src + " Directory");
        System.out.println("-----------------------------------");

        // Need to wrap in try/resources or try/catch so that directory
        // is appropriately closed.
        // listing is not recursive, and list only the entries at the first level if the entry is itself a directory
        try (Stream<Path> str = Files.list(src)) {
            str
                    .limit(10)  // Can use any stream operation
                    .forEach(System.out::println);
        } catch (IOException io) {
            System.out.println("Problem with listing " + io);
        }

        Path out = Paths.get("testA");
        System.out.println("-----------------------------------");
        System.out.println("Walk of " + out + " Directory");
        System.out.println("-----------------------------------");

        // Need to wrap in try/resources or try/catch so that directory
        // is appropriately closed
        // walking, without maxDepth, follows deepest leaf before it searches the next directory.
        try (Stream<Path> str = Files.walk(out)) {
            // try (Stream<Path> str = Files.walk(out, 2)) {
            str
                    // Only get regular files (not directories)
                    // .filter((s) -> Files.isRegularFile(s))
                    .limit(10) // Can use any stream operation, this limit the number of rows and not depth
                    .forEach(System.out::println);
        } catch (IOException io) {
            System.out.println("Problem with walk " + io);
        }


        System.out.println("\n-----------------------------------");
        System.out.println("Breadth walk of " + out + " Directory");
        System.out.println("-----------------------------------");
        implementBreadthWalk(out);


        System.out.println("\n-----------------------------------");
        System.out.println("Find results for " + src +
                " Directory, Regular files starting with 'F'");
        System.out.println("-----------------------------------");
        // Need to wrap in try/resources or try/catch so that directory
        // is appropriately closed
        int maxDepth = 5;
        try (Stream<Path> str = Files.find(src, maxDepth,
                (f, a) -> {
                    return
                            f.getFileName().
                                    toString().startsWith("F")
                                    &&
                                    a.isRegularFile();
                })
        ) {
            str
                    .limit(8)
                    .forEach(System.out::println);
        } catch (IOException io) {
            System.out.println("Problem with find " + io);
        }


        // Check files, interested in those modified in last x hours
        int hrsToCheck = 8;
        // Translate into milliseconds
        int elapsedMs = hrsToCheck * 60 * 60 * 1000;
        // Get the current time in milliseconds
        long now = System.currentTimeMillis();

        System.out.println("\n-----------------------------------");
        System.out.println("Find results for " + src + " Directory, " +
                "Regular files modified in last " + hrsToCheck + " hours");
        System.out.println("-----------------------------------");

        // Need to wrap in try/resources or try/catch so that stream
        // is appropriately closed
        try (Stream<Path> str = Files.find(src, maxDepth,
                // f below represents the Path element on the stream,
                // a below represents the BasicFileAttributes belong to f
                (f, a) -> {
                    return
                            // Check modified time to the elapsed time in ms.
                            (now - a.lastModifiedTime().toMillis())
                                    < elapsedMs
                                    &&
                                    a.isRegularFile();
                })
        ) {
            str
                    .forEach(System.out::println);

        } catch (IOException io) {
            System.out.println("Problem with find " + io);
        }


    }


    // Show example of breadth-first walk, vs depth-first.
    private static void implementBreadthWalk(Path p) {

        // List current level
        try (Stream<Path> str = Files.list(p)) {
            str
                    // Limiting so that output is easier to read
                    .limit(10)
                    .forEach(System.out::println);
        } catch (IOException io) {
            System.out.println("Problem with listing " + io);
        }
        // System.out.println("------list end------");

        // For any directories, call current method recursively
        try (Stream<Path> str = Files.walk(p, 1)) {
            str
                    // Do not want to list current path
                    .filter(s -> !s.equals(p))
                    // Find all directories at current level
                    .filter((s) -> Files.isDirectory(s))
                    // Recursively call current method
                    .forEach((s) -> FilesAndStreams.implementBreadthWalk(s));
        } catch (IOException io) {
            System.out.println("Problem with listing " + io);
        }
    }

}
