import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;





public class StreamGrouping2 {

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book(1, "There is a hippy on the highway", "Thriller", "James Hadley Chase"),
                new Book(2, "Coffin from Hongkong", "Thriller", "James Hadley Chase"),
                new Book(3, "The Client", "Thriller", "John Grisham"),
                new Book(4, "Gone with the wind", "Fiction", "Margaret Mitchell"));
        Map<String, Map<String, List<Book>>> classified = null;
        classified = books.stream().collect(Collectors.groupingBy(

                // this line is also a fine alternative
                // x->x.getGenre(), Collectors.groupingBy(x->x.getAuthor())

                Book::getGenre, Collectors.groupingBy(Book::getAuthor)));
        // System.out.println(classified);

        classified.entrySet().stream().forEach(System.out::println);
    }
}


class Book {
    private int id;
    private String title;
    private String genre;
    private String author;
    private double price;

    public Book(int id, String title, String genre, String author) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

// constructors and accessors not shown
}





interface House {
    public default void lockTheGates() {
        System.out.println("Locking House");
    }
}

interface Office {
    public void lockTheGates();
}

class HomeOffice implements House, Office {
    @Override
    public void lockTheGates() {
        House.super.lockTheGates();
    } // 1
}


interface Bozo {
    int type = 0;

    public void jump();
}

class Type1Bozo implements Bozo {
    public Type1Bozo() {
        // type = 1;
    }

    public static void main(String[] args) {
        Bozo b = new Type1Bozo();
        b.jump();
    }

    public void jump() {
        System.out.println("jumping..." + type);
    }
}