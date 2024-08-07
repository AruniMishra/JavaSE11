/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 16: Localization
Topic:  Formatting Date Time
*/

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class LocaleFormattingDateTime {

    public static void main(String[] args) {
        Locale.setDefault(new Locale("en", "AU"));
        // Locale.setDefault(Locale.FRANCE);

        // Create a date representing current date/time
        Date date = new Date();
        System.out.println("Date.toString() = " + date);

        // Use method to print date/time in different ways
        printDateMessageFormat(date);

        printDateSimpleDateFormat(date);

        creatingDateTimeVariables(date);
    }

    // MessageFormat uses the default Locale
    public static void printDateMessageFormat(Date date) {

        // usage of MessageFormat.format()
        String[] names = {"Joe", "Jane"}; // Object[] valid too
        String message = MessageFormat.format("{0} {1}", names);
        System.out.println(message);

        Object[] names1 = {"Joe", "Jane"};
        String message1 = MessageFormat.format("{0} {1}", "Joe1", "Jane1");
        System.out.println(message1);


        System.out.println("\n----- Using Date Patterns ---------");

        // Printing this way prints the short representation of a date
        System.out.println(MessageFormat.format(
                "{0}  = {1, date}",
                "--1, date1--", date));

        // Printing this way prints the short representation of a date,
        // same as above but making it clear that this is short
        System.out.println(MessageFormat.format(
                "{0}  = {1, date, short}",
                "1, date, short", date));

        // Printing this way prints the medium representation of a date
        System.out.println(MessageFormat.format("{0}  = " +
                "{1, date, medium}", "1, date, medium", date));

        // Printing this way prints the long representation of a date
        System.out.println(MessageFormat.format("{0}  =" +
                " {1, date, long}", "1, date, long", date));

        // Printing this way prints the full representation of a date
        System.out.println(MessageFormat.format("{0}  =" +
                " {1, date, full}", "1, date, full", date));

        // Using patterns with date
        System.out.println(MessageFormat.format("{0}  = " +
                        "{1, date, yyy-MMM-ddd}",
                "1, date, yyy-MMM-ddd", date));

        System.out.println(MessageFormat.format("{0}  = " +
                        "{1, date, MMM d, y}",
                "1, date, MMM d y", date));

        System.out.println(MessageFormat.format("{0}  = " +
                        "{1, date, (EE) - 'Day' u 'of week' W MMMM }",
                "1, date, (EE) - 'Day' u 'of week' W MMMM", date));

        // Using patterns with time
        System.out.println("\n----- Using Time Patterns ---------");

        // Printing this way prints the short representation of time
        System.out.println(MessageFormat.format("{0}  = " +
                "{1, time}", "1, time", date));

        // Printing this way prints the short representation of time,
        // but is more clear that it is doing so...
        System.out.println(MessageFormat.format("{0}  = " +
                "{1, time, short}", "1, time, short", date));

        // Printing this way prints the medium representation of time
        System.out.println(MessageFormat.format("{0}  = " +
                "{1, time, medium}", "1, time, medium", date));

        // Printing this way prints the long representation of time
        System.out.println(MessageFormat.format("{0}  = " +
                "{1, time, long}", "1, time, long", date));

        // Printing this way prints the full representation of time
        System.out.println(MessageFormat.format("{0}  = " +
                "{1, time, full}", "1, time, full", date));

        // Printing this way prints the time using a specified pattern
        System.out.println(MessageFormat.format("{0}  = " +
                "{1, time, h:mm a}", "1, time, h:mm a", date));
    }


    // Print date information using SimpleDateFormat
    public static void printDateSimpleDateFormat(Date date) {
        System.out.println("\n\n-----------------------------------");
        System.out.println("-------- SimpleDateFormat ---------");
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

        dateFormatter = new SimpleDateFormat("MM dd yy");
        System.out.println(MessageFormat.format("{0}  = {1}",
                "SimpleDateFormat(\"MM dd yy\")", dateFormatter.format(date)));

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


        // 1. First create a sample LocalDateTime
        LocalDateTime specificDateTime =
                LocalDateTime.of(2020, 9, 17, 1, 53, 23, 000);

        // LocalDateTime to Date
        // Date.from(specificDateTime.toInstant(ZoneOffset.UTC));

        dateFormatter = new SimpleDateFormat("YYYY-MM-dd'T'HH:MM:ss.SSS'Z'");
        dateFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        System.out.println(MessageFormat.format("{0}  = {1}",
                "SimpleDateFormat(\"YYYY-MM-dd'T'HH:MM:ss.SSS'Z'\")", dateFormatter.format(Date.from(specificDateTime.toInstant(ZoneOffset.UTC)))));



        /*
        DateTimeFormatter is generally a better choice than SimpleDateFormat for formatting dates and times in Java.
        It is more thread-safe, more flexible, and based on the newer and recommended java.time API.
         */
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("YYYY-MM-dd'T'HH:MM:ss.SSS'Z'").
                withZone(ZoneId.of("UTC"));
        System.out.println(sdf.format(specificDateTime));


    }

    // Using LocalDateTime.of, LocalDate.of and LocalTime.of to create
    // Date/Time variables
    public static void creatingDateTimeVariables(Date date) {
        System.out.println("\n\n-----------------------------------");
        System.out.println("--------- DateTimeFormatter ---------");

        // Creating a date & time variable down to the nanosecond
        // This is the most specific use of LocalDateTime.of
        // Year, Month, Day of Month, Hour, Minute, Second, NanoSecond
        LocalDateTime specificDateTime =
                LocalDateTime.of(2020, 9, 17, 1, 53, 23, 55);

        // Creating a date & time variable using the Least Specific way
        // Year, Month, Day, Hour, Minute
        specificDateTime =
                LocalDateTime.of(2020, Month.SEPTEMBER, 17, 10, 30);

        // Create just a LocalDate variable instance...
        LocalDate specificDate = LocalDate.of(2020, 9, 17);

        // Alternately, for a date, you can specify day of the year
        specificDate = LocalDate.ofYearDay(2025, 182);

        // Creating just LocalTime variable instance:
        // Most Specific - Hour, Minutes, Seconds, Nanoseconds
        LocalTime specificTime = LocalTime.of(12, 30, 0, 0);

        // Least Specific - Hour, Minutes
        specificTime = LocalTime.of(12, 30);

        // Use FormatStyle from the FormatStyle.Enum
        DateTimeFormatter dformatter =
                DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println("DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT): " +
                dformatter.format(specificDate));

        // Create a patterned formatter and specify a different locale
        dformatter =
                DateTimeFormatter.ofPattern("yyy-MMM-dd", Locale.US);

        // Print LocalDate using the Locale specific formatter
        System.out.println("specificDate::DateTimeFormatter.ofPattern(\"yyy-MMM-dd\", Locale.US): " +
                dformatter.format(specificDate));

        // Print LocalTime using the Locale specific formatter
        System.out.println("specificDateTime::DateTimeFormatter.ofPattern(\"yyy-MMM-dd\", Locale.US): " +
                dformatter.format(specificDateTime));


        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("MM/'Week' w YYYY");
        System.out.println(sdf.format(LocalDate.now())); // 04/Week 17 2024

        // Print LocalTimeDate using predefined formatter, static attribute
        // on DateTimeFormatter.ISO_WEEK_DATE
        System.out.println(specificDateTime.format(DateTimeFormatter.ISO_WEEK_DATE)); // 2020-W38-4

        // Create a patterned formatter using default Locale and print time
        dformatter = DateTimeFormatter.ofPattern("hh:mm:ss:nn a");
        System.out.println("\n---DateTimeFormatter.ofPattern(\"hh:mm:ss:nn a\")---");
        System.out.println(dformatter.format(LocalTime.of(12, 30)));
        System.out.println(dformatter.format(LocalTime.of(0, 30)));
        System.out.println(dformatter.format(specificDateTime));

        // Print LocalTimeDate using predefined formatter, static attribute
        // on DateTimeFormatter.ISO_LOCAL_DATE_TIME
        dformatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        System.out.println(dformatter.format(specificDateTime));

        // Print LocalTimeDate using predefined formatter, static attribute
        // on DateTimeFormatter.ISO_LOCAL_DATE
        dformatter = DateTimeFormatter.ISO_LOCAL_DATE;
        System.out.println(dformatter.format(specificDateTime));
    }
}

