public class SwitchExampleEnum {
    // Set up an enumeration of week days
    enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
        THURSDAY, FRIDAY, SATURDAY
    }

    public static void main(String[] args) {

        // Example of a Switch statement using an enum. 
        // We'll loop through the weekdays in the enum ...
        for (Day d : Day.values()) {
            switch (d) {
                case MONDAY:
                case TUESDAY:
                case WEDNESDAY:
                case THURSDAY:
                    System.out.println(d + ": Workday");
                    break;

                case FRIDAY:
                    System.out.println(d + ": TGIF");
                    break;

                case SATURDAY:
                case SUNDAY:
                    System.out.println(d + ": Weekends!");
                    break;

                default:
                    System.out.println("Midweek days are so-so.");
                    break;
            }
        }
    }

}