package Practices;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SaveGrade {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int id, English, math, literature;
        double ave;
        String name;
        char ans;
        File stud = new File("./stud.txt");
        //create the stud.txt file if it doesn't exit
        try {
            if (stud.createNewFile()) {
                System.out.println("Created the file stud.txt");
                try {
                    FileWriter writer = new FileWriter(stud, true);
                    writer.write("ID   Name   English math literature ave \n");
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("stud.txt already exists. Appending to this file.");
            }
        }catch (IOException e) {
                e.printStackTrace();
            }
        while (true){
            System.out.println("Enter student id: ");
            id = Integer.parseInt(scan.nextLine());
            System.out.println("Enter student name: ");
            name = scan.nextLine();
            System.out.println("Enter student grade for English: ");
            English = Integer.parseInt(scan.nextLine());
            System.out.println("Enter student grade for math: ");
            math = Integer.parseInt(scan.nextLine());
            System.out.println("Enter student for literature: ");
            literature = Integer.parseInt(scan.nextLine());
            // get the average grade
            ave = getAverage(English, math, literature);
            // append the result to "stud" file
            try {
                FileWriter writer = new FileWriter(stud, true);
                writer.write(id+"    "+name+"    "+English+"      "+math+"    "+literature+"      "+ave+"\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Do you like to continue to enter for next student? [y] or [n]");
            ans = scan.next().charAt(0);
            if (ans == 'n'){
                break;
            }
            scan.nextLine();
        }
    }
    private static double getAverage(int English, int math, int literature){
        double ave;
        ave = (English+math+literature)/3;
        return ave;
    }
}
