class OnlyClass {

    // instances can only be created within current class
    // or a nested class
    private static final OnlyClass instance = new OnlyClass();
    private int classVariable;

    // private constructor, the ONLY constructor
    private OnlyClass() {
    }

    // You can expose the only instance via a static method
    public static OnlyClass getInstance() {
        return instance;
    }

    // Or you can make static methods which call methods on the
    // protected instance
    public static void doSomething() {
        instance.doSomethingRestricted();
    }

    private void doSomethingRestricted() {
        this.classVariable++;
        System.out.println("Only one instance of this class exists" +
                " or will ever exist");
    }
}

public class RestrictedObjects {
    public static void main(String[] args) {
        OnlyClass.doSomething();
    }
}