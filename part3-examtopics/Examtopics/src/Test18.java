import java.io.FileNotFoundException;

class ExSuper extends Exception {
    private final int eCode;

    public ExSuper(int eCode, Throwable cause) {
        super(cause);
        this.eCode = eCode;
        System.out.println("ExSuper1");
    }

    public ExSuper(int eCode, String msg, Throwable cause) {
        super(msg, cause);
        this.eCode = eCode;
        System.out.println("ExSuper2");
    }

    public String getMessage() {
        return this.eCode + ": " + super.getMessage() + "-" + this.getCause().getMessage();
    }
}


class ExSub extends ExSuper {
    public ExSub(int eCode, String msg, Throwable cause) {

        super(eCode, msg, cause);
        System.out.println("ExSub");
    }

    public static void main(String[] args) {
        try {
            String param1 = "Oracle";
            if (param1.equalsIgnoreCase("oracle")) {

                throw new ExSub(9001, "APPLICATION ERROR-9001", new FileNotFoundException("MyFile.txt"));
            }
            System.out.println("skipped");
            throw new ExSuper(9001, new FileNotFoundException("MyFile.txt"));
        } catch (ExSuper ex) {
            System.out.println(ex.getMessage());
        }
    }
}


@FunctionalInterface
interface InterfaceE {
    public boolean equals(Object o);

    int breed(int x);
}

@FunctionalInterface
interface InterfaceB {
    int GERM = 13;

    public default int getGERM() {
        return get();
    }

    private int get() {
        return GERM;
    }

    public boolean equals(Object o);

    int breed(int x);
}


class X {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return getName();
    }
}

class Y extends X {
    public Y(String name) {
        super();
        setName(name);
    }

    public static void main(String... args) {
        Y y = new Y("HH");
        System.out.println(y);
    }

    public void setName(String name) {
        this.name = name;
    }
}

interface MyInterface {
    void m();
}

class Test {
    public static void main(String[] args) {
        MyInterface mi = () -> {

        };
    }
}
