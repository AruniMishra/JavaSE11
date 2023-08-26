package stringbuilder;


public class StringBuilderCreation {
    public static void main(String[] args) {

        /*
        If the number of the character increases from its current capacity,
        it increases the capacity by (oldcapacity*2)+2.
         */

            /*
            StringBuilder(String str):
            This constructor is used for creating a StringBuilder object with
            initial content the same as str characters
            and initial capacity = 16 + length of str.
             */
        // creates empty builder
        // An empty StringBuilder always has initial capacity of 16
        StringBuilder sb = new StringBuilder();

        // adds 5 character string at beginning
        sb.append("Hello");
        System.out.println("sb.length =" + sb.length());
        System.out.println("sb.capacity = " + sb.capacity());

        StringBuilder sb2 = new StringBuilder("Hello678");
        System.out.println("\nsb2.length = " + sb2.length());

        // Capacity is the initial capacity (16) + "Hello678".length()
        System.out.println("sb2.capacity = " + sb2.capacity());

        StringBuilder sb3 = new StringBuilder();
        // Add 26 character string at beginning, which exceeds the
        // initial capacity of 16
        sb3.append("abcdefghijklmnopqrstuvwxyz");
        System.out.println("\nsb3.length = " + sb3.length());
        System.out.println("sb3.capacity = " + sb3.capacity());

        sb3.append("abcdefghijklmnopqrstuvwxyz");
        System.out.println("\nsb3.length2 = " + sb3.length());
        System.out.println("sb3.capacity2 = " + sb3.capacity()); // now (34*2)+2=70

        // You can set initial capacity manually
        StringBuilder sb4 = new StringBuilder(26);
        // Add 26 character string at beginning
        sb4.append("abcdefghijklmnopqrstuvwxyz");
        System.out.println("\nsb4.length = " + sb4.length());
        System.out.println("sb4.capacity = " + sb4.capacity());
    }
}