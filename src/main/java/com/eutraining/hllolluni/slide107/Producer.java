package com.eutraining.hllolluni.slide107;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    public BlockingQueue<String> blockingQueue;

    public Producer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            blockingQueue.put("item 1");
            System.out.println("Producer put item 1");
            Thread.sleep(2000);
            blockingQueue.put("item 2");
            System.out.println("Producer put item 2");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
