package com.app.tests;

import com.app.runnables.AppThread;

public class TestThreads {

    public static void main(String[] args) {
        AppThread thread1 = new AppThread(); // NEW Thread
        AppThread thread2 = new AppThread();
        AppThread thread3 = new AppThread();

        thread1.start(); // Runnable
        thread2.start();
        thread3.start();

        // executing -> Running
        // job completed -> thread terminates or dead


    }
}
