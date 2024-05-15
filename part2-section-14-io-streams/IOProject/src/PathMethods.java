/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 13:  I/O (Fundamentals and NIO2)
Topic: Path Manipulation methods
*/

import java.io.IOException;
import java.nio.file.Path;

public class PathMethods {
    /*
    1. firstly, ".." two dots is a back reference to the parent directory;

    2. a "." single dot is a reference to the current directory;

    3. a path that starts with a slash is absolute, it is a directory starting at the root;

    4. a path that does not start with a slash is relative,
    so assume any amount of two dots are available unless otherwise specified in an exam question.
     */
    public static void main(String[] args) {
        // Testing Path.normalize() method
        testNormalize();


        // Testing Path.relativize(Path other) method
        testRelativize();


        // Testing  Path.resolve(Path other) method & Path.resolve(String other)
        testResolve();


        // Testing  Path.resolveSibling(Path other) method
        //          Path.resolveSibling(String other)
        testResolveSibling();


        // Test other methods on Path
        testTheRest();

    }

    // Normalizing a path, simplifies it.
    public static void testNormalize() {

        System.out.println("--- Results for the normalize() method ---");
        // Directory Structure shown below, -- represents a level
        // ---------------------
        // part2-section-14-io-streams
        // -- ParallelStreams
        // -- IOProject
        // -- -- out
        // -- -- -- production
        // -- -- -- -- IOProject
        // -- -- src
        Path p = Path.of("IOProject/../ParallelStreams");
        System.out.println("Normalize transforms \n\t" + p.toString()
                + "\n to: \n\t" + p.normalize() + "\n---------------");

        p = Path.of("out/production/IOProject/../../../src/.");
        System.out.println("Normalize transforms \n\t" + p.toString()
                + "\n to: \n\t" + p.normalize() + "\n---------------");

        p = Path.of("resources//localdata//github//JavaSE11//part2-section-14-io-streams/IOProject/src/../../.");
        System.out.println("Normalize transforms \n\t" + p.toString()
                + "\n to: \n\t" + p.normalize() + "\n---------------");


        p = Path.of("a/../../../b/./../c");
        System.out.println("Normalize transforms \n\t" + p.toString()
                + "\n to: \n\t" + p.normalize() + "\n---------------");

        // this one starts a root
        p = Path.of("/a/../../../b/./../c");
        System.out.println("Normalize transforms \n\t" + p.toString()
                + "\n to: \n\t" + p.normalize() + "\n---------------");

        // this one starts a root
        p = Path.of("/a/../../../b");
        System.out.println("Normalize transforms \n\t" + p.toString()
                + "\n to: \n\t" + p.normalize() + "\n---------------");

        // this one starts a root
        p = Path.of("/a/..");
        System.out.println("Normalize transforms \n\t" + p.toString()
                + "\n to: \n\t" + p.normalize() + "\n---------------");


    }


    // Testing the relativize method, accepts another Path as argument
    public static void testRelativize() {
        System.out.println("\n\n\n--- Results for the p1.relativize(p2) method ---");

        // Set up test data
        Path p01 = Path.of("a");
        String p2String = "b";
        Path p02 = Path.of(p2String);

        System.out.println("relativize transforms \n\t"
                + p01.toString() + "\n\t" + p02.toString()
                + "\n to: \n\t" + p01.relativize(p02) +
                "\n---------------");

        Path p1 = Path.of("part2-section-14-io-streams/IOProject/out/production");
        Path p2 = Path.of("part2-section-14-io-streams/ParallelStreams");
        // Relativize p1.relativize(p2)
        pathRelativize(p1, p2);
        // Relativize p2.relativize(p1)
        pathRelativize(p2, p1);


        p1 = Path.of("garden/fruit/apple");
        p2 = Path.of("pear");
        // Relativize p1.relativize(p2)
        pathRelativize(p1, p2);
        // Relativize p2.relativize(p1)
        pathRelativize(p2, p1);


        p1 = Path.of("/a/b");
        p2 = Path.of("/c/d");
        try {
            pathRelativize(p1, p2);
        } catch (IllegalArgumentException ise) {
            System.out.println(ise);
        }
        try {
            // Relativize p2.relativize(p1)
            pathRelativize(p2, p1);
        } catch (IllegalArgumentException ise) {
            System.out.println(ise);
        }


        /*
        For 'path1.relativize(path2)' both path1 and path2 should be of same type.
        Both should either be relative or absolute.
        & IllegalArgumentException : if roots are different

        both attempts to use an absolute path
        either as the path invoking the method or the path passed as an argument
        throws an IllegalArgumentException
         */

        p1 = Path.of("/a/b");
        p2 = Path.of("a/b");
        try {
            pathRelativize(p1, p2);
        } catch (IllegalArgumentException ise) {
            System.out.println(ise);
        }
        try {
            // Relativize p2.relativize(p1)
            pathRelativize(p2, p1);
        } catch (IllegalArgumentException ise) {
            System.out.println(ise);
        }



    }

    private static void pathRelativize(Path p1, Path p2) {
        // Relativize p1.relativize(p2)
        System.out.println("Relativize transforms \n\t" +
                p1.toString() + "\n\t" + p2.toString()
                + "\n to: \n\t" + p1.relativize(p2) +
                "\n---------------");
    }


