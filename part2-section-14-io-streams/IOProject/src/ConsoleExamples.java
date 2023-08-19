/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 13:  I/O (Fundamentals and NIO2)
Topic: Read data from and write console
*/

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

public class ConsoleExamples {
    public static void main(String[] args) throws IOException {

        Console console;

        LocalDateTime currentDate = LocalDateTime.now();

        // Represents name typed in by user.
        String name;

        /*
        java -classpath "C:\\resources\\localdata\\github\\JavaSE11\\out\\production\\part2-section-14-io-streams" ConsoleExamples
         */
        // console may be null, for example within the IntelliJ IDE
        if ((console = System.console()) != null) {

            // Console supports a simple printf statement
            console.printf("Interacting with user via Console\n");

            // Console reads a line of text, terminated by the enter key
            // name = console.readLine("What is your name? ");


            console.printf("Enter your name:\n");
            // Good practice to flush the buffer before getting input
            console.flush();


            // Alternate way of reading data by a single line
            BufferedReader reader = new BufferedReader(console.reader());
            name = reader.readLine();

            // clear the buffer
            console.flush();
            // Retrieve user's password
            console.readPassword("Enter Password, please, %1s: ", name);

            // Alternate of printf, use the console.writer().println
            console.writer().println("Your input is appreciated, " + name);
            console.format("The local date and time is:" +
                    " %1$tF %1$tr", currentDate);

        } else {
            // Getting the same data using standard in and out
            System.out.println("Interacting with user via standard" +
                    " input/output streams");
            System.out.println("What is your name? ");

            // Read in text using carriage return with BufferedReader
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            name = reader.readLine();

            // Output the name user typed in
            System.out.println("Your input is appreciated, " + name);
            System.out.println(String.format("The local date and time is:" +
                    " %1$tF %1$tr", currentDate));
        }
    }
}
