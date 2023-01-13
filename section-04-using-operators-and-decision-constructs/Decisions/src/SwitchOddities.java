
public class SwitchOddities {
    public static void main(String[] args) {
        byte[] bytes = {100, 103, 104, 107, 126};
        String caseAssignedValue = "";

        // Create a label to use in switch statement
        start_for:
        for (var i : bytes) {   // Using LVTI here
            switch (i) {
                case 100:
                case 103:
                case 104:
                    // This is case block break
                    break;
                case 107:
                    caseAssignedValue = "Less than 110";
                    System.out.println("107");
                    // This is a for loop break with label
                    break start_for;
                case 126:
                    caseAssignedValue = "Equal to 126";
                    break;
            }
            System.out.println("Done processing " + i +
                    ", caseAssignedValue = " + caseAssignedValue);
        }
        System.out.println("outside for loop" +
                ", caseAssignedValue = " + caseAssignedValue);
    }
}