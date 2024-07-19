import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class Test29 {
}


class Person192 {
    String name;

    public Person192(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

class Employee192 extends Person192 {
    Manager192 manager;

    public Employee192(String name) {
        super(name);
    }

    public String toString() {
        String managerStr = this.manager == null ? "None" : this.manager.toString();
        return super.toString() + " Manager192: " + managerStr;
    }
}

class Manager192 extends Employee192 {
    List reports = new ArrayList<>();

    public Manager192(String name, Employee192... reports) {
        this(name, null, reports);
    }

    public Manager192(String name, Manager192 manager, Employee192... reports) {
        super(name);
        this.manager = manager;
        for (Employee192 employee : reports) {
            employee.manager = this;
        }
        this.reports.addAll(List.of(reports));
    }

    public String toString() {
        return super.toString() + " Reports:" + reports.size();
    }
}

class Main192 {
    public static void main(String[] args) {
        Manager192 manager = new Manager192("AA", new Employee192("BB"), new Employee192("CC"));
        System.out.println(manager);

        BiPredicate<Integer, Integer> test = (Integer x, final Integer y) -> (x.equals(y));
        BiPredicate test2 = (var x, final var y) -> (x.equals(y));
    }
}


@interface Resource201 {
    String value() default "Customer1";
}

// @Resource201("Customer2") // valid
// @Resource201(value = "Customer2") // valid
@Resource201 // valid
class ProcessOrders {

}




class Foo213 {
    public Foo213(BiFunction op) {  }

    public BiFunction foo;
    public BiFunction predicate(Function transform) {
        return null;
    }
    public void foo(BiFunction predicate) {  }
}