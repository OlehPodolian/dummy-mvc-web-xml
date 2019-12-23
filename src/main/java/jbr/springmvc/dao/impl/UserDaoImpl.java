package jbr.springmvc.dao.impl;

import jbr.springmvc.dao.UserDao;
import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserDaoImpl implements UserDao {

    private final static Map<String, User> users = new ConcurrentHashMap<>();

    public void register(User user) {
        users.put(user.getUsername(), user);
    }

    public User validateUser(Login login) {
        return Optional
                .ofNullable(users.get(login.getUsername()))
                .orElseThrow(() -> new RuntimeException(String.format("User with username: %s not found", login.getUsername())));
    }
}
