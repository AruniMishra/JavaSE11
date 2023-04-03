public class SwitchStatementOddities {
    public static void main(String[] args) {
        byte[] bytes = {100, 103, 104, 107, 126};
        String caseAssignedValue = "";
        for (var i : bytes) {  // Using LVTI here
            switch (i * 10) {  // Use an Expression
                case 1000:
                case 1030:
                case 1040:
                case 1070:
                    caseAssignedValue = "Less than 1100";
                    break;
                case 1260:
                    caseAssignedValue = "Equal to 1260";
                    break;
            }
            System.out.println("Done processing " + i +
                    ", caseAssignedValue = " + caseAssignedValue);
        }
    }
}