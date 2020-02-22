package Practices;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    private static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args){
        Thread thread1 = new Thread(() -> {
            lock.lock();
            try{
                System.out.println("First lock.");
            } finally {
                lock.unlock();
                System.out.println("First unlock.");
            }
        });
        thread1.start();
        Thread thread2 = new Thread(() -> {
            lock.lock();
            try{
                System.out.println("Second lock.");
            } finally {
                lock.unlock();
                System.out.println("Second unlock.");
            }
        });
        thread2.start();
    }
}
