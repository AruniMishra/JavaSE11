package FilesManagement;

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 13:  I/O (Fundamentals and NIO2)
Topic: Copy, Move, Delete, and Create directories and paths.
*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FilesCopyMoveDelete {
    public static void main(String[] args) {
        Path p = Path.of("testA/testB/testC/testFile.txt");

        // Delete elements if they already exist
        doDeletions(p);

        // Create the file specified in the Path instance
        testCreationFromPathInstance(p);

        // Copy and Move tests:
        copyAndMove();
    }

    private static void testCreationFromPathInstance(Path p) {


        System.out.println("-------- Testing creations --------");
        try {
            // File will not get created if directories do not exist
            p = Path.of("testA/testB/testC/testFile.txt");
            Path createdFile = Files.createFile(p);
            System.out.println("A.  create File = " + createdFile.toAbsolutePath());
        } catch (IOException io) {
            System.out.println("A.  Unable to create File: " + io);
        }


        try {
            // The relative directory testA does not exist so this too
            // will throw exception every time
            p = Path.of("testA/testB");// invalid
            // p = Path.of("testA");// valid
            Path createdPath = Files.createDirectory(p);
            System.out.println("B.  createdPath = " + createdPath.toAbsolutePath());

        } catch (Exception io) {
            System.out.println("B.  Unable to create Directory: " + io);
        }


        try {
            // Create directories that do not exist.
            // This creates testFile.txt as a directory as well
            p = Path.of("testA/testB/testC/testFile.txt");
            Path createdPath = Files.createDirectories(p);
            System.out.println("C.  created Directories = " + createdPath.toAbsolutePath());
            System.out.println("C.  The Path created is a directory  = " + Files.isDirectory(createdPath));

            // Delete this directory (testFile.txt)
            Files.delete(createdPath);

        } catch (Exception io) {
            System.out.println("C.  Unable to create Directory: " + io);
        }


        try {
            // Create the file in testA/testB/testC which should now exist
            Path createdFile = Files.createFile(p);
            System.out.println("D.  create File = " + createdFile.toAbsolutePath());
        } catch (IOException io) {
            System.out.println("D.  Unable to create File: " + io);
        }

    }

    // Method to clean up elements created from a previous run
    private static void doDeletions(Path p) {
        System.out.println("-------- Testing deletions --------");
        // File must not exist and directory needs to exist...
        // to create the file
        try {
            // First test Files.deleteIfExists
            if (Files.deleteIfExists(p)) System.out.println("A.  " + p + " existed and was deleted");
            else System.out.println("A.  " + p + " did not exist");
        } catch (IOException io) {
            System.out.println("A.  Unable to delete File: " + io);
        }


        // Next, test Files.delete, by this point the file
        // should have been deleted previously.
        try {
            Files.delete(p);
            System.out.println("B.  " + p + " was deleted");
        } catch (IOException io) {
            System.out.println("B.  Unable to delete File: " + io);
        }


        try {
            do {
                // Loop through directory structures and delete
                // parent directories up to the current working directory
                p = p.getParent();
                if (p != null) {
                    Files.delete(p);
                    System.out.println("C.  " + p + " was deleted");
                }

            } while (p != null);

        } catch (IOException io) {
            System.out.println("C.  Unable to delete File: " + io);
        }
    }

    private static void copyAndMove() {

        System.out.println("-------- Testing copies --------");
        Path source = Path.of("testA/testB/testC");
        Path target = Path.of("testA/testB/testD");

        try {
            // Copy the testC directory and its contents
            // to testD (testD will get created)
            Path result = Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("A.  Directory copied successfully: " + source + " -> " + result);
        } catch (IOException io) {
            System.out.println("A.  Unable to copy Directory to source: " + io);
        }


        source = Path.of("testA/testB/testC/testFile.txt");
        target = Path.of("testA/testB/testD/testFile.txt");
        try {
            // Copy the file testFile.txt in directory testC
            // to directory testD, keeping the same file name
            Path result = Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("B.  File copied successfully: " + source + " -> " + result);
        } catch (IOException io) {
            System.out.println("B.  Unable to copy File to source: " + io);
        }


        source = Path.of("testA/testB/testC");
        target = Path.of("testA/testB/testE");
        try {
            // Copy the testC directory
            // to testE (testE will get created)
            Path result = Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("C.  Directory moved successfully: " + source + " -> " + result);
        } catch (IOException io) {
            System.out.println("C.  Unable to move Directory to source: " + io);
        }

        source = Path.of("testA/testB/testD/testFile.txt");
        target = Path.of("testA/testB/testE/aNewFile.txt");
        try {
            // Copy the file testFile.txt in directory testD
            // to directory testE, but assign it a different name
            Path result = Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("D.  File moved successfully: " + source + " -> " + result);
        } catch (IOException io) {
            System.out.println("D.  Unable to move File to source: " + io);
        }
    }
}
