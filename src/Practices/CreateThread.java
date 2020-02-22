package Practices;

public class CreateThread {
    public static void main(String[] args){
//        Thread1 thread1 = new Thread1();
        Thread thread2 = new Thread(new Thread2());
        Thread thread3 = new Thread(new Thread2());
//        thread1.start();
        thread2.start();
        thread3.start();
    }
}
class Thread1 extends Thread{
    @Override
    public void run(){
        for (int i=0; i<10; i++)
            System.out.println("Hello World: "+i+" "+Thread.currentThread().getName());
    }
}
class Thread2 implements Runnable{
//    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);
    private static Integer integer = 0;
    @Override
    public void run(){
        for (int i=0; i<10; i++){
//            Integer integer = threadLocal.get();
//            System.out.println("This is test: "+integer+" "+Thread.currentThread().getName());
//            integer++;
//            threadLocal.set(integer);
            System.out.println("This is test: "+integer+" "+Thread.currentThread().getName());
            integer++;
        }
    }
}
