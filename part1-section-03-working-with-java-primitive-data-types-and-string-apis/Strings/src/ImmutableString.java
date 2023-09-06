public class ImmutableString {

    public static void main(String[] args) {

        //  "Hello" exists on the string pool, s1 gets a reference to it
        /*
        String objects created without the use of new keyword are stored in
        the String Constant Pool part of the heap.
         */
        String s1 = "Hello";

        /*
        The following code does not change the value of "Hello" on the
        string pool, it creates a new string with value of "Hello World" and
        passes the reference to this new string to s1;

        "Hello World" not added to the string pool unless intern() called
        */
        s1 = s1 + " World";

        System.out.println(s1);


        String s2 = "Hello World";
        System.out.println(s1 == s2); // false

        // Let's reset s1 and show another example using String's concat
        // method which we'll discuss later
        s1 = "Hello";
        s1.concat(" World");

        System.out.println(s1);
    }
}