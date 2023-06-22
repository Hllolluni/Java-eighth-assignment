package com.eutraining.hllolluni.slide108;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    public BlockingQueue<String> blockingQueue;

    public Consumer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            System.out.println("Consumer processed: " + blockingQueue.take());
            System.out.println("Consumer processed: " + blockingQueue.take());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
