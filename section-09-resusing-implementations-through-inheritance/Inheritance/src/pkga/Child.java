package pkga;

import pkgb.Parent;

public class Child extends Parent {
    static String name = "DEF";  // Line 1

    public static void main(String[] args) {

        new Child().printName();

        System.out.println(new Child().getName());

        Parent p=new Child();
        System.out.println(p.getName());
    }

    /**
     * this method has the same access modifier as that of the parent class and
     * therefore is a valid method override.
     * <p> should not attempt to assign a weaker access privilege;
     * should be static with same returned type as {@link String}
     **/
    protected static String getName() {
        return name;
    }

    public void printName() { // Line 2
        System.out.println(Parent.name);  // Line 3
    }
}