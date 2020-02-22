package Practices;

import java.io.File;

public class ReadDir {
    public static void main(String[] args){
        readDir(new File("/Users/kun/IdeaProjects/basic/src"), "");
    }

    static void readDir(File file, String s){
        if (file == null){
            return;
        }
        if (file.isDirectory()){
            System.out.println(s + file.getName());
            File[] files;
            if((files = file.listFiles()) != null){
                s = s + "\t";
                for (File file1:files){
                    readDir(file1, s);
                }
            }
        }else{
            System.out.println(s + file.getName());
        }
    }
}
