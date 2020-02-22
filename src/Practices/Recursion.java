package Practices;

import java.util.Scanner;

public class Recursion {
    public static void main(String[] args){
        // to calculate factorial
        System.out.println("Please enter the the factorial that you like to calculate: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println("The result is: "+factorial(n));
    }
    private static int factorial(int i){
        if (i==1){
            return 1;
        } else{
          return i*factorial(i-1);
        }
    }
}
