abstract class Counter {

    int value;

    public Counter() {
        this.value = 0;
    }

    abstract int increment();
}

class SimpleCounter extends Counter {

    @Override
    int increment() {
        return ++value;
    }
}

public class Tester2 {
    public static void main(String[] args) {
        Counter counter = new SimpleCounter();
        counter.increment();
        System.out.println(counter.value);

        SimpleCounter simpleCounter = new SimpleCounter();
        System.out.println(simpleCounter.value);

    }


}
