import java.nio.file.Path;
import java.nio.file.Paths;

public class Test12 {
    public static void main(String[] args) {
        Path p1 = Paths.get("/scratch/exam/topsecret/answers");
        Path p2 = Paths.get("/scratch/exam/answers/temp.txt");
        Path p3 = Paths.get("/scratch/answers/topsecret");

        // Which two statements println ..\..\..\answers\topsecret? (Choose two.)

        System.out.println(p3.relativize(p1));
        System.out.println(p2.relativize(p3));
        System.out.println(p1.relativize(p3));
        System.out.println(p3.relativize(p2));
        System.out.println(p1.relativize(p2));
        System.out.println(p2.relativize(p1));
    }
}