    // Testing resolve method which accepts a Path or String as argument
    public static void testResolve() {

        System.out.println("\n\n--- Results for the p1.resolve(p2) method ---");

        // Set up test data
        Path p01 = Path.of("a");
        String p02String = "b";
        Path p02 = Path.of(p02String);

        // If Path argument (other) is absolute, method returns passed arg
        System.out.println("resolve transforms \n\t"
                + p01.toString() + "\n\t" + p02.toString()
                + "\n to: \n\t" + p01.resolve(p02) +
                "\n---------------");


        // Set up test data
        Path p1 = Path.of("IOProject");
        String p2String = "/part2-section-14-io-streams";
        Path p2 = Path.of(p2String);


        // If Path argument (other) is absolute, method returns passed arg
        System.out.println("resolve transforms \n\t"
                + p1.toString() + "\n\t" + p2.toString()
                + "\n to: \n\t" + p1.resolve(p2) +
                "\n---------------");

        // If Path argument (other) does not have root component,
        // joins the given path to this path
        System.out.println("resolve transforms \n\t"
                + p2.toString() + "\n\t" + p1.toString()
                + "\n to: \n\t" + p2.resolve(p1) +
                "\n---------------");

        // If Path argument (other) is empty path, method returns self reference.
        // Note that resolve accepts a String or Path, for other path
        p2String = "";
        System.out.println("resolve transforms \n\t"
                + p1.toString() + "\n\tempty Path/String"
                + "\n to: \n\t" + p1.resolve(p2String) +
                "\n---------------");

        // Two relative paths..
        p2String = "out/production";
        System.out.println("resolve transforms \n\t"
                + p1.toString() + "\n\t" + p2String
                + "\n to: \n\t" + p1.resolve(p2String) +
                "\n---------------");
    }


    // Testing resolveSibling method, accepts Path or String as arg
    public static void testResolveSibling() {

        /*
        file1.resolveSibling(file2) resolves file2 against parent path of file1.
         */
        /*
         return (parent == null) ? other : parent.resolve(other);
         */

        System.out.println(
                "\n\n--- Results for the p1.resolveSibling(p2) method ---");

        Path p1 = Path.of("IOProject/src");
        System.out.println("Parent  \"IOProject/src\"= " + p1.getParent());

        String p2String = "/LearningAcademyOrg";
        Path p2 = Path.of(p2String);


        // If Path argument (other) is absolute, method returns passed arg
        System.out.println("resolveSibling transforms \n\t"
                + p1.toString() + "\n\t" + p2.toString()
                + "\n to: \n\t" + p1.resolveSibling(p2) +
                "\n---------------");

        // If Path argument (other) does not have root component,
        // joins the given path to the parent's path
        p2 = Path.of("/LearningAcademyOrg/IOProject1");
        System.out.println("Parent of Path.of(\"/LearningAcademyOrg/IOProject1\") = " + p2.getParent());
        System.out.println("resolveSibling transforms \n\t"
                + p2.toString() + "\n\t" + p1.toString()
                + "\n to: \n\t" + p2.resolveSibling(p1) +
                "\n---------------");

        // If Path argument (other) is empty path, method returns
        // parent's path
        p2String = "";
        System.out.println("resolveSibling transforms \n\t"
                + p1.toString() + "\n\tempty Path/String"
                + "\n to: \n\t" + p1.resolveSibling(p2String) +
                "\n---------------!");

        // Two relative paths..
        p2String = "out/production";
        System.out.println("resolveSibling transforms \n\t"
                + p1.toString() + "\n\t" + p2String
                + "\n to: \n\t" + p1.resolveSibling(p2String) +
                "\n---------------!");

        // Two relative path, parent of current Path is null.
        p1 = Path.of("fruit");
        System.out.println("Parent of Path.of(\"fruit\") = " + p1.getParent());
        p2String = "fruit/apple";
        System.out.println("resolveSibling transforms \n\t"
                + p1.toString() + "\n\t" + p2String
                + "\n to: \n\t" + p1.resolveSibling(p2String) +
                "\n---------------");
    }

    // Test other methods on Path
    public static void testTheRest() {

        System.out.println("\n\n--- testTheRest ---");

        Path p1 = Path.of("LearningAcademy/IOProject/out/production");
        Path p2 = Path.of("LearningAcademy/IOProject/src");
        Path p3 = Path.of("src");

        // Using startsWith method, passing String
        System.out.println(
                "p1.startsWith(\"LearningAcademy\") = " +
                        p1.startsWith("LearningAcademy"));

        // Using endsWith method, passing String
        System.out.println(
                "p1.endsWith(\"production\") = " +
                        p1.endsWith("production"));

        // Using endsWith method, passing Path
        System.out.println(
                "p2.endsWith(\"" + p3.toString() + "\") = " +
                        p2.endsWith(p3));

        // Using compareTo method, passing Path
        System.out.println(
                "p1.compareTo(p2) = " +
                        p1.compareTo(p2));

        // Using compareTo method, passing Path
        System.out.println(
                "p1.compareTo(p2) = " +
                        p1.compareTo(p2));

        // Getting Real path of a relative path may throw
        // NoSuchFileException
        try {
            System.out.println(
                    "p1." +
                            "toRealPath() = " +
                            p1.toRealPath());
        } catch (IOException io) {
            System.out.println(io);
        }

        // Getting Real path of current working directory:
        try {
            System.out.println(
                    "p1.toRealPath() = " +
                            Path.of("").toRealPath());
        } catch (IOException io) {
            System.out.println(io);
        }

        // Getting Real path of a file on relative path
        try {
            System.out.println(
                    "p1.toRealPath() = " +
                            Path.of("../IOProject/characterData.txt")
                                    .toRealPath());
        } catch (IOException io) {
            System.out.println(io);
        }
    }


}