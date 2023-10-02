public class Intern {
    public static void main(String[] args) {

        /*
         JVM will create a new string object in normal (non-pool) heap memory
         and the literal “Welcome” will be placed in the string constant pool.
         The variable s will refer to the object in the heap (non-pool)
         */

        String s0 = new String("GFG"); // Line-1

        // S1 refers to Object in the Heap Area
        String s1 = new String("GFG"); // Line-1
        System.out.println(s1 == s0);

        System.out.println(s1 == "GFG");

        // S2 now refers to Object in SCP Area
        String s2 = s1.concat("GFG"); // Line-2

        System.out.println(s2);

        // S3 refers to Object in SCP Area
        String s3 = s2.intern(); // Line-3

        System.out.println(s2 == s3);

        // String literals automatically interned so all "hello" literals
        // point to same reference in memory, in the string pool
        // S4 refers to Object in the SCP Area
        String s4 = "GFGGFG"; // Line-4

        System.out.println(s3 == s4);

        String S40 = s4;
        System.out.println(S40 == s4);


        // S5 refers to Object in the SCP Area
        String s5 = s1.intern(); // Line-2

        // S6 refers to Object in the SCP Area
        String s6 = "GFG"; // Line-3

        System.out.println(s5 == s6);



        /*
        's1' refers to non-pool String object.
        Below is the definition of toString() method of String class:
            public String toString() {
                return this;
            }

        It returns the same instance, on which toString() method is invoked.
        Hence, `s1.toString();` returns the same object referred by s1.

        s2 and s1 both refer to same non-pool String object.
         */
        String s7 = new String("ALL IS WELL");
        String s8 = s1.toString();
        // s7==s8 // true


    }
}
