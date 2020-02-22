package Practices;

import java.util.concurrent.ArrayBlockingQueue;

public class ABQDemo {
    private static ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args){
        Thread thread1 = new Thread(() -> {
            for (int i=1; i<=10; i++){
                arrayBlockingQueue.add(i);
            }
        });
        thread1.start();
        try{
            thread1.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        new Thread(() -> {
            if(!arrayBlockingQueue.offer(11)){
                System.out.println("Failed to insert 11.");
            }
            try{
                arrayBlockingQueue.put(11);
                System.out.println("test");
                arrayBlockingQueue.put(12);
                System.out.println("test2");
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }).start();
        Thread thread2 = new Thread(() -> {
            Integer element;
            System.out.println("Start to exit:");
            while ((element = arrayBlockingQueue.poll()) != null){
                System.out.print("\t"+element);
            }
        });
        thread2.start();
    }
}
