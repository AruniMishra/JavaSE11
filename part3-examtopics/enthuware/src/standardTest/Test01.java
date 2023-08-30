package standardTest;

interface Flyer {
    String getName();
}


class Bird implements Flyer {
    public String name;

    public Bird(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Eagle extends Bird {
    public Eagle(String name) {
        super(name);

    }
}

class TestClass {
    public static void main(String[] args) throws Exception {
        Flyer f = new Eagle("American Bald Eagle");
        // PRINT NAME HERE

        // System.out.println(f.name); // invalid
        System.out.println(f.getName());
        System.out.println(((Eagle) f).name);
        System.out.println(((Bird) f).getName());
        // System.out.println(Eagle.name);
        // System.out.println(Eagle.getName(f));

    }
}

public class Test01 {
}