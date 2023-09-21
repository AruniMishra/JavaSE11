package controllingFlowOO1;

public class Test01 {
}

class Test34 {
    public static void main(String[] args) {
        int sum = 0;
        for (var i = 0; i < 7; i++) { // Line n1
            if (i == 4) break;
            else continue;
            // sum += i; //Line n2
        }
        System.out.println(sum); // Line n3
    }
}


class Test42 {
    public static void main(String[] args) {
        var res = ""; // Line n1
        String[] arr = {"1", "2", "3"};
        for (var s : arr) { // Line n2
            res += String.join(".", s); // Line n3
        }
        System.out.println(res); // Line n4
    }
}

class A {
    private String str = "WINNERS NEVER QUIT";

    public class B {
        public B(String s) {
            if (s != null) str = s;
        }

        public void m1() {
            System.out.println(str);
        }
    }
}


class A70 {
    public void print(String name) {
        class B70 {
            B70() {
                System.out.println(name); // Line n1
            }
        }
    }
    // B70 obj = new B70(); //Line n2 // invalid here
}

class Test70 {
    public static void main(String[] args) {
        new A70().print("OCP"); // Line n3
    }
}

class Test58 {
    public static void main(String[] args) {
        // Insert statement here
        // new A().new B().m1();
        new A().new B(null).m1();
    }

}


class Outer {
    /*
    the execution order is:
    static initializer block, instance initializer block and then constructor.
     */
    static {
        System.out.print(0);
    }


    {
        System.out.print(1);
    }

    Outer() {
        System.out.print(2);
    }

    class Inner {
        /*INSERT 2*/ {
            System.out.print(3);
        }

        Inner() {
            System.out.print(4);
        }
    }
}

class Test66 {
    public static void main(String[] args) {
        new Outer().new Inner();
    }
}

class Outer67 {

    int a = 0;

    public void print(int x) {
        class Inner {
            public void getX() {
                // a method local inner class can access local variables
                // and parameters of the enclosing block that are final or effectively final.
                // System.out.println(++x);
                System.out.println(++a);
            }
        }
        Inner inner = new Inner();
        inner.getX();
    }

    class Inner2 {
        public void getX() {

            System.out.println(++a);
        }
    }
}

class Test67 {
    public static void main(String[] args) {
        new Outer67().print(100);
    }
}


class A68 {
    public void someMethod(final String name) {
        /*INSERT*/
        class B {
            void print() {
                System.out.println("Hello " + name);
            }
        }
        new B().print();

    }
}

class Test68 {
    public static void main(String[] args) {
        new A68().someMethod("World!");
    }
}


class Season {
    public void printCurrentSeason() {
        System.out.println("SUMMER");
    }
}

class Test76 {
    public static void main(String[] args) {
        var season = new Season() { // Line n1

            // @Override // makes compilation error
            public void PrintCurrentSeason() { // Line n2
                System.out.println("WINTER");
            }
        };
        season.PrintCurrentSeason(); // Line n3
    }
}