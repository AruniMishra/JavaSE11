package JavaFeatures;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class FileReadWrite {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("C:\\resources\\localdata\\" +
                "github\\JavaSE11\\part3-examtopics\\Examtopics\\Sample.txt");

        String readString = Files.readString(path);
        System.out.println(readString);

        String newContent = String.valueOf(LocalDateTime.now());
        Files.writeString(path, newContent);
    }
}
