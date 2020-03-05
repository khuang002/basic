package Practices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lottery {
    private final int head = 35;
    private final int tail = 12;

    public Lottery() {
    }
    public void generate(String groupNum){
        List<String> lotteryPart1 = new ArrayList<String>();
        List<String> lotteryPart2 = new ArrayList<String>();
        int groupNumber = Integer.parseInt(groupNum);
        for (int i=0; i<groupNumber; i++){
            StringBuilder stringBuilder = new StringBuilder();
            lotteryPart1 = getLotteryNumber(35, 5);
            lotteryPart2 = getLotteryNumber(12, 2);
            for(int j=0; j<lotteryPart1.size(); j++){
                stringBuilder.append(lotteryPart1.get(j));
//                System.out.println("test:"+j);
            }
            for(int k=0; k<lotteryPart2.size(); k++){
                stringBuilder.append(lotteryPart2.get(k));
//                System.out.println("test2:"+k);
            }
            System.out.println("Lottery "+(i+1)+": "+stringBuilder.toString());
        }
    }

    public List<String> getLotteryNumber(int length, int num){
        List<String> list = new ArrayList<String>();
        List<String> lottery = new ArrayList<String>();
        for (int i=1; i<length+1; i++){
            if(i<10){
                list.add("0"+i+" ");
            }
            else{
                list.add(i+" ");
            }
        }
        int roundIndex = 0;
        String lotteryNumber = "";
        Random random = new Random();
        for(int i=0; i<num; i++){
            roundIndex = random.nextInt(list.size());
            lotteryNumber = list.get(roundIndex);
            lottery.add(lotteryNumber);
            list.remove(roundIndex);
        }
        Collections.sort(lottery);
//        System.out.println("lottery is"+lottery.toString());
        return lottery;
    }
}
