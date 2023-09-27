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
    }
}