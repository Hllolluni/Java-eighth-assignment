package com.eutraining.hllolluni.slide148;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTestClass {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(20);
        int value = atomicInteger.get();
        System.out.println(atomicInteger);
        System.out.println(value);
        System.out.println("---------------------------------------");
        System.out.println("Compare and set:");
        atomicInteger.compareAndSet(40, 30);
        System.out.println(atomicInteger.get());
        atomicInteger.compareAndSet(20, 30);
        System.out.println(atomicInteger.get());
    }
}
