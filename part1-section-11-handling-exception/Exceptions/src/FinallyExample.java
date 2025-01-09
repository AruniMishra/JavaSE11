/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 11: Handling Exception
Topic:  Describe Exception Handling and types of exceptions
Sub-Topic:  Try/Catch/Finally
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FinallyExample {
    public static void main(String[] args) {
        FinallyExample fex = new FinallyExample();
        try {
            System.out.println("Outer try block starts here....");
            String property = fex.getPropertyFromFile("FinallyProperties.txt");
        } catch (IOException | ArrayIndexOutOfBoundsException io) {
            /*
            The exception parameter in a multi-catch clause is implicitly final. Thus, it cannot be reassigned.
            Had there been only one exception in the catch clause (of type that is compatible with FileNotFoundException
             such as IOException or Exception, but not RuntimeException), it would have been valid.
             */
            // io =  new FileNotFoundException();
            System.out.println("Outer catch exception block starts here....");
            try {
                // Retry;
                System.out.println("Inner try block attempts retry....");
                String line = fex.getPropertyFromFile("AnotherProperties.txt");

            } catch (IOException e) {
                System.out.println("Inner catch exception block starts here....");
            }
        }
    }

    private String getPropertyFromFile(String filename) throws IOException {

        String property;
        BufferedReader br = new BufferedReader(new FileReader(filename));
        try {
            String line = br.readLine();
            property = line.split("\\s")[1];
            System.out.println("Property value = " + property);
        } finally {

            if (br != null) br.close();
        }
        return property;
    }
}