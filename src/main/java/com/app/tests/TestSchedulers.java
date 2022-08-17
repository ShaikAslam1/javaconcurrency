package com.app.tests;

import com.app.runnables.CleaningScheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestSchedulers {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
//        scheduledExecutorService.schedule(new CleaningScheduler(), 5, TimeUnit.SECONDS);
//        scheduledExecutorService.scheduleAtFixedRate(
//                new CleaningScheduler(), 5, 4, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleWithFixedDelay(
                new CleaningScheduler(), 5, 4, TimeUnit.SECONDS);
        // First task of initial delay of 5 seconds, 2 seconds for execution,
        // after that 4 second of waiting time
        // then next scheduler will execute.

    }
}
