interface ITest {
    void myMethod();
}

abstract class ATest implements ITest {

    /**
     * both abstract or concrete method should be <b>public</b> when overrides
     * an interface method
     */

    //abstract void myMethod(); // Line 1
    public void myMethod() {


    }
}

public class Test extends ATest {
    public static void main(String[] args) {
        Test t = new Test();
        t.myMethod();
    }

    public void myMethod() {   // Line 2
        System.out.println("Success");
    }
}