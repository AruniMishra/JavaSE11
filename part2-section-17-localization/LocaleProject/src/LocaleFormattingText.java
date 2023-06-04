/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 16: Localization
Topic:  Formatting
*/

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleFormattingText {
    public static void main(String[] args) {

        Date now = new Date();

        Locale.setDefault(new Locale("en", "AU"));

        Locale.setDefault(Locale.US);

        float floatValue = 10.233f;
        Locale[] locales = {new Locale("en", "AU"),
                Locale.FRANCE, Locale.US, Locale.ITALY};

        for (Locale l : locales) {
            System.out.println("\n----------- " + l + "---------------");
            Locale.setDefault(l);

            // Retrieve text using a resource bundle,
            // based on Locale.getDefault();
            String someText = ResourceBundle.getBundle("firstBundle")
                    .getString("unsure");

            // Printing using a concatenated String
            System.out.println("NOT LOCALIZED :: " + someText + " : " + floatValue
                    + ": " + now);

            // Localize each element:
            System.out.println("LOCALIZE ELEMENTS :: " + someText +
                    " : " + DecimalFormat.getInstance().format(floatValue) + " : " +
                    SimpleDateFormat.getDateInstance().format(now));

            // Printing using format, where %s is for a String variable
            // and %f is for a float
            System.out.format("LOCALIZED 1 ::  %s : %f : %tF %n",
                    someText, floatValue, now);

            // Printing using String.format with format specifiers and args
            System.out.println(String.format(
                    "LOCALIZED 2 :: %2$s : %1$.2f : %3$tA %3$tB %3$td, %3$tC",
                    floatValue, someText, now));

            // Printing using String returned from MessageFormat.format
            System.out.println(MessageFormat.format(
                    "LOCALIZED 3 :: {0} : {1} : {2}",
                    someText, floatValue, now));

            // Printing using String returned from MessageFormat.format
            // Using more specific format specifiers
            System.out.println(MessageFormat.format(
                    "LOCALIZED 4 :: {0} : {1, number, currency}" +
                            " : {2, date, short}",
                    someText, floatValue, now));
            new Date();
        }
    }
}
