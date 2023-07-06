// interface Confusable has a constant name and abstract method
interface Confusable {
    String name = "Confusable";

    String confuse();
}

// Abstract class Confused has a constant name and abstract method
abstract class Confused {
    public static String name = "Confused";

    abstract Object confuse();
}

// AmbiguousExamples will demonstrate some problems with multiple
// inheritance of type
public class AmbiguousExamples extends Confused implements Confusable {
    public static void main(String[] args) {
        AmbiguousExamples a = new AmbiguousExamples();
        System.out.println("The method confuse returns: " + a.confuse());
    }


    public String confuse() {
        String name = Confusable.name;
        return Confused.name;
    }
}

