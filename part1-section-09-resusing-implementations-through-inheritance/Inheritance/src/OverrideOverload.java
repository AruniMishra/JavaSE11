// MostBasicClass has 3 overloaded methods, all named baseMethod
class MostBasicClass {

    public void baseMethod() {
        System.out.println("- PARENT OVERLOAD 'void baseMethod()'");
        return;
    }

    public Object baseMethod(String s) {
        System.out.println("- PARENT OVERLOAD " +
                "'Object baseMethod(String s)'");
        return s;
    }

    public int baseMethod(int... intArray)
            throws ArrayIndexOutOfBoundsException {

        System.out.println("- PARENT OVERLOAD " +
                "'int baseMethod(int... intArray)'");

        return intArray[intArray.length + 1];
    }
}

// OverrideOverload class extends MostBasicClass
public class OverrideOverload extends MostBasicClass {

    // This method overrides one of MostBasicClass's overloaded methods
    public void baseMethod() {
        super.baseMethod();
        System.out.println("- CHILD OVERRODE 'void baseMethod()'");
    }

    // Main method will call our overloaded, overridden methods
    public static void main(String[] args) {
        int[] intArray = new int[]{1, 2, 3, 4, 5};
        OverrideOverload oo = new OverrideOverload();
        int i = 0;
        oo.baseMethod();
        oo.baseMethod("10");
        try {
            // We'll make the call with var args
            i = oo.baseMethod(1, 2, 3, 4, 5);

        } catch (Exception e) {
            System.out.println("Uh oh, error occurred in call to" +
                    " oo.baseMethod(intArray)");
        }
        System.out.println("local variable i = " + i);
    }
}