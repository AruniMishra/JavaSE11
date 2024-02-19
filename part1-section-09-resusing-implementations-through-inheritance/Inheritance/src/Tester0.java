interface I0 {
}

class A0 implements I0 {
}

class B0 extends A0 {
}

class C0 extends B0 {
}

public class Tester0 {
    public static void main(String[] args) {

        A0 a = new A0();
        B0 b = new B0();

        // a = (B0) (I0) b; // valid


        // b = (B0) (I0) a; // This will fail at run time because a does not point to an object of class B.

        a = (A0) (I0) b;
        // a = (I0) b;
        I0 i = (C0) a;
    }
}
