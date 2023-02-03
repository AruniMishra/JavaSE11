class BaseClass {
    public void goodMethod() {
        System.out.println("BaseClass executing good method");
    }

    public void printInformation(CharSequence s) {
        System.out.println("BaseClass prints " + s);
    }

    public CharSequence getInformation() {
        return getClass().getName();
    }
}

class ExtendedClass extends BaseClass {

    // note: an override can still "throws" different type of Exception
    public void goodMethod() {
        super.goodMethod();
        System.out.println("AND ExtendedClass executing a better method");
    }

    public void extendedmethod() {
        System.out.println("extended-method invoked");
    }

    //not an override method
    //hence can also be declared as private (weaker privilege)
    private void printInformation(String string) {
        System.out.println("ExtendedClass prints " + string);
    }

    public String getInformation() {
        return getClass().getName();
    }
}

public class OverrideExample {
    public static void main(String[] args) {
        ExtendedClass e = new ExtendedClass();
        e.goodMethod();
        e.printInformation(e.getInformation());
        e.printInformation((CharSequence) e.getInformation());


        // note: below is valid
        BaseClass baseClass = new ExtendedClass();
        ((ExtendedClass) baseClass).extendedmethod();


        // Run time error
        BaseClass baseClass2 = new BaseClass();
        ((ExtendedClass) baseClass2).extendedmethod();
    }
}