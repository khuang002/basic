package Practices;

import java.util.ArrayList;
import java.util.List;

//with n player in a loop, every 3rd player will be removed, and output the last player left
public class Game {
    public static void main(String[] args){
        int n = 20;
        List<Integer> player = new ArrayList<Integer>();
        for (int i=1; i<=n; i++){
            player.add(i);
        }
        int offset = 0;
        while (player.size() >1){
            int currentSize = player.size();
            System.out.println("The size of player list is: "+currentSize);
            for(int i =(3-offset-1); i<currentSize;i+=3){
                player.set(i,0);
            }
            player.removeIf(s -> s.equals(0));
            //setting offset whenever a loop ends
            offset = (currentSize+offset)%3;
        }
        if (player.size() ==1) {
            System.out.println("The last player remained is " + player.get(0));
        } else{
            System.out.println("Unexpected error occurred.");
        }
    }
}
