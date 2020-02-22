package Practices;

public class DeadLockDemo {
    private static Object lockA = new Object();
    private static Object lockB = new Object();
    public static void main(String[] args){
        new Thread(() -> {
            synchronized (lockA){
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("1-A");
                synchronized (lockB){
                    System.out.println("1-B");
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (lockB){
                System.out.println("2-B");
                synchronized (lockA){
                    System.out.println("2-A");
                }
            }
        }).start();
    }
}
