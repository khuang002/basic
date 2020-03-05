package Practices;

import java.util.Scanner;

public class LotteryTest {
    public static void main(String[] args){
        System.out.println("Please enter the number of lottery that you need:");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        Lottery lottery = new Lottery();
        lottery.generate(number);
    }
}
