package Practices;

import java.io.*;

public class FileSteam {
    public static void main(String[] args){
        try{
            File inFile = new File("/Users/kun/IdeaProjects/basic/src/Practices/test/1.txt");
            File outFile = new File("file3.txt");
            FileInputStream fis = new FileInputStream(inFile);
            FileOutputStream fos = new FileOutputStream(outFile);
            FileReader file = new FileReader("/Users/kun/IdeaProjects/basic/src/Practices/test/1.txt");
            int c;
            while((c=fis.read()) != -1){
                fos.write(c);
                System.out.print((char)c);
            }
            int data;
            while ((data = file.read()) != -1) {
                System.out.print((char)data);
            }
            fis.close();
            fos.close();
        }
        catch (FileNotFoundException e){
            System.out.println("FileStreamsTest"+e);
        }
        catch (IOException e){
            System.err.println("FileStreamTest"+e);
        }
    }
}
