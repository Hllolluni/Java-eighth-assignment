package com.eutraining.hllolluni.slide97;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockTimeOutClassExample {

    Random random = new Random(System.currentTimeMillis());

    ReentrantLock lock1 = new ReentrantLock();
    ReentrantLock lock2 = new ReentrantLock();

    public void performAction1() throws InterruptedException {
        lock1.tryLock(1000, TimeUnit.MILLISECONDS);
        System.out.println("performAction-1 start");
        try {
            lock2.tryLock(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock1.unlock();
        }
        System.out.println("performAction-1 end");
        Thread.sleep(random.nextInt());
    }

    public void performAction2() throws InterruptedException {
        lock2.tryLock(1000, TimeUnit.MILLISECONDS);
        System.out.println("performAction-2 start");
        try {
            lock1.tryLock(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("performAction-2 end");
        Thread.sleep(random.nextInt());
    }

    public static void main(String[] args) throws InterruptedException {
        LockTimeOutClassExample deadlock = new LockTimeOutClassExample();

        Thread thread1 = new Thread(() -> {
            while (true) {
                try {
                    deadlock.performAction1();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            while (true) {
                try {
                    deadlock.performAction2();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
