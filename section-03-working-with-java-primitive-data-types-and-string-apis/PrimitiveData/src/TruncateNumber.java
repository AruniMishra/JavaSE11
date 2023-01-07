public class TruncateNumber {
    public static void main(String[] args) {

        float myFloat = 123.456f;
        Float myFloatWrapper = new Float(myFloat);
        int myNumber = (int) myFloat;

        // Casting with loss of precision..
        System.out.println("myNumber = " + myNumber);

        // We can get the same result using Float.intValue();
        System.out.println("Float.intValue() = " + myFloatWrapper.intValue());

    }

}