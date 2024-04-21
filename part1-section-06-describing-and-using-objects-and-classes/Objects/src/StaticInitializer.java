class staticInitExample {
    static int statementOrder;
    static int firstVariable = clarifyOrder("assigning firstVariable");
    static int secondVariable = clarifyOrder("assigning secondVariable");


    // Static initializer 1
    static {
        clarifyOrder("executing initializer 1");
    }

    {
        System.out.println("---executing non static initializer 1");
    }

    // Static initializer 2
    static {
        clarifyOrder("executing initializer 2");
    }

    static int clarifyOrder(String message) {
        statementOrder++;
        System.out.println(statementOrder + " " + message);
        return statementOrder;
    }

    staticInitExample(){
        System.out.println("constructor at the end only when an instance object is created");
    }
}

public class StaticInitializer {
    public static void main(String[] args) {
        System.out.println("statements made so far = " + staticInitExample.statementOrder);

        staticInitExample example = new staticInitExample();
    }
}