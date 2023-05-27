/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 13:  I/O (Fundamentals and NIO2)
Topic: Path Manipulation methods
*/

import java.nio.file.Path;

public class PathMethods {
    public static void main(String[] args) {
        // Testing Path.normalize() method
        testNormalize();
    }

    // Normalizing a path, simplifies it.
    public static void testNormalize() {

        System.out.println("--- Results for the normalize() method ---");
        // Directory Structure shown below, -- represents a level
        // ---------------------
        // part2-section-13-io-streams
        // -- ParallelStreams
        // -- IOProject
        // -- -- out
        // -- -- -- production
        // -- -- src
        Path p = Path.of("IOProject/../ParallelStreams");
        System.out.println("Normalize transforms \n\t" + p.toString()
                + "\n to: \n\t" + p.normalize() + "\n---------------");

        p = Path.of("out/production/IOProject/../../../src/.");
        System.out.println("Normalize transforms \n\t" + p.toString()
                + "\n to: \n\t" + p.normalize() + "\n---------------");

        p = Path.of("resources//localdata//github//JavaSE11//part2-section-13-io-streams/IOProject/src/../../.");
        System.out.println("Normalize transforms \n\t" + p.toString()
                + "\n to: \n\t" + p.normalize() + "\n---------------");


        p = Path.of("a/../../../b/./../c");
        System.out.println("Normalize transforms \n\t" + p.toString()
                + "\n to: \n\t" + p.normalize() + "\n---------------");

        p = Path.of("/a/../../../b/./../c");
        System.out.println("Normalize transforms \n\t" + p.toString()
                + "\n to: \n\t" + p.normalize() + "\n---------------");


    }
}