class StaticStuffTest {

    public static int counter= 0;
    static {
        System.out.println("StaticStuff: static initializer");
        StaticStuffTest.counter++;
        StaticStuffTest.counter2++; // legal but effectively a no-op
        StaticStuffTest.counter3++;

//        counter2++; //invalid, Illegal forward reference.
    }
    /**
     * This is a gotcha. It's executed AFTER the static initializer, so it's value will be 0.
     * Also applies to non-static initialization blocks
     */
    public static int counter2 = 99;
    public static int counter3;

    public static void print(){
        System.out.println("StaticStuff: counter:  "+counter);
        System.out.println("StaticStuff: counter2: "+counter2);
        System.out.println("StaticStuff: counter3: "+counter3);
    }

}

// -----------
public class StaticReferences {
    public static void main(String[] args) {
        /*
         * outputs
         * StaticStuff: counter:  1
         * StaticStuff: counter2: 0
         * StaticStuff: counter3: 1
         */
        StaticStuffTest.print();
    }
}