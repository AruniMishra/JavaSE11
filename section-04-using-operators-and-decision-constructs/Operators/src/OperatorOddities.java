public class OperatorOddities {
    public static void main(String[] args) {

        byte byte1 = 1;
        var byte2 = +byte1;  // What is byte2?
        System.out.println("byte2" + TestVar(byte2));

        var negativeByte = -byte1;
        System.out.println("negativeByte" + TestVar(negativeByte));

        short short1 = 2;
        var result = byte1 + short1;
        System.out.println("result" + TestVar(result));

        long long1 = 10L;
        var result2 = long1 + (1.0);
        System.out.println("result2" + TestVar(result2));
    }

    // This method works because of the way Java
    // autoboxes and evaluates method parameters...
    public static String TestVar(Object var) {
        String returnValue = " is unknown";
        if (var instanceof Byte) {
            returnValue = " is a byte";
        } else if (var instanceof Character) {
            returnValue = " is a char";
        } else if (var instanceof Short) {
            returnValue = " is a short";
        } else if (var instanceof Integer) {
            returnValue = " is an int";
        } else if (var instanceof Long) {
            returnValue = " is a long";
        } else if (var instanceof Double) {
            returnValue = " is a double";
        } else if (var instanceof Float) {
            returnValue = " is a float";
        }
        return returnValue;
    }
}