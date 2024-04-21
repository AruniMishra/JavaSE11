// Example of a final class
final class FinalEntity {

    private String name;

    FinalEntity(String name) {
        this.name = name;
    }

    void doSomething() {
        System.out.println("doing something for " + this.name);
    }
}

public class FinalClassExample {
    public static void main(String[] args) {

        String name = new String("");

        // You can create as many instances of a final class as you wish
        FinalEntity f1 = new FinalEntity("a");
        FinalEntity f2 = new FinalEntity("b");
        f1.doSomething();
        f2.doSomething();
    }
}

//Cannot inherit from final 'FinalEntity'
/*
class Myclass extends FinalEntity{

    Myclass(String name) {
        super(name);
    }
}*/
