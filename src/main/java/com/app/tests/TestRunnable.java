package com.app.tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TestRunnable {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            try(BufferedReader reader = new BufferedReader(new FileReader(
                    "C:\\Users\\asshaik\\Documents\\Cisco_AnyConnect_VPN_Statistics.txt"))) {
                String line = null;
                while ((line=reader.readLine())!=null) {
                    System.out.println(Thread.currentThread().getName()+ " Reading the line: " + line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

//        Thread thread = new Thread(runnable);
//        thread.start();

        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(runnable);
    }
}
