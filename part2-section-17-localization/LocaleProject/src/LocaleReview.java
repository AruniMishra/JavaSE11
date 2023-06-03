/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 16:  Localization
Topic:  Use Locale class
*/

import java.util.Arrays;
import java.util.Locale;

public class LocaleReview {
    public static void main(String[] args) {

        // List of Available Locales
        System.out.println("Number of Locales: " +
                Locale.getAvailableLocales().length);

        System.out.println("------India Locales ------");
        // List only Locales with country code of "India"
        Arrays.stream(Locale.getAvailableLocales())
                .filter((s) -> s.getCountry().equals("IN"))
                .forEach((s) -> System.out.println(s + " : " +
                        s.getDisplayName()));

        System.out.println("\n\n------ Language only ------");
        // List only Locales with country code of "US"
        Arrays.stream(Locale.getAvailableLocales())
                //.filter((s) -> s.getCountry().equals("US"))
                .filter((s) -> s.getCountry().length() == 0 && s.getLanguage().length() > 0)
                .limit(7)
                .forEach((s) -> System.out.println(s + " : " +
                        s.getDisplayName()));

        System.out.println("\n\n------ Locales with variants ------");
        // List only Locales with country code of "US"
        Arrays.stream(Locale.getAvailableLocales())
                //.filter((s) -> s.getCountry().equals("US"))
                .filter((s) -> s.getVariant().length() > 0)
                .forEach((s) -> System.out.println(s + " : " +
                        s.getDisplayName() + " : " + s.getVariant()));

        System.out.println("------ Locales with extensions ------");
        // List only Locales with country code of "US"
        Arrays.stream(Locale.getAvailableLocales())
                //.filter((s) -> s.getCountry().equals("US"))
                .filter((s) -> s.getExtensionKeys().size() > 0)
                .forEach((s) -> System.out.println(s + " : " +
                        s.getDisplayName() + " : " + s.getExtensionKeys()));

        System.out.println("\n--------- Static fields for common Locales --------");

        // Locale static variables for some specific Locales.
        System.out.println("Locale.ENGLISH = " + Locale.ENGLISH);
        System.out.println("Locale.FRENCH = " + Locale.FRENCH);
        System.out.println("Locale.FRANCE = " + Locale.FRANCE);
        System.out.println("Locale.CANADA = " + Locale.CANADA);
        System.out.println("Locale.CANADA_FRENCH = " + Locale.CANADA_FRENCH);
        System.out.println("--------------------------");

        // Default Locale can be retrieved
        System.out.println("\nDefault Locale: " + Locale.getDefault());

        // User friendly Display Name can be used.
        System.out.println("DisplayName of default locale = " +
                Locale.getDefault().getDisplayName());

        // User friendly Display Name can be displayed using a different locale
        System.out.println("DisplayName of default locale for locale.FRENCH = " +
                Locale.getDefault().getDisplayName(Locale.FRENCH));
    }
}