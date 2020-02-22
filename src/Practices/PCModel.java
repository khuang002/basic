package Practices;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class PCModel {
    private static LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

    public static void main(String[] args){
        Thread provider = new Thread(() -> {
            Random random = new Random();
            for (int j=1; j<5; j++){
                try{
                    int i = random.nextInt();
                    queue.put(i);
                    System.out.println("Produced data: "+i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread consumer = new Thread(() -> {
            Integer data;
            for (int j=1; j<5; j++){
                try{
                    data = queue.take();
                    System.out.println("Consumed data: "+data);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        provider.start();
        consumer.start();
    }
}
