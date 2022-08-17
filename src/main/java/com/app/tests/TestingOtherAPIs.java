package com.app.tests;

import com.app.runnables.LoggingProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestingOtherAPIs {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Callable<Boolean>> callables = new ArrayList<>();
        try {
            callables.add(new LoggingProcessor());
            callables.add(new LoggingProcessor());
            callables.add(new LoggingProcessor());
            callables.add(new LoggingProcessor());
            callables.add(new LoggingProcessor());
            callables.add(new LoggingProcessor());
            callables.add(new LoggingProcessor());

            List<Future<Boolean>> futures = null;

            futures = executorService.invokeAll(callables);
            for (Future<Boolean> future : futures) {
                System.out.println("Operation result: " + future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println(executorService.invokeAny(callables));
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();

        try {
            System.out.println("service shutdown?: " + executorService.awaitTermination(30, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            throw new RuntimeException(e);
        }

    }
}
