/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 9: Reusing Implementations Through Inheritance
Topic: Create and use subclasses and superclasses
Sub-Topic: Out of Ordinary.  Static field inheritance
*/

package company;

// Employee Class with type, name attributes
class Employee {
    private String type;
    private String name;

    Employee(String name, String type) {
        this.name = name;
        this.type = type;
    }
}

// Company has two static fields, and two methods which increment
// the fields.  Leaving them public for demonstration purposes
class Company {
    public static int branchCount;
    public static int employeeCount;

    static {
        System.out.println("Company Static Initializer");
        branchCount = 10;
    }

    public void addEmployee(Employee e) {
        System.out.println("Company addEmployee ");
        employeeCount++;
    }

    public void addBranch(Branch b) {

        branchCount++;
    }
}

// Company is a subclass of Branch
class Branch extends Company {
    public int branchCount; // this hide Company's branchCount
    public int employeeCount;  // this hide Company's employeeCount
    private String branchName = "unspecified";

    {
        System.out.println("Branch Static Initializer");
        employeeCount = 200;
    }

    Branch(String branchName) {
        this.branchName = branchName;
    }

    /*
    Instance method 'addEmployee(Employee)' in 'company.Branch' cannot override static method 'addEmployee(Employee)' in 'company.Company'
     */
    public void addEmployee(Employee e) { // this override the Company's addEmployee
        System.out.println("Branch addEmployee");
        employeeCount++;
    }
}

public class OnBoardBranch {
    public static void main(String[] args) {

        // Create some objects
        Branch b = new Branch("RedBranch");
        Employee e1 = new Employee("Carol", "President");
        Employee e2 = new Employee("Ralph", "Vice President");
        Company main = new Company();

        // Execute the methods that should effect the static fields.
        main.addBranch(b);
        b.addEmployee(e1);
        b.addEmployee(e2);

        // The static variable defined on Company accessed here
        System.out.println("Number of Branches = " + Company.branchCount);
        System.out.println("Number of Employees = " + Company.employeeCount);

        // What does it mean to access the static variables from Branch?
        System.out.println("Call from Branch: Number of Branches = " +
                b.branchCount);
        System.out.println("Call from Branch: Number of Employees = " +
                b.employeeCount);
    }
}