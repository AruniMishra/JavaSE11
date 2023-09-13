/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Using  wrapper classes, methods
*/

public class MoreWrapperMethods {
    public static void main(String[] args) {
        testInstanceMethods();

        // testStaticMethods();

    }

    private static void testInstanceMethods() {

        Boolean bWrapper = true;
        Character cWrapper = 'c';
        Integer iWrapper = 100;
        Short sWrapper = 100;

        System.out.println("==== Using the instance wrapper methods ====");
        System.out.println("---- Using the {primitive}Value() methods ----");
        System.out.println("Using bWrapper.booleanValue() produces: " + bWrapper.booleanValue());

        System.out.println("Using iWrapper.integerValue() produces: " + iWrapper.intValue());

        System.out.println("Using cWrapper.charValue() produces: " + cWrapper.charValue());

        System.out.println("---- Using the equals method ----");
        Boolean bWrapper2 = true;
        System.out.println(printWrapper(bWrapper) + ".equals(null) = " + bWrapper.equals(null));
        System.out.println(printWrapper(bWrapper) + ".equals(false) = " + bWrapper.equals(false));
        System.out.println(printWrapper(bWrapper) + ".equals(true) = " + bWrapper.equals(true));
        System.out.println(printWrapper(bWrapper) + ".equals(" + printWrapper(bWrapper2) + " = " + bWrapper.equals(bWrapper2));

        Integer iWrapper2 = 100;
        System.out.println(printWrapper(iWrapper) + ".equals(null) = " + iWrapper.equals(null));
        System.out.println(printWrapper(iWrapper) + ".equals(" + printWrapper(iWrapper2) + " = " + iWrapper.equals(iWrapper2));

        // Wrapper object types must match exactly
        System.out.println(printWrapper(iWrapper) + ".equals(" + printWrapper(sWrapper) + " = " + iWrapper.equals(sWrapper));

        System.out.println(printWrapper(iWrapper) + ".equals(" + printWrapper(sWrapper) + " = " + ((Number) iWrapper).equals(sWrapper));

    }

    public static String printWrapper(Object o) {
        return "[" + o.getClass().getSimpleName() + "(" + o + ")]";
    }

    private static void testStaticMethods() {

        System.out.println("\n==== Using the static wrapper methods ====");
        System.out.println("---- Using the compare method ----");
        System.out.println("Boolean.compare(true,true) = " + Boolean.compare(true, true));
        System.out.println("Boolean.compare(false,false) = " + Boolean.compare(false, false));
        System.out.println("Boolean.compare(true,false) = " + Boolean.compare(true, false));
        System.out.println("Boolean.compare(false,true) = " + Boolean.compare(false, true));

        System.out.println("Integer.compare(2,0b10) = " + Integer.compare(2, 0b10));
        System.out.println("Integer.compare(10,0) = " + Integer.compare(10, 0));
        System.out.println("Integer.compare(0,10) = " + Integer.compare(0, 10));
        System.out.println("Integer.compare('A','a') = " + Integer.compare('A', 'a'));

        System.out.println("Character.compare('a','\\u0061') = " + Character.compare('a', '\u0061'));
        System.out.println("Character.compare('A','a'') = " + Character.compare('A', 'a'));
        System.out.println("Character.compare('Z','A') = " + Character.compare('Z', 'A'));


        System.out.println("\n---- Using the parse[Primitive](String s) ");

        System.out.println("Integer.parseInt(\"100\") = " +
                Integer.parseInt("100"));
        System.out.println("Boolean.parseInt(\"TRUE\") = " +
                Boolean.parseBoolean("TRUE"));


        System.out.println("\n---- Using the get[Wrapper]() methods ----");

        System.out.println("Integer.getInteger(\"10\") = " +
                Integer.getInteger("10"));
        System.out.println("Boolean.getBoolean(\"true\") = " +
                Boolean.getBoolean("true"));

        // Set some system properties
        System.setProperty("app.threads", "10");
        System.setProperty("app.debugFlag", "TRUE");

        System.out.println(Integer.getInteger("app.threads"));
        System.out.println(Boolean.getBoolean("app.debugFlag"));
    }
}

