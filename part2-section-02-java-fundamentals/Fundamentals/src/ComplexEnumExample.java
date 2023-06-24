/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 2: Java Fundamentals
Topic : Enum Type
*/

enum WeekDays {
    // The values after the constants enclosed in parentheses are
    // the values used in the constructor(s)
    SUNDAY("Sun", "Wonderful Weekend"),
    MONDAY("Mon", "Long road ahead"),
    TUESDAY("Tues", "Long road ahead"),
    WEDNESDAY("Wed", "Hump day"),
    THURSDAY("Thurs", "TGIF - 1"),
    FRIDAY("Fri"),   // All constants need not execute same constructor
    SATURDAY("Sat", "Wonderful Weekend");  // Semi-colon required!

    // You can define fields on an enum
    String abbreviation;
    String description = "TGIF";


    // You can define zero to many constructors on an enum
    WeekDays(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    WeekDays(String abbreviation, String description) {
        this.abbreviation = abbreviation;
        this.description = description;
    }

    public String printType() {
        // Each enum gets a copy of this method, so each
        // enum constant instance can be referred to as this.
        if (this == SATURDAY || this == SUNDAY) return "Weekend";
        return "Weekday";
    }

}

public class ComplexEnumExample {
    public static void main(String[] args) {

        // Loop through the list of values..
        // Loop through the list of values..
        for (WeekDays day : WeekDays.values()) {
            // You can access enum attributes from enum value
            System.out.println(day.ordinal() + " is " + day.abbreviation +
                    " (" + day.printType() + "): " + day.description);
        }

        // You can execute a method on the enum through a reference
        // to one of the constants...
        System.out.println(WeekDays.SATURDAY + " is a " +
                WeekDays.SATURDAY.printType());

        System.out.println(WeekDays.SUNDAY.ordinal());

        System.out.println(WeekDays.valueOf("SUNDAY").ordinal());
        // System.out.println(WeekDays.values(0));// invalid

    }
}