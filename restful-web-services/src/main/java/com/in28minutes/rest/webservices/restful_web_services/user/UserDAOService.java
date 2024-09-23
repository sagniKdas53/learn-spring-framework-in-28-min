package com.in28minutes.rest.webservices.restful_web_services.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDAOService {

    private static final List<User> userList = new ArrayList<>();
    private static int userCount = 0;

    static {
        userList.add(new User(++userCount, "Adam", LocalDate.now().minusYears(30)));
        userList.add(new User(++userCount, "Eve", LocalDate.now().minusYears(30)));
        userList.add(new User(++userCount, "Jane", LocalDate.now().minusYears(25)));
        userList.add(new User(++userCount, "Abel", LocalDate.now().minusYears(20)));
        userList.add(new User(++userCount, "Cain", LocalDate.now().minusYears(23)));
    }

    public List<User> findAll() {
        return userList;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return userList.stream().filter(predicate).findFirst().orElse(null);
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++userCount);
        }
        userList.add(user);
        return user;
    }

    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        userList.removeIf(predicate);
    }
}
