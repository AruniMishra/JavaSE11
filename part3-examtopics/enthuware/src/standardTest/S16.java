package standardTest;

import java.util.List;

interface ReaderT {
    default void read(BookTest b) {
        System.out.println("--default--");
    }

    void unread(BookTest b);
}

public class S16 {
}

class BookTest {
    private String title;
    private String genre;

    public BookTest(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public static void main(String[] args) {
        List<BookTest> books = List.of(
                new BookTest("Gone with the wind", "Fiction"),
                new BookTest("Bourne Ultimatum", "Thriller"),
                new BookTest("The Client", "Thriller")
        );

        ReaderT r = b -> {
            System.out.println("Reading book " + b.getTitle());
        };
        books.forEach(x -> r.read(x));
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
    // accessors not shown

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
