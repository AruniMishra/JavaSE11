
/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 3: Exception Handling and Assertions
Topic:  try-with-resources
Sub-topic:  Suppressed Exceptions
*/

public class SeasonTest {

    public static void main(String[] args) {
        // First try-with-resources statement (basic)
        try (Season s = new Season(1)) {
            for (int i = 0; i < 2; i++) {
                // Nested try-with-resources statement
                // Extended - includes catch clause
                try (s;  // Passing the variable s for Season
                     Season.Episode e = s.new Episode(i + 1)) {
                    e.run();
                } catch (Exception ex) {
                    // This will print exception along with suppressed
                    // exception information
                    ex.printStackTrace(System.out);
                }
            }
        }
    }
}