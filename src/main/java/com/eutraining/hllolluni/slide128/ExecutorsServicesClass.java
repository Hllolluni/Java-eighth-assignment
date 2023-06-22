package com.eutraining.hllolluni.slide128;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorsServicesClass {
    private static long startTime;
    public static void start(){
        startTime = System.nanoTime();
    }

    private static long stop() {
        return System.nanoTime() - startTime;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Callable<Integer>> callables = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        callables.add(() -> 1);
        callables.add(() -> 2);
        callables.add(() -> 3);
        callables.add(() -> 4);
        callables.add(() -> 5);
        List<Future<Integer>> futures = null;
        start();
        futures = executorService.invokeAll(callables);

        futures.stream().forEach(f -> {
            Integer i = null;
            try {
                i = f.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);
        });
        long duration = stop();
        System.out.println("Duration of tasks = " + String.valueOf(duration));
        executorService.shutdown();
    }
}
