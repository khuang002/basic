package Practices;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
    private static ReentrantLock lock = new ReentrantLock();
    private static int count = 0;
    private static Condition condition = lock.newCondition();

    public static void main(String[] args){
        Thread threadA = new Thread(() -> {
            lock.lock();
            try{
                while (true){
                    if (count == 9){
                        break;
                    }
                    if (count %3 == 0){
                        System.out.println("A");
                        count++;
                        condition.signalAll();
                    } else{
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }  finally {
                lock.unlock();
            }
        });
        Thread threadB = new Thread(() -> {
            lock.lock();
            try{
                while (true){
                    if (count == 9){
                        break;
                    }
                    if (count %3 == 1){
                        System.out.println("B");
                        count++;
                        condition.signalAll();
                    } else{
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }  finally {
                lock.unlock();
            }
        });
        Thread threadC = new Thread(() -> {
            lock.lock();
            try{
                while (true){
                    if (count == 9){
                        break;
                    }
                    if (count %3 == 2){
                        System.out.println("C");
                        count++;
                        condition.signalAll();
                    } else{
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }  finally {
                lock.unlock();
            }
        });
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
