import java.util.Arrays;
import java.util.stream.Collectors;

public enum DaysOfTheWeek {
    // Note that it is not required to make all constants uppercase,
    // but is considered best practice
    sunday, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

class TestDaysOfTheWeek {
    public static void main(String[] args) {

        // Retrieve the list of enum constants from
        // DaysOfTheWeek.values() static method

        for (DaysOfTheWeek day : DaysOfTheWeek.values()) {
            System.out.println(day.ordinal() + " is " + day);
        }

        // Example of using the valueOf() static method
        System.out.println(DaysOfTheWeek.valueOf("WEDNESDAY"));

        System.out.println("---------------------------------");

        System.out.println(Arrays.stream(DaysOfTheWeek.values()).map(Enum::name).collect(Collectors.joining(", ")));
        System.out.println("-----------");

        Arrays.stream(DaysOfTheWeek.values()).map(Enum::name).collect(Collectors.joining(","));

        // We can loop through the list of values..
        for (DaysOfTheWeek day : DaysOfTheWeek.values()) {
            System.out.println(day.ordinal() + " is " + day + " & name:" + day.name());
            switch (day) {
                case MONDAY:
                case TUESDAY:
                    System.out.println("Long road ahead");
                    break;
                case WEDNESDAY:
                    System.out.println("Hump day");
                    break;
                case THURSDAY:
                    System.out.println("TGIF - 1");
                    break;
                case FRIDAY:
                    System.out.println("TGIF");
                    break;
                case SATURDAY:
                case sunday:
                    System.out.println("Wonderful Weekend");
            }
        }
    }
}
