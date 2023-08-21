/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 13:  I/O (Fundamentals and NIO2)
Topic: Path Basics
*/

import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathBasics {

    // main method simply calls a method that shows multiple ways to
    // create Path instances
    public static void main(String[] args) {
        pathCreations();

        // Show information for the current directory
        showData("");

        // Show information for a file
        showData("characterData.txt");
    }

    // Method demonstrates many ways to create Path instances
    public static void pathCreations() {

        //--- Using Path as a reference to a directory

        /*
        toAbsolutePath() method doesn't care if given path elements are physically available or not and
        hence it doesn't declare to throw IOException.
        It just returns the absolute path without any normalization.
         */

        // Path object to current working directory
        Path cwd = Paths.get("");
        System.out.println(cwd.toAbsolutePath());

        // Specifying a full path using windows forward slashes
        Path currentdir = Paths.get("\\resources\\localdata\\github\\JavaSE11\\part2-section-14-io-streams" +
                "\\IOProject");
        System.out.println(currentdir.toAbsolutePath());

        // Using Paths.get with initial path as first argument and
        // remaining path as a single String, mixing back & forward slashes
        Path cdir = Paths.get("C://resources//localdata//github//JavaSE11//part2-section-14-io-streams",
                "IOProject/out/production");
        System.out.println(cdir.toAbsolutePath());

        // Using Path.of to get a path using Strings
        Path cdir2 = Path.of("C:", "resources", "localdata", "github", "JavaSE11",
                "part2-section-14-io-streams", "IOProject",
                "out", "production");
        System.out.println(cdir2.toAbsolutePath());

        //--- Using Path as a reference to a file

        // Use Paths.get to get a file reference with a URI
        Path filePath1 = Paths.get(URI.create(
                "file:///resources//localdata//github//JavaSE11//part2-section-14-io-streams" +
                        "/IOProject/characterData.txt"));
        System.out.println(filePath1.toAbsolutePath());

        // FileSystems.getDefault() gives default file system object
        // which has a method getPath
        Path filePath2 = FileSystems.getDefault().getPath("C:",
                "resources", "localdata", "github", "JavaSE11",
                "part2-section-14-io-streams", "IOProject",
                "characterData.txt");
        System.out.println(filePath2.toAbsolutePath());
    }


    // Print Information about a Path object using path methods
    public static void showData(String pathName) {

        /*
        Given methods doesn't need actual path to physically exist and hence no exception is thrown at Runtime.
        path.getName(2);
        path.getNameCount() and
        path.getFileName()
         */

        System.out.println("---- Path data for '" + pathName + "' ----");

        // Use the Paths.get factory method to obtain a Path object
        // and use toAbsolutePath method to get info
        Path path = Paths.get(pathName).toAbsolutePath();

        // Print out absolute path
        System.out.println("Absolute Path: " + path.toString() +
                "   [toString()]");

        // Get filename, in this case, current directory
        System.out.println("FilesManagement/Dir of Path object: " +
                path.getFileName() + "   [getFileName()]");

        // Parent directory returned as a Path
        System.out.println("Parent Directory: " + path.getParent()
                + "   [getParent()]");

        // Get part of the path, using names
        System.out.println("Getting subpath: " + path.subpath(0, 2)
                + "   [subpath(0,2)]");

        // Number of sub directories in the path
        System.out.println("Number of Sub-Directories: " +
                path.getNameCount() + "   [getNameCount()]");

        // Use methods to 'draw' the directory structure
        System.out.println("Directory Structure using path.getName()");

        // Root directory returned as a path
        System.out.format("%s   [getRoot()]: %n", path.getRoot());
        for (int i = 0; i < path.getNameCount(); i++) {
            for (int j = 0; j <= i; j++) System.out.print("\t");

            // Note that getName returns a Path object
            System.out.println("---> " + path.getName(i) +
                    "   [getName(" + i + ")]");
        }

        System.out.println("Directory Structure using path iterator");
        // Alternately use the names iterator..
        int i = 0;
        for (Path name : path) {
            for (int j = 0; j <= i; j++) System.out.print("\t");
            System.out.println("---> " + name);
            i++;
        }
        System.out.println("------------------------------");
    }


}
