package demo;

public class TestClass {


    public static void main(String[] args) {


    }

    public Innerclass getInnerclass() {
        return innerclass;
    }

    public void setInnerclass(Innerclass innerclass) {
        innerclass.a = 1;
        this.innerclass = innerclass;
    }

    static interface InnerInterface {

    }

    public static final class Innerclass {
        public int a = 0;

        public static void main(String[] args) {
            System.out.println("inside");
        }

    }

    Innerclass innerclass = new Innerclass();
}

 interface Test {
    double sum();

    // Compile-time error here
    double mul();
}
