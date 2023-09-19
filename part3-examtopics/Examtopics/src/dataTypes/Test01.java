package dataTypes;

import java.util.Arrays;

public class Test01 {
}


class Test49 {
    public static void main(String[] args) {
        long x = 7, y = 200;
        System.out.println(String.valueOf(x + y));

        String s = "*";
        s.repeat(4);
        System.out.println(s);


        String str = "BEVERAGE";
        // str.split("E", 3); returns ["B","V","RAGE"] as pattern is applied 3 - 1 = 2 times.
        String[] arr = str.split("E", 3);
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println(String.join(".", arr));

    }
}


class Test56 {
    public static void main(String[] args) {
        String[] arr = {"1st", "2nd", "3rd", "4th", "5th"};
        String place = "faraway";
        System.out.println(place.indexOf("a", 3));
        System.out.println(arr[place.indexOf("a", 3)]); // Line n1
    }
}


class Test43 {
    public static void main(String[] args) {
        String str = " "; //single space
        boolean b1 = str.isEmpty();
        boolean b2 = str.isBlank();
        System.out.println(b1 + " : " + b2); //Line n1


        // str.strip();` returns an empty string "". As String is immutable,
        // hence a new String object is created and 'str' still refers to " ".
        str.strip(); //Line n2
        b1 = str.isEmpty();
        b2 = str.isBlank();
        System.out.println(b1 + " : " + b2); //Line n3
    }
}


class Test37 {
    public static void main(String[] args) {
        String str = "Think"; // Line n3
        change(str); // Line n4
        System.out.println(str); // Line n5
    }

    private static void change(String s) {
        s = s.concat("_Twice"); // Line n9
        System.out.println(s);
    }
}
