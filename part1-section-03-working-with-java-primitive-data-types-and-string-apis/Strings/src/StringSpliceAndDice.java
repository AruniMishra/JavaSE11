
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;

public class StringSpliceAndDice {
    public static void main(String[] args) {
        // Set some data up
        String[] wordArray = new String[]{"Hello", "World", "How", "are", "you"};
        ArrayList<String> wordList = new ArrayList<>(Arrays.asList(wordArray));

        // ---- public String concat(String str)
        String sentence = "";

        for (String word : wordArray) {
            sentence += word + " ";
        }
        System.out.println("Our sentence using concat: " + sentence);

        // You can use join with a variable list of CharSequence elements ..
        sentence = String.join(" ", "Hello", "World", "How", "are", "you");
        System.out.println("Our sentence using join, variable list of String: " + sentence);

        // You can use join with Iterable elements, such as array of String
        sentence = String.join(" ", wordArray);
        System.out.println("Our sentence using join, Array of String: " + sentence);

        // You can use join with Iterable elements, such as List of String
        sentence = String.join(" ", wordList);
        System.out.println("Our sentence using join, ArrayList of String: " + sentence);


        // StringJoiner was added in Java 8 as well..
        StringJoiner sj = new StringJoiner(" ");
        for (String word : wordArray) sj.add(word);
        sentence = sj.toString();
        System.out.println("Our sentence using StringJoiner: " + sj);


        // Following code demonstrates: public String[] split(String regex)
        // First make sure sentence is delimited by a space to test
        sentence = String.join(" ", wordList);
        // now split using space
        String[] splitWords = sentence.split(" ");
        System.out.println(Arrays.toString(splitWords));


        //first create a sentence with multiple white space
        sentence = String.join("\u0020\t\u0020\n", wordList);
        System.out.println("Our sentence with spaces and tabs and carriage returns: " + sentence);

        // regular expression matches any white space not just \u0020
        splitWords = sentence.split("\\s+");
        System.out.println(Arrays.toString(splitWords));

        sentence = String.join(" ", wordList);  // reset sentence value
        // The second parameter is a limit, We tell the method we only want
        // 2 array elements as the result...
        splitWords = sentence.split(" ", 2);
        System.out.println(Arrays.toString(splitWords));
    }
}