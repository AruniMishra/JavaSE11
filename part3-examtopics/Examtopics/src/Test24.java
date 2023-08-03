import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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


        System.out.println("\n----------------------------");
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(2);
        list2.add(1);
        list2.add(0);

        list2.forEach(System.out::println);


        System.out.println("\n----------------------------");
        /*
        Two instances of following wrapper objects, created through auto-boxing will always be same,
        if their primitive values are same:
        Boolean,
        Byte,
        Character from \u0000 to \u007f (7f equals to 127),
        Short and Integer from -128 to 127.
         */
        List<Integer> list3 = new ArrayList<Integer>();

        list3.add(27);
        list3.add(27);

        list3.add(227); // 3
        list3.add(227); // 4

        System.out.println(list3.get(0) == list3.get(1));

        /*
        For 3rd statement, list.add(227); => Auto-boxing creates an integer object for 227.
        For 4th statement, list.add(227); => As 227 is greater than 127,
        hence auto-boxing creates another integer object for 227.
         */
        System.out.println(list3.get(2) == list3.get(3));


        System.out.println("\nstrip()----------------------------");
        String str = " "; // single space
        boolean b1 = str.isEmpty();
        boolean b2 = str.isBlank();
        System.out.println(b1 + " : " + b2); // Line n1

        str.strip(); // Line n2
        /*
        `str.strip();` returns an empty string "". As String is immutable,
        hence a new String object is created and 'str' still refers to " ".
         */
        b1 = str.isEmpty();
        b2 = str.isBlank();
        System.out.println(":" + str + ":");
        System.out.println(b1 + " : " + b2); // Line n3

        System.out.println("\n----------------------------");
        /*
        Please note that Strings computed by concatenation at compile time,
        will be referred by String Pool during execution.
        Compile time String concatenation happens when both of the operands are compile time constants,
        such as literal, final variable etc.
        
        Whereas, Strings computed by concatenation at run time (if the resultant expression is
        not constant expression) are newly created and therefore distinct.
         */
        final String fName = "James";
        String lName = "Gosling";
        /*
        `fName + lName` is not a constant expression and hence the expression will be computed at run-time
         and
        the resultant String object "JamesGosling" will not be referred by String Pool.
         */
        String name1 = fName + lName;
        String name2 = fName + "Gosling";
        String name3 = "James" + "Gosling";
        System.out.println(name1 == name2);
        System.out.println(name2 == name3); // also a constant expression


        System.out.println("\n----------------------------");
        var list04 = new ArrayList<>(); // Line n1
        list04.add("TAKE");
        list04.add("THE");
        list04.add("RISK");

        // System.out.println(String.join(".", list04)); //Line n2
        list04.forEach(System.out::print);


        System.out.println("\n----------------------------");
        var list4 = new ArrayList<Integer>(); // Line n1 // Interger is must for L3
        list4.add(7);
        list4.add(14);
        list4.add(21);

        var sum = 0; // Line n2
        for (int i : list4) { // Line n3
            sum += i;
        }
        System.out.println(sum);


        System.out.println("\nlist5----------------------------");
        List list5 = new ArrayList<String>();
        list5.add(1);
        list5.add("2");
        list.forEach(System.out::print);


        System.out.println("\ncount----------------------------");
        int[][] a = {{1, 2}, {3, 4}, {5, 6}};

        long count = Stream.of(a).flatMapToInt(IntStream::of)
                .map(i -> i + 1).filter(i -> i % 2 != 0).peek(System.out::print).count();

        System.out.println(count);

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
