/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 16: Localization
Topic:  Formatting Numbers
*/

import java.text.*;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class LocaleFormattingNumbers {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(new Locale("en", "IN"));

        System.out.println("----------- STANDARD FORMATS ------------");
        testNumberFormats(Locale.FRANCE);


        System.out.println("\n----------- PARSING ---------------");
        parseNumbers(Locale.FRANCE);


        System.out.println("\n----------- CUSTOM FORMATS --------------");
        testCustomNumberFormats(Locale.getDefault());
    }

    public static void testNumberFormats(Locale l) {
        double d = 10.55;

        String outpattern = "{0}({1}) : {3}  -  {0}({2}) : {4} ";

        // Using getInstance() with and without passing a Locale
        System.out.println(MessageFormat.format(outpattern,
                "getInstance.format",   // {0} - Text, method executed
                Locale.getDefault(),    // {1} - default Locale String
                l,                      // {2} - passed Locale String
                NumberFormat.getInstance().format(d), // {3} number (default Locale)
                NumberFormat.getInstance(l).format(d) // {4} number (passed Locale)
        ));

        // Using getNumberInstance() with and without passing a Locale,
        // same result as using getInstance()
        System.out.println(MessageFormat.format(outpattern,
                "getNumberInstance",
                Locale.getDefault(),
                l,
                NumberFormat.getNumberInstance().format(d),
                NumberFormat.getNumberInstance(l).format(d)
        ));

        // Using getCurrencyInstance() with and without passing a Locale
        System.out.println(MessageFormat.format(outpattern,
                "getCurrencyInstance",
                Locale.getDefault(),
                l,
                NumberFormat.getCurrencyInstance().format(d),
                NumberFormat.getCurrencyInstance(l).format(d)));

        // Using getIntegerInstance() with and without passing a Locale
        System.out.println(MessageFormat.format(outpattern,
                "getIntegerInstance",
                Locale.getDefault(),
                l,
                NumberFormat.getIntegerInstance().format(d),
                NumberFormat.getIntegerInstance(l).format(d)));

        // Using getPercentInstance() with and without passing a Locale
        System.out.println(MessageFormat.format(outpattern,
                "getPercentInstance",
                Locale.getDefault(),
                l,
                NumberFormat.getPercentInstance().format(d),
                NumberFormat.getPercentInstance(l).format(d)));

    }

    // Parsing Numbers has to be Locale specific as well
    public static void parseNumbers(Locale l) throws ParseException {
        double d = 10.55;

        // First get two String representations of the double value above
        // defaultDecimal String is the default Locale's representation
        String defaultDecimal = NumberFormat.getInstance().format(d);

        // localeDecimal String is the passed Locale's representation
        String localeDecimal = NumberFormat.getInstance(l).format(d);

        System.out.println("defaultDecimal = " + defaultDecimal);
        System.out.println("localeDecimal = " + localeDecimal);

        // Now let's use MessageFormat to print variations out
        String message = "NumberFormat.getInstance({0}).parse({1}) : {2}";

        // Parse the defaultDecimal String for the default Locale
        System.out.println(MessageFormat.format(message,
                Locale.getDefault(), // {0} - default Locale's String value
                "defaultDecimal", // {1} - specify Locale used
                NumberFormat.getInstance().parse(defaultDecimal) // {2} result
        ));

        // Parse the defaultDecimal String for the Locale passed as an arg
        System.out.println(MessageFormat.format(message,
                l,
                "defaultDecimal",
                NumberFormat.getInstance(l).parse(defaultDecimal)
        ));

        // Parse the localeDecimal String for the default Locale
        System.out.println(MessageFormat.format(message,
                Locale.getDefault(),
                "localeDecimal",
                NumberFormat.getInstance().parse(localeDecimal)
        ));

        // Parse the localeDecimal String for the Locale passed as an arg
        System.out.println(MessageFormat.format(message,
                l,
                "localeDecimal",
                NumberFormat.getInstance(l).parse(localeDecimal)
        ));

    }


    // Formatting Numbers using patterns
    public static void testCustomNumberFormats(Locale l) {
        double d = 5.5;
        /*
        If you're concerned with the current user's default locale,
        you can use the MessageFormat.format with multiple format specifiers, as shown.

        If you need to do something with a specific locale,
        you can use one of the DecimalFormats static factory methods and parse it
        a specific locale or construct DecimalFormat with a locale.
         */

        // Get a Regional DecimalFormat. apply pattern as a method
        DecimalFormat dfRegional = (DecimalFormat) NumberFormat.getInstance(l);
        dfRegional.applyPattern("###.###");

        System.out.println(MessageFormat.format("{0}({1}) : {2} ",
                "DecimalFormat(\"###.###\")", l, dfRegional.format(d)));

        // Construct DecimalFormat with a pattern
        System.out.println(MessageFormat.format("{0}({1}) : {2} ",
                "DecimalFormat(\"##.00\")", l, new DecimalFormat("##.00").format(d)));

        // Using MessageFormat format specifier with various numeric
        // options.  MessageFormat does not take a Locale, uses the default Localse

        // Prints out a number passed with no additional formatting
        System.out.println(MessageFormat.format("{0}({1}) : {2, number} ",
                "{2, number} ", l, d));

        // Prints out number passed as a percentage
        // (multiplies by 100 and shows percent character)
        System.out.println(MessageFormat.format("{0}({1}) : {2, number, percent} ",
                "{2, number, percent1}  ", l, d));

        // Prints out number passed as currency
        // with Locale specific currency character
        System.out.println(MessageFormat.format("{0}({1}) : {2, number, currency} ",
                "{2, number, currency} ", l, d));

        // Prints out number passed as an integer, rounding
        System.out.println(MessageFormat.format("{0}({1}) : {2, number, integer} ",
                "{2, number, integer} ", l, d));

        // Prints out number passed using the pattern specified, # and 0 are
        // specific pattern designators.
        // Both # and 0 limit digits on right side of decimal but 0 right-pads
        // number with 0
        System.out.println(MessageFormat.format("{0}({1}) : {2, number, #.000} ",
                "{2, number, #.000} ", l, d));

        // Prints out number passed using the pattern specified, # and 0 are
        // specific pattern designators.
        // Both # and 0 limit digits on left side of decimal but 0 left-pads number
        // with 0
        System.out.println(MessageFormat.format("{0}({1}) : {2, number, 000.##} ",
                "{2, number, 000.##} ", l, d));
    }


    // Print date information using SimpleDateFormat
    public static void printDateSimpleDateFormat(Date date) {

        System.out.println("--------- SimpleDateFormat ---------");
        DateFormat dateFormatter = new SimpleDateFormat("MM DD YY");
        // formatter.setTimeZone(TimeZone.getTimeZone("PST"));

        // MM prints month in year as 0 padded number
        // DD is day in the year, not day in the month (d)
        // YY is the year
        System.out.println(MessageFormat.format("{0}  = {1}",
                "SimpleDateFormat(\"MM DD YY\")", dateFormatter.format(date)));

        // MM prints month in year as number, 0 left-pads the number
        // dd prints day in the month as anumber, 0 left-pads the number
        // YY is the year
        dateFormatter = new SimpleDateFormat("MM dd YY");
        System.out.println(MessageFormat.format("{0}  = {1}",
                "SimpleDateFormat(\"MM dd YY\")", dateFormatter.format(date)));

        // This includes the time
        // hh prints hour, 0 left-padded
        // mm print minute in the hour, 0 left-padded
        // a represents am/pm
        // zz represents time zone
        dateFormatter = new SimpleDateFormat("MM dd YY hh:mm a zz");

        // Setting time zone.
        dateFormatter.setTimeZone(TimeZone.getTimeZone("EST"));
        System.out.println(MessageFormat.format("{0}  = {1}",
                "SimpleDateFormat(\"MM/dd/YY hh:mm zz\")", dateFormatter.format(date)));
    }


}
