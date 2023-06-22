package com.eutraining.hllolluni.slide124;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsClass {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Set<Callable<Integer>> callables = new HashSet<>();

        callables.add(() -> 1);
        callables.add(() -> 2);
        callables.add(() -> 3);
        callables.add(() -> 4);
        callables.add(() -> 5);
        Integer result = executorService.invokeAny(callables);
        System.out.println("Integer called: " + result);
        executorService.shutdown();
    }
}
