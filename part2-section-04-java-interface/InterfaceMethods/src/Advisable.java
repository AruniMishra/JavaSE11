/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 3: Interfaces
Topic:  Private methods
*/

// Interface to support academic advisors at universities.
interface Advisable {

    private static String getLevelCode(AcademicLevel academicLevel) {
        String levelCode = "";
        switch (academicLevel) {
            case FAILING:
            case UNSATISFACTORY:
                levelCode = "UD";
                break;
            case OVERACHIEVING:
                levelCode = "ADV";
        }
        return levelCode;
    }

    // This is the method all implementing classes must override
    void advise(GradeLevel gradeLevel, AcademicLevel[] academicLevel);

    // Default method gets schedule by class level
    default String getRequirements(GradeLevel grade,
                                   AcademicLevel[] academicLevel) {

        String reqs = grade.toString();
        for (int i = 0; i < grade.courses.length; i++) {
            // This code block used here as well as in getClass method
            /*String levelCode = "";
            switch (academicLevel[i]) {
                case FAILING:
                case UNSATISFACTORY:
                    levelCode = "UD";
                    break;
                case OVERACHIEVING:
                    levelCode = "ADV";
            }*/
            // String levelCode = NestedClass.getLevelCode(academicLevel[i]);
            String levelCode = getLevelCode(academicLevel[i]);

            // Build schedule...
            reqs += ": \n\t\t "
                    + grade.courses[i] + " "
                    + (grade.ordinal() + 1) + "000"
                    + levelCode;
        }
        return reqs;
    }

    // Default method to get a single class
    default String getClass(GradeLevel grade, String course, AcademicLevel academicLevel) {

        // This code is repeated again in this method
        /*String levelCode = "";
        switch (academicLevel) {
            case FAILING:
            case UNSATISFACTORY:
                levelCode = "UD";
                break;
            case OVERACHIEVING:
                levelCode = "ADV";
        }*/
        // String levelCode = NestedClass.getLevelCode(academicLevel);
        String levelCode = getLevelCode(academicLevel);
        return course + " " + (grade.ordinal() + 1) + "000"
                + levelCode;
    }

    // Set up some enums to facilitate code
    enum GradeLevel {
        FRESHMAN("Math", "History"),
        SOPHOMORE("Math", "Political Science"),
        JUNIOR("CompSci", "DiffEq"),
        SENIOR("ElectroMagnetics", "Statistics");
        String[] courses;

        GradeLevel(String... courses) {
            this.courses = courses;
        }
    }

    // replace nested class with private
    /*
    // Modifier 'static' is redundant for inner classes of interfaces
    public static class NestedClass {
        private static String getLevelCode(AcademicLevel academicLevel) {
            String levelCode = "";
            switch (academicLevel) {
                case FAILING:
                case UNSATISFACTORY:
                    levelCode = "UD";
                    break;
                case OVERACHIEVING:
                    levelCode = "ADV";
            }
            return levelCode;
        }
    }
    */

    enum AcademicLevel {
        FAILING, UNSATISFACTORY, SATISFACTORY, OVERACHIEVING
    }


}

// Implementing Class
class PrivateExamples implements Advisable {

    public static void main(String[] args) {
        PrivateExamples p = new PrivateExamples();
        // Advise a Sophomore not doing great
        p.advise(GradeLevel.SOPHOMORE, new AcademicLevel[]{
                AcademicLevel.UNSATISFACTORY,
                AcademicLevel.SATISFACTORY});

        // Advise a Freshman who is excelling
        p.advise(GradeLevel.FRESHMAN, new AcademicLevel[]{
                AcademicLevel.OVERACHIEVING,
                AcademicLevel.OVERACHIEVING});

        // Get a single class for freshman math
        System.out.println("\nFreshman underperforming in Math takes " +
                p.getClass(GradeLevel.FRESHMAN, "Math",
                        AcademicLevel.UNSATISFACTORY));

    }

    // Concrete implementation of Advisable's advise method
    public void advise(GradeLevel gradeLevel,
                       AcademicLevel[] academicLevel) {
        System.out.println(getRequirements(gradeLevel, academicLevel));
    }

}

