/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 3: Working with Java Primitive Data Types and String APIs
Topic: Local Variable Type Inference
*/

import com.WordyCompanyName.ALongPackageName.AClassWithAVeryLongName;

import java.util.ArrayList;
import java.util.Arrays;

public class VarTest {

    // var a0 = 0;

    /*
    Var declarations are allowed only within method code (that is why it is called "local" type inferencing).
    It is not allowed for declaring class or instance fields, method return type, and method parameters
     */

    public static void main(String[] args) {
        var aClassWithAVeryLongName = new AClassWithAVeryLongName();
        aClassWithAVeryLongName.setName("Testing");
        System.out.println(aClassWithAVeryLongName);
        var a = 0;

        // Adding some other var declarations:
        // i is inferred to be an int, since it's assigned a literal int
        var i = 1;

        // An array can be assigned to an LVTI variable
        var aVarArray = new int[3];

        var varry = new ArrayList<>(); // valid
        varry.add(0, "b");

        var list2 = new ArrayList();

        // Valid to assign a method return value to an LVTI variable
        var methodVal = aClassWithAVeryLongName.getName();

        // OK to assign a null object to LVTI variable but not literal null
        Object nullObject = null;
        var var = nullObject;
        var var1 = nullObject = null;
        // var var2 = null; // invalid

        // Invalid var declarations:

        // // cannot use var declaration in a compound statement
        // var j = 0, k = 0;
        //
        // // again, cannot use var declaration in a compound statement
        // var m, n = 0;
        //
        // // Cannot declare a var variable without also initializing it
        // var someObject;
        //
        // // Cannot assign null to var variable, type cannot be inferred
        // var newvar = null;
        //
        // // Cannot use array initializer in var declaration/initialization
        // var myArray = {"A", "B"};
        //
        // // Cannot have an array of var
        // var[]newarray = new int[2];



        // An array initializer needs an explicit target-type if the variable is declared using var declaration
        var itest = new int[]{1, 2}; // If you give the elements explicitly you can't give the size
        int[] itest2 =  new int[]{1, 2}; // (or just { 1, 2 } if you are not using var declaration)

    }
}