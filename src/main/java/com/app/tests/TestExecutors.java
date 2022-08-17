package com.app.tests;

import com.app.dao.UserDao;
import com.app.runnables.UserProcessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExecutors {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<String> users = getUsersFromFile("C:\\Users\\asshaik\\Documents\\new_users.txt");
        UserDao userDao = new UserDao();

        for (String user: users) {
            executorService.submit(new UserProcessor(user, userDao));
        }
        executorService.shutdown();
        System.out.println("Main execution over");
    }

    public static List<String> getUsersFromFile(String fileName) {
        List<String> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                users.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}
