package com.app.runnables;

import java.io.*;

public class AppThread extends Thread {
    @Override
    public void run() {
        try(BufferedReader reader = new BufferedReader(new FileReader(
                "C:\\Users\\asshaik\\Documents\\Cisco_AnyConnect_VPN_Statistics.txt"))) {
            String line = null;
            while ((line=reader.readLine())!=null) {
                System.out.println(Thread.currentThread().getName()+ " Reading the line: " + line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
