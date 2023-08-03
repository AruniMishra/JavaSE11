import java.util.List;

class Father {
}

class Son extends Father {
}

class GrandSon extends Son {
}

abstract class Super2 {
    abstract List<Father> get();

    abstract Father get1();
}

class Sub2 extends Super2 {
    /*
    There are 2 rules related to return types of overriding method:
    1. If return type of overridden method is of primitive type, then overriding method should use same primitive type.
    2. If return type of overridden method is of reference type,
    then overriding method can use same reference type or its subtype (also known as covariant return type).
    */

    // ArrayList<Object> get() {return null;} // invalid
    // List<Son> get() {return null;} // List<Son> is not subtype of List<Father>

    List<Father> get() {
        return null;
    }

    Son get1() {
        return null;
    }
}