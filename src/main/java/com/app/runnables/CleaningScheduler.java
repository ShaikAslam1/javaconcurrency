package com.app.runnables;

import java.io.File;

public class CleaningScheduler implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        File folder = new File("C:\\var\\log\\code");
        File[] files = folder.listFiles();

        for (File file: files) {
            if (System.currentTimeMillis() - file.lastModified() > 5*60*1000) {
                System.out.println("This file will be deleted: " + file.getName());
//                file.delete();
            }
        }
    }
}
