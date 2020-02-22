package Practices;
import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args){
        File f1 = new File("/Users/kun/IdeaProjects/basic/src/Practices/test/1.txt");
        File f2 = new File("/Users/kun/IdeaProjects/basic/src/Practices/test/","2.txt");
        File f3 = new File("/Users/kun/IdeaProjects/basic/src/Practices"+File.separator+"test");
        File f4 = new File(f3,"3.txt");

        try{
            System.out.println(f1);
            System.out.println(f2);
            System.out.println(f3);
            System.out.println(f4);
            System.out.println(f1.createNewFile());
            System.out.println(f2.createNewFile());
            System.out.println(f3.delete());
        }
        catch (IOException e){
            e.printStackTrace();
        }
        File[] files = File.listRoots();
        for (File file:files){
            System.out.println(file);
            if(file.length()>0){
                System.out.println("000");
                String[] filenames = file.list();
                for (String filename:filenames){
                    System.out.println(filename);
                }
                System.out.println(".2");
            }
            System.out.println(".1");
        }
    }
}
