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


        Arrays.stream(" : ".split(":", 0)).forEach(t -> System.out.println("~" + t + "~"));

    }
}


class Test56 {
    public static void main(String[] args) {
        String[] arr = {"1st", "2nd", "3rd", "4th", "5th"};
        String place = "faraway";

        /*
        "alaska".indexOf("a", 1) returns 2
        "alaska".indexOf("a", 2) returns 2
        "alaska".indexOf("a", 3) returns 5
         */
        System.out.println(place.indexOf("a", 3));
        System.out.println(arr[place.indexOf("a", 3)]); // Line n1
    }
}


class Test43 {
    public static void main(String[] args) {
        String str = " "; // single space
        boolean b1 = str.isEmpty();
        boolean b2 = str.isBlank();
        System.out.println(b1 + " : " + b2); // Line n1


        // str.strip();` returns an empty string "". As String is immutable,
        // hence a new String object is created and 'str' still refers to " ".
        str.strip(); // Line n2
        b1 = str.isEmpty();
        b2 = str.isBlank();
        System.out.println(b1 + " : " + b2); // Line n3
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


class Test65 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("HavePatience");
        sb.delete(4, 5).insert(4, " P").toString().toUpperCase();
        System.out.println(sb);
    }
}


class Test66 {
    public static void main(String[] args) {
        String str = "Game on"; //Line n1
        StringBuilder sb = new StringBuilder(str); //Line n2

        System.out.println(str.contentEquals(sb)); //Line n3
        // System.out.println(sb.contentEquals(str)); //Line n4
        System.out.println(sb.equals(str)); //Line n5
        System.out.println(str.equals(sb)); //Line n6
    }
}

class Test68 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Breathe Deeply");
        /*
        toString() method defined in StringBuilder class doesn't use String literal rather uses the constructor
        of String class to create the instance of String class.
        So both 'str1' and 'str2' refer to different String instances even though their contents are same.
        str1 == str2 returns false.
         */
        String str1 = sb.toString();
        String str2 = "Breathe Deeply";

        System.out.println(str1 == str2);
    }
}
