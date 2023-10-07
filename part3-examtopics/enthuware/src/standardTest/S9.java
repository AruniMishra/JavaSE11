package standardTest;

public class S9 {
    public static void main(String[] args) {
        double daaa[][][] = new double[3][][];
        var d = 100.0;
        double[][] daa = new double[1][1];

        // daa[1][1] = d;
    }
}

class NewExceptionT43 extends Exception {
}

class AnotherExceptionT43 extends Exception {
}

class ExceptionTestT43 {
    public static void main(String[] args) throws Exception {
        try {
            m2();
        } finally {
            m3();
        }
        // catch (NewException e){}
    }

    public static void m2() throws NewExceptionT43 {
        throw new NewExceptionT43();
    }

    public static void m3() throws AnotherExceptionT43 {
        throw new AnotherExceptionT43();
    }

}


class s10TableTest {
    static String[][] table;
    public static void main(String[] args) {
        String[] x = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };
        String[] y1 = { "1", "2", "3", "4", "5" };
        String[] y2 = { "a", "b", "c" };

        table = new String[3][];
        table[0] = x;
        table[1] = y1;
        table[2] = y2;

        //INSERT CODE HERE
        for(var row : table){
            System.out.print(row[row.length-1]);
        }

    }
}