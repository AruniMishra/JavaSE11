// Importing required packages for repeating annotation   

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Declaring repeatable annotation type
@Repeatable(Games.class)
@interface Game {
    String name();

    String day();

    String date() default "";
}

// Declaring container for repeatable annotation type
@Retention(RetentionPolicy.RUNTIME)
@interface Games {
    Game[] value(); // takes Game type
}

//----------------------------------------------------------
@interface Resource {
    String[] value();
}

//----------------------------------------------------------
@interface Authors {
    Author[] value();
}

@Repeatable(Authors.class)
@interface Author {
    int id() default 0;

    String value() default "";
}

//----------------------------------------------------------
// Repeating annotation
// You can omit the element name while specifying a value only when the name of the element is value and
// only when you are specifying just one value. In other words,
// Must use name=value format for element values because more than one values are being specified.
@Game(name = "Cricket", day = "Sunday")
@Game(name = "Hockey", day = "Friday")
@Game(name = "Football", day = "Saturday")
// @Game(name = "Football", day = null) //  The value must be a constant non-null value.


// @Resource({"Customer1", "Customer2", "Customer3", "Customer4"}) //valid, this is not part of Repeatable annotation
@Resource("Customer1") // this is also valid with array of length 1, you may omit the { }.

public class RepeatingAnnotationsExample {
    public static void main(String[] args) {
        // Getting annotation by type into an array
        Game[] game = RepeatingAnnotationsExample.class.getAnnotationsByType(Game.class);
        for (Game game2 : game) {    // Iterating values
            System.out.println(game2.name() + " on " + game2.day());
        }
    }
}

class s3T9 {
    public static void main(String[] args) {

    }


    @Author
    @Author()
    @Author("bob") // id has default, and "value" can be skipped
    @Author(id = 1)
    @Author(id = 1, value = "null")
        // @Author(id = 1, "null") // invalid
    void someMethod(int index) {
    }

    /*
    To make it easy to repeat annotations, Java does not require you to use the container annotation.
    You can just write @Author("bob") but, internally, Java converts it to @Authors(@Author("bob")).
     */
    @Authors(@Author("bob"))
    void someMethod2(int index) {
    }
}