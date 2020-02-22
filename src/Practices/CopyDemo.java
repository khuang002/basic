package Practices;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyDemo {
    public static void main(String[] args){
        try {
            Files.copy(Paths.get("/Users/kun/IdeaProjects/basic/src/Practices/test/1.txt"), Paths.get("/Users/kun/IdeaProjects/basic/src/Practices/test/2.txt"), StandardCopyOption.REPLACE_EXISTING);
            Files.move(Paths.get("/Users/kun/IdeaProjects/basic/file3.txt"), Paths.get("/Users/kun/IdeaProjects/basic/src/Practices/test/3.txt"), StandardCopyOption.ATOMIC_MOVE);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
