package standardTest;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class S14 {
}

class Test1 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(args));
    }
}


class T16 {
    public static void main(String[] args) {
        List<Integer> iList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Predicate<Integer> p = x -> x % 2 == 0;
        List newList = iList.stream().filter(p).filter(x -> x > 3).collect(Collectors.toList());
        System.out.println(newList);
    }
}

class X17{
    int val = 10;
}

class Y extends X17{
    Y val = null; //1
}

class TestClass17 extends X17{

    public static void main(String[] args){
        Y y = new Y();
        // int k = (X17) y.val ; //2
        // System.out.println(k);

    }
}