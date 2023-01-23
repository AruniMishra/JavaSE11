package pkgTwo;

import pkgOne.LevelTwoClass;

// Extends class from a different package
class LevelThreeClass extends LevelTwoClass {

    // package-private constructor
    LevelThreeClass() {
        this("good");
        System.out.println("package LevelThreeClass " +
                "no args constructor");
    }

    // private constructor
    private LevelThreeClass(String text) {
        super();
        System.out.println("private LevelThreeClass " +
                "single params constructor");
    }
}

public class ConstructorAccess {
    public static void main(String[] args) {
        // The constructor test
        LevelThreeClass c = new LevelThreeClass();

    }
}