interface APIInterface {
    public default void process() {
        System.out.println("Process () called 1.");
    }
}

abstract class AbstractAPI {
    public abstract void process();
}

public class ApiImpl extends AbstractAPI implements APIInterface {
    public static void main(String[] args) {
        var impl = new ApiImpl();
        impl.process();

        System.out.println("------------------------");
        APIInterface impl2 = new ApiImpl();
        impl2.process();
    }

    @Override
    public void process() {
        System.out.println("Process called 2");
    }
}