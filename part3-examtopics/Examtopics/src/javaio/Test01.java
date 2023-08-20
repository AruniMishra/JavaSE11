package javaio;

import java.io.*;
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