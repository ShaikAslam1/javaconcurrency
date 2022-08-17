package com.app.runnables;

import com.app.beans.User;
import com.app.dao.UserDao;

import java.util.StringTokenizer;
import java.util.concurrent.Callable;

public class UserProcessor implements Callable<Integer> {

    private final String userRecord;
    private final UserDao userDao;

    public UserProcessor(String userRecord, UserDao userDao) {
        this.userRecord = userRecord;
        this.userDao = userDao;
    }

    @Override
    public Integer call() throws Exception {
        int rows = 0;
        System.out.println(Thread.currentThread().getName() + " processing record for: " + userRecord);
        StringTokenizer stringTokenizer = new StringTokenizer(userRecord, ",");
        User user = null;
        while (stringTokenizer.hasMoreTokens()) {
            user = new User();
            user.setEmailAddress(stringTokenizer.nextToken());
            user.setName(stringTokenizer.nextToken());
            user.setId(Integer.parseInt(stringTokenizer.nextToken()));

            rows = userDao.saveUser(user);
        }
        return rows;
    }
}
