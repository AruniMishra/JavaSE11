package pkgb;

public class Parent {

    protected static String name = "ABC";

    //'name' is not public in 'pkgb.Parent'. Cannot be accessed from outside package
    // static String name = "ABC";

    protected static String getName() {
        return name;
    }

    protected void printName() {
        System.out.println(name);
    }
}