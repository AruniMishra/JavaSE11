package OO2;

public class Test {
}

class Test31 {

    /*
    We are not creating the instance of Test class, so instance initializer block will not be executed.
    Only static initializer block will be executed in this case.
     */
    static int a = 10000;

    static {
        a = -a--;
    }

    {
        a = -a++;
    }

    public static void main(String[] args) {
        System.out.println(a);
    }
}


class Wall {
    public static void main(String args[]) {
        double area = 5.7;
        String color;
        if (area < 7)
            color = "BLUE";

        // System.out.println(color); // invalid

        double price = 90000;
        String model;
        if (price > 100000) {
            model = "Tesla Model X";
        } else if (price <= 100000) {
            model = "Tesla Model S";
        }
        // System.out.println(model); // still invalid


        double price2 = 90000;
        String model2;
        if (price2 > 100000) {
            model2 = "Tesla Model X";
        } else {
            model2 = "Tesla Model S";
        }
        System.out.println(model2); // valid, with else


        String h1 = "hello";

        String replace = h1.replace('h', 'h');

        System.out.println(h1 == replace);
    }
}


class Parent {
    int var = 1000; // Line n1

    int getVar() {
        return var;
    }
}

class Child extends Parent {
    int var = 2000; // Line n2

    int getVar() {
        return super.var; // Line n3
    }
}

class Test1232 {
    public static void main(String[] args) {
        Child obj = new Child(); // Line n4
        System.out.println(obj.var); // Line n5
    }
}


class M {
    public void main(String[] args) { // Line n1
        System.out.println("M");
    }
}

class N extends M {
    public void main(String[] args) { // Line n2
        new M().main(args); // Line n3
    }
}