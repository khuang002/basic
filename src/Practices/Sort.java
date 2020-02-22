package Practices;

import java.util.*;

public class Sort {
    public static List<Integer> list = new ArrayList<Integer>();
    public static void main(String[] args){
        // initialize a size 100 list with random int
        Random random = new Random();
        for (int i=0; i<100; i++){
            list.add(random.nextInt(1001));
        }
        System.out.println(list);
        while (true){
            System.out.println("Please enter the action you like to perform:");
            System.out.println("Enter 1 for sorting.");
            System.out.println("Enter 2 for inserting.");
            System.out.println("Enter 3 for existing.");
            Scanner scan = new Scanner(System.in);
            int option = scan.nextInt();
            switch(option){
                case 1:
                    Collections.sort(list);
                    System.out.println(list);
                    continue;
                case 2:
                    int integer = scan.nextInt();
                    list.add(integer);
                    Collections.sort(list);
                    System.out.println(list);
                    continue;
                case 3:
                    System.out.println("System exited.");
                    return;
            }
        }
    }
}
