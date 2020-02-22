package Practices;

import java.util.Scanner;

public class AssessGrades {
    public static void main(String[] args){
        while (true){
            System.out.println("Please input grade: ");
            Scanner input = new Scanner(System.in);
            int point = input.nextInt();
            while (point < 0 || point >100){
                System.out.println("Please enter a correct grade.");
                point = input.nextInt();
            }
            char grade = point>=90? 'A':(point>=60? 'B':'C');
            System.out.println("The students grade is: "+grade);
        }
    }
}
