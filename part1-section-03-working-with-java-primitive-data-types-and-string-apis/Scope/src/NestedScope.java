public class NestedScope {
    public static void main(String[] args) {
        // local variable i declared and initialized
        int i = 10;
        class locallyDefinedClass {
            {
                // i from method scope still visible in nested local class
                System.out.println("value of i BEFORE LOOP  " + i);
                System.out.println("---------------");

                // Because this for loop is within a local class,this is valid
                for (int i = 0; i < 5; i++) {
                    System.out.println("value of i during FIRST loop " + i);
                }
                System.out.println("---------------");

                // the local variable i from previous loop has gone out of scope
                // so it is ok to create another local variable in the second loop
                // declaration of the same name.
                for (int i = 5; i > 0; i--) {
                    System.out.println("value of i during SECOND loop " + i);
                }
                System.out.println("---------------");

                //  assign local loop variable j to local variable i from the
                // surrounding method of the nested class,
                for (int j = i; j < 15; j++) {
                    System.out.println("value of i,j during THIRD loop " + i + "," + j);
                }
                System.out.println("value of i AFTER LOOP  " + i);
            }
        }
        System.out.println("value of i before local class instantiated " + i);
        new locallyDefinedClass();
        /*
        https://blog.brendanlacanette.com/2015/08/variable-is-accessed-within-inner-class.html
         */
        //i++;
        System.out.println("value of i after local class instantiated " + i);
    }
}