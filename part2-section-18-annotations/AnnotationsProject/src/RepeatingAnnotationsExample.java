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

@interface Resource {
    String[] value();
}

// Repeating annotation
@Game(name = "Cricket", day = "Sunday")
@Game(name = "Hockey", day = "Friday")
@Game(name = "Football", day = "Saturday")
@Resource({"Customer1", "Customer2", "Customer3", "Customer4"}) // this is not part of Repeatable annotation

public class RepeatingAnnotationsExample {
    public static void main(String[] args) {
        // Getting annotation by type into an array
        Game[] game = RepeatingAnnotationsExample.class.getAnnotationsByType(Game.class);
        for (Game game2 : game) {    // Iterating values
            System.out.println(game2.name() + " on " + game2.day());
        }
    }
}