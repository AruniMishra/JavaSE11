package javaio;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;
import java.util.stream.IntStream;

class Test01 {
    public static void main(String[] args) throws IOException {
        System.setOut(new PrintStream("C:\\Users\\aruni\\temp\\err.log"));
        try {
            System.out.println("ONE");
            System.out.println(1 / 0);
        } catch (ArithmeticException e) {
            System.err.println("TWO");
        }
    }
}

class Test10 {
    public static void main(String[] args) throws IOException {
        // var console = System.console();

        Console console;
        if ((console = System.console()) != null) {
            System.out.println("system console");
        } else {
            System.out.println("Interacting with user via standard" + " input/output streams");
        }
        console.writer().printf("Enter a number between 1 and 7: "); // Line n1
        var num = Integer.parseInt("" + (char) console.reader().read()); // Line n2
        var flag = IntStream.rangeClosed(1, 7).anyMatch(i -> i == num);
        if (flag) console.printf("*".repeat(num)); // Line n3
        else console.writer().format("INVALID"); // Line n4
    }
}

class Test12 {
    public static void main(String[] args) {
        var dirs = new File("C:\\A\\B\\C");
        System.out.println(dirs.mkdirs());
        var dir = new File("C:\\A");
        System.out.println(dir.mkdir());
        System.out.println(dir.delete()); // returns false as C:\A is not empty directory, it contains directory 'B'.
    }
}

class Test20 {
    public static void main(String[] args) throws IOException {
        /*
        br.read() reads a single character, so it reads user input as '2' and not 2.
        ASCII code for character '2' is not 2. In fact, it is 50.

        you should know that read() method returns single character (16-bit: 0 to 65535)
        but as return type is int hence it returns the ASCII value in this case.
         */
        try (var br = new BufferedReader(new InputStreamReader(System.in));) {
            System.out.print("Enter any number between 1 and 10: ");
            var num = br.read();
            System.out.println(num);
        }
    }
}

class Test23 {
    public static void main(String[] args) {
        try (var pw = new PrintWriter("C:\\A\\test.txt")) {
            pw.close();

            /*
            public methods of PrintWriter don't throw IOException.
            In case of IOException, internal flag variable, 'trouble' is set to true.
             */
            pw.write(1);
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
}


class Test40 {
    public static void main(String[] args) {
        var file = Paths.get("F:\\A\\.\\B\\C\\D\\..\\Book.java");
        try {
            System.out.println(file.toRealPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Test44 {
    public static void main(String[] args) {
        var file1 = Paths.get("F:\\A\\B\\C");
        var file2 = Paths.get("Book.java");
        System.out.println(file1.resolve(file2));
        System.out.println(file1.resolveSibling(file2));
    }
}

class Test54 {
    public static void main(String[] args) {
        var file1 = new File("F:\\A\\B\\D\\..\\C\\Book.java");// without normalizing the path objects
        var file2 = new File("F:\\A\\B\\.\\.\\C\\Book.java");
        System.out.println(file1 + " & " + file2);
        System.out.println(file1.toPath().equals(file2.toPath())); // false
    }
}

class Test55 {
    public static void main(String[] args) {
        var path1 = Paths.get("F:\\A\\B\\C");
        var path2 = Paths.get("F:\\A");
        System.out.println(path1.relativize(path2));
        System.out.println(path2.relativize(path1));
    }
}


class Test59 {
    public static void main(String[] args) {
        /*
        ".." represents parent directory in Windows/Linux environment.
        If a ".." is preceded by a non-".." name, then both names are considered redundant.
         */


        /*
        In the given case, First ".." is preceded by "A" and
        second ".." is preceded by B, therefore, these are removed and path.normalize() returns 'Path[""]',
        which represents an empty path.
         */
        var path = Paths.get("A", "..", "B", "..").normalize();
        System.out.println(path);
        System.out.println(path.getNameCount()); // For the empty path, `path.getNameCount()` returns 1
        System.out.println(path.getName(0).toString().length()); // 0



        /*
        Again, ".." is preceded by a non-".." name, but "F:" represents root,
        therefore only ".." is removed, it returns 'Path["F:\\.."]'.
         */
        var path1 = Paths.get("F:", "..", ".", "..").normalize();
        System.out.println(path1);
    }
}


class Test69 {
    public static void main(String[] args) throws IOException {
        var src = Paths.get("C:\\A\\B\\C\\test.txt");
        var tgt = Paths.get("C:\\A\\C");
        Files.copy(src, tgt);
    }
}

class Test71 {
    public static void main(String[] args) {
        try {
            new File("C:\\A\\t1.txt"); // Line n1
            new FileWriter("C:\\A\\t2.txt"); // Line n2
            new PrintWriter("C:\\A\\t3.txt"); // Line n3
            new BufferedWriter(new FileWriter(new File("C:\\A\\t4.txt"))); // Line n4
            Files.newBufferedWriter(Paths.get("C:", "A", "t5.txt")); // Line n5
            Files.newBufferedWriter(Paths.get("C:", "A", "t6.txt"), StandardOpenOption.CREATE); // Line n6
            Files.newBufferedWriter(Paths.get("C:", "A", "t7.txt"), StandardOpenOption.CREATE_NEW); // Line n7
            Files.newBufferedWriter(Paths.get("C:", "A", "t8.txt"), StandardOpenOption.WRITE); // Line n8
        } catch (Exception e) {

            System.out.println(e);
        }

        System.out.println(new File("C:\\A").listFiles().length);
    }
}


class Test75 {

    /*
        F:.
        └───Parent
            │   a.txt
            │   b.txt
            │
            └───Child
                    c.txt
                    d.txt
     */
    public static void main(String[] args) throws IOException {
        var root = Paths.get("C:\\A");
        /*
        Even though endsWith(String) accepts String but it should evaluate to pathname,
        such as "Child" OR "a.txt" but not just a part of pathname, such as "txt".

        NOTE: If you want to find the files ending with "txt" then use
        'p.toString().endsWith("txt")' in the lambda expression.
         */
        BiPredicate<Path, BasicFileAttributes> predicate = (p, a) -> p.endsWith("t2.txt");
        try (var paths = Files.find(root, 2, predicate)) {
            paths.forEach(System.out::println);
        }

        System.out.println("-----------");

        BiPredicate<Path, BasicFileAttributes> predicate1 = (p, a) -> p.toString().endsWith("txt");
        try (var paths = Files.find(root, 2, predicate1)) {
            paths.forEach(System.out::println);
        }

    }
}


class Test78 {
    public static void main(String[] args) throws IOException {
        /*INSERT*/

        Files.readAllLines(Paths.get("C:\\A\\t2.txt")).forEach(System.out::println);

        Files
                .lines(Paths.get("C:\\A\\t2.txt"))
                .forEach(System.out::println);
    }
}