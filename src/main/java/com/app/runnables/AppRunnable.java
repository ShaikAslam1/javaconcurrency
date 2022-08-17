package com.app.runnables;

public class AppRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("run");
    }

    public static void main(String[] args) {
        AppRunnable runnable = new AppRunnable();
    }
}
