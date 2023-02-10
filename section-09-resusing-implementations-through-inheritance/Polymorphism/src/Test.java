class Plant1 {
}

class Flower1 extends Plant1 {
}

public class Test {

    public static void main(String[] args) {

        // Primitive Casting
        float f1 = (float) 10.0; // Line 1
        float f2 = (float) 10.0f; // Line 2

        // Line 3 fails to compile, because the float cast is applied only to the
        // dividend,
        // and not to the entire expression, so then it results in a double result and
        // cannot be assigned to a float.
        // float f3 = (float) f1/2.0; // Line 3
        float f4 = (float) f1 / 2.0f; // Line 4

        // Object Casting

        Object o = new Plant1();
        Plant1 plantA = new Flower1();
        Plant1 plantB = (Plant1) o; // Line 5

        /**
         * JVM won't compile; java.lang.ClassCastException: class Plant1 cannot be cast
         * to class Flower1
         * line 6 and 7 & 8
         **/
        Plant1 plantC = (Flower1) o; // Line 6
        Flower1 flower = (Flower1) o; // Line 7

        Plant1 plant1 = new Plant1();
        Flower1 flower1 = (Flower1) plant1; // Line 8
    }
}