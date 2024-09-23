package com.in28minutes.rest.webservices.restful_web_services.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;

@Component
public class UserDAOServiceMapped {

    private static final HashMap<Integer, User> userList = new HashMap<>();
    private static int userCount = 1;

    static {
        userList.put(++userCount, new User(1, "Adam", LocalDate.now().minusYears(30)));
        userList.put(++userCount, new User(2, "Eve", LocalDate.now().minusYears(30)));
        userList.put(++userCount, new User(3, "Jane", LocalDate.now().minusYears(25)));
        userList.put(++userCount, new User(4, "Abel", LocalDate.now().minusYears(20)));
        userList.put(++userCount, new User(5, "Cain", LocalDate.now().minusYears(23)));
    }

    public HashMap<Integer, User> findAll() {
        return userList;
    }

    public User save(User user) {
        user.setId(++userCount);
        userList.put(user.getId(), user);
        return user;
    }

    public User findOne(int id) {
        return userList.get(id);
    }

    public User deleteById(int id) {
        return userList.remove(id);
    }

    public User update(User user) {
        if (user.getId() <= 0) {
            return null;
        }
        userList.put(user.getId(), user);
        return user;
    }
}
