package com.eutraining.hllolluni.slide90;

import java.util.concurrent.locks.ReentrantLock;

public class Deadlock {
    private final ReentrantLock lock1 = new ReentrantLock();
    private final ReentrantLock lock2 = new ReentrantLock();

    public void performAction1() {
        lock1.lock();
        try {
            System.out.println("performAction-1 start");
            try {
                lock2.lock();
            } finally {
                lock2.unlock();
            }
            System.out.println("performAction-1 end");
        }finally {
            lock1.unlock();
        }
    }

    public void performAction2() {
        lock2.lock();
        try {
            System.out.println("performAction-2 start");
            try {
                lock1.lock();
            } finally {
                lock1.unlock();
            }
            System.out.println("performAction-2 end");
        }finally {
            lock2.unlock();
        }
    }

    public static void main(String[] args) {
        Deadlock deadlock = new Deadlock();

        Thread thread1 = new Thread(() -> deadlock.performAction1());
        Thread thread2 = new Thread(() -> deadlock.performAction2());

        thread1.start();
        thread2.start();
    }
}
