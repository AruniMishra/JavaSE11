public class OverloadPrimitive {
    public static void main(String[] args) {
        OverloadPrimitive o = new OverloadPrimitive();
        o.bestMethod((byte) 1);
        o.bestMethod('a');
        o.bestMethod((short) 1);
        o.bestMethod(1);
        o.bestMethod(1L);
        o.bestMethod(1f);
        o.bestMethod(1d);
        o.bestMethod(true);
        o.bestMethod(Byte.valueOf((byte) 1));
    }

    private void bestMethod(byte b) {
        System.out.println("bestMethod for byte");
    }

    private void bestMethod(char c) {
        System.out.println("bestMethod for char");
    }

    private void bestMethod(short s) {
        System.out.println("bestMethod for short");
    }

    private void bestMethod(int i) {
        System.out.println("bestMethod for int");
    }

    private void bestMethod(long l) {
        System.out.println("bestMethod for long");
    }

    private void bestMethod(float l) {
        System.out.println("bestMethod for float");
    }

    private void bestMethod(double d) {
        System.out.println("bestMethod for double");
    }

    private void bestMethod(boolean b) {
        System.out.println("bestMethod for boolean");
    }

    private void bestMethod(Object o) {
        System.out.println("bestMethod for Object");
    }
}