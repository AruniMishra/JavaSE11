/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 7: Java Stream API
Topic:  Stream.Builder
*/

import java.util.stream.Stream;

public class BuilderExtras {
    public static void main(String[] args) {

        // Builder is mutable object, so like a StringBuilder,
        // you do not need to self reference, but you can...
        Stream.Builder<String> builder = Stream.builder();
        builder = builder.add("a");  // ok but not necessary
        builder.add("b");  // this works
        builder.add("c");
        // builder.add(10);

        Stream<String> stream = builder.build();
        // builder.add("d"); // IllegalStateException
        stream.forEach(System.out::println);


        // Using a raw Builder..
        Stream.Builder builder2 = Stream.builder();
        builder2.add("a");
        builder2.add(10);
        Stream<String> s2 = builder2.build();
        // s2.forEach(System.out::println); // runtime: ClassCastException


        // however below runs successfully
        // Using a raw Builder with chained methods
        Stream.builder().add("a").add(10).build().forEach(System.out::println);


        // Typing builder() method returns correctly typed Stream: compiler error
        // Stream.<String>builder().add("a").add(10).build().forEach(System.out::println);

        // Typing builder() method returns correctly typed Stream
        Stream.<String>builder().add("a").add("b").build().forEach(System.out::println);


        // runtime: ClassCastException
        Stream.Builder builder3 = Stream.<String>builder();
        builder3.add("a");
        builder3.add(new Object());
        Stream<String> s3 = builder3.build();
        // s3.forEach(System.out::println);

    }
}

