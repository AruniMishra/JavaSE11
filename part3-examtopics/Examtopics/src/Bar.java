import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class Foo {
    public void foo(Collection arg) {
        System.out.println("Bonjour le monde!");
    }
}

public class Bar extends Foo {
    public static void main(String... args) {

        List<String> li = new ArrayList<>();
        Collection<String> co = li;
        Bar b = new Bar();
        b.foo(li);
        b.foo(co);
    }

    public void foo(List arg) {
        System.out.println("Bar Hello world!");
    }

    public void foo(Collection arg) {
        System.out.println("Bar Bonjour le monde!");
    }
}