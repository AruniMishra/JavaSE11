package standardTest;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class S10 {
}

class Base38 {
    public <T extends Number, Z extends Number> Map<T, Z>
    getMap(T t, Z z) {
        return new HashMap<T, Z>();
    }
}

class Derived38 extends Base {
    /*
    //1 correctly overloads while //2 and //3 correctly override the method in Base.

    The rules for multiple type parameters are same as the rules for a single type parameter.
    You have to apply the same rules for both the type parameters separately.
    For example, we know that A<S> is a valid subtype of A<? extends T> (where S is a subtype of T).
    Therefore, Map<Integer, Integer> is a valid subtype of Map<T extends Number, Z extends Number>.

    The bounds defined by <T extends Number> and <T> are different.
    
    Therefore, the parameter list of //1 i.e. getMap(T t, Z z) is different
    from the parameter list of the Base class's method. Thus, it is a valid overload.
     */


    public <T, Z> TreeMap<T, Z> getMap(T t, Z z) {
        return new TreeMap<T, Z>();
    }

    ; // 1

// public  Map<Number, Number> getMap(Number t, Number z) {
//            return new TreeMap<Number, Number>(); }; //2

    public Map<Integer, Integer> getMap(Number t, Number z) {
        return new HashMap<Integer, Integer>();
    }

    ;   // 3
}
