package demo;

class TestClass {
    static int data = 30;
    static Inner obj2 = new Inner();

    public static void main(String args[]) {
        TestClass.Inner obj = new TestClass.Inner();
        obj.msg();
        Inner obj1 = new Inner();
        obj.msg();
        obj2.msg();
    }

    static class Inner {
        void msg() {
            System.out.println("data is " + data);
        }
    }
}