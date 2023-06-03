/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 16:  Localization
Topic:  Resource Bundles
*/

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleResources {
    public static void main(String[] args) {

        Locale.setDefault(new Locale("en", "AU"));
        testProperties(Locale.getDefault());

        // The JVM picked the firstBundle_Fr.properties file
        // because it's the next best match.
        testProperties(Locale.CANADA_FRENCH);

        // firstBundle_en_US_slang.properties: the JVM did not match it. and picked default file
        testProperties(Locale.US);

        testProperties(Locale.GERMANY);

        testProperties(new Locale("en", "US", "slang"));

        // firstBundle_en_CA.java loaded
        testProperties(Locale.CANADA);
    }

    public static void testProperties(Locale locale) {

        System.out.println("\n\n---- Locale Passed: [" + locale + "] ---------");

        ResourceBundle localeData = ResourceBundle.getBundle("firstBundle", locale);
        System.out.println("\n\tResourceBundle class = " + localeData.getClass().getName());

        // Get the 'selected' locale
        System.out.println("\n\tLocale Actually Used:  [" + localeData.getLocale() + "]");

        // Get a single valued based on a key
        System.out.println("\n\tInternationalizing the word yes  = " +
                localeData.getString("yes") + " [" + locale + "]");

        System.out.println("\n\t---Key/Values in properties file---");

        // Iterate through keys and do something
        localeData.keySet().forEach((s) -> System.out.println("\t|" + s + " = " + localeData.getObject(s)));

    }
}


