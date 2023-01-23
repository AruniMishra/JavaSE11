class SuperTest {

    public SuperTest(int x) {
    }

    public SuperTest() {

    }
}

public class Test extends SuperTest {
    int first, second, third;

    public Test(int x, int y) {
        //there is an implicit call to super() in the two parameter Test constructor so you need to add both.
        //super();
        first = x;
        second = y;
    }

    public Test(int x) {
        super(x);
    }
}