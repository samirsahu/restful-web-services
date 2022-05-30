package com.sam.study.restfulwebservices.users;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDAOService {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Adam", new Date()));
        users.add(new User(2, "Eve", new Date()));
        users.add(new User(3, "Jack", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User add(User user) {
        if (user.getId() == 0) {
            user.setId(users.size() + 1);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User delete(int id) {
        Iterator<User> itr = users.iterator();
        while (itr.hasNext()) {
            User curr = itr.next();
            if (curr.getId() == id) {
                itr.remove();
                return curr;
            }
        }
        return null;
    }
}
