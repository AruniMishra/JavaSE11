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