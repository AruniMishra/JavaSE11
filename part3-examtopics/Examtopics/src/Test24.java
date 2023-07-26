import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;

public class Test24 {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            // String s = scan.nextLine();
            // System.out.println(s);
            // Resources used in try-with-resources statement are implicitly final,
            // which means they can't be reassigned.
            // scan = null;
        }

        System.out.println("\n1----------------------------");
        // Resources used in try-with-resources statement must be initialized.
        try (PrintWriter writer = null) { //  invalid: try (PrintWriter writer;)
            // writer = new PrintWriter(System.out);// invalid
            // writer.println("HELLO");
        }


        System.out.println("\n2----------------------------");
        try (MyResource resource = new MyResource()) {
            resource.execute();
        }


        System.out.println("\n3----------------------------");
        // resource is of AutoCloseable type,
        // so compiler checks the close() method declaration of AutoCloseable interface.
        try (AutoCloseable resource = new MyResource1()) {

        } catch (Exception e) {
            System.out.println("catch is needed, but this doesn't execute");
            throw new RuntimeException(e);
        }


        System.out.println("\n4----------------------------");

        try (MyResource2 resource = new MyResource2()) {
            resource.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getSuppressed().length);
            System.out.println(e.getSuppressed()[0].getMessage());
        }


        System.out.println("\n----------------------------");
        try (Resource r = null) {
            System.out.println("HELLO here");
        }


        System.out.println("\n----------------------------");
        String arr1[], arr2, arr3 = null; // Line n1
        arr1 = new String[2];
        arr1[0] = "A";
        arr1[1] = "B";
        // arr2 = arr3 = arr1;
        arr2 = arr3 = Arrays.toString(arr1); // Line n2
        System.out.println(arr2);
        System.out.println(String.join("-", arr2, arr3)); // Line n3


        System.out.println("\n----------------------------");
        byte[] arr = new byte[1];
        System.out.println(arr[0]);


        System.out.println("\n----------------------------");
        List<String> colors = new ArrayList<>();
        colors.add("RED");
        colors.add("GREEN");
        colors.add("BLUE");
        Iterator<String> iter = colors.iterator();
        while (iter.hasNext()) {
            // next() should be called before remove().
            System.out.println(iter.next());
            iter.remove();
        }
        System.out.println(colors.size());


        System.out.println("\n----------------------------");
        StringBuilder sb = new StringBuilder("Hello");
        List<StringBuilder> list = new ArrayList<>();
        list.add(sb);
        list.add(new StringBuilder("Hello"));
        list.add(sb);
        sb.append("World!");

        System.out.println(list);


        System.out.println("\n----------------------------");
        /*
        String is immutable, which means s.replace("l", "L");
        creates another String instance "HeLLo" but 's' still refers to "Hello" [s --> "Hello"].
         */
        String s = new String("Hello");
        List<String> list1 = new ArrayList<>();
        list1.add(s);
        list1.add(new String("Hello"));
        list1.add(s);
        s.replace("l", "L");

        System.out.println(list1);


        System.out.println("\n----------------------------");
        
        System.out.println(Integer.valueOf(2));
    }
}


class MyResource implements AutoCloseable {
    public void execute() {
        System.out.println("Executing");
    }

    @Override
    public void close() {
        System.out.println("Closing");
    }
}

class MyResource1 implements AutoCloseable {
    @Override
    public void close() {
        System.out.println("MyResource1 Closing");
    }
}


class MyResource2 implements AutoCloseable {
    @Override
    public void close() throws IOException {
        System.out.println("MyResource2 closing");
        /*
        This method throws an instance of IOException but it gets suppressed
        and an instance of SQLException is thrown.
         */
        throw new IOException("IOException");
    }

    public void execute() throws SQLException {
        throw new SQLException("MyResource2 SQLException");
    }
}


class Resource implements AutoCloseable {
    public void close() {
        System.out.println("CLOSE");
    }
}
