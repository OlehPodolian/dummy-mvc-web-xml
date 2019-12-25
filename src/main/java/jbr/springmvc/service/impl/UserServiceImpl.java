package jbr.springmvc.service.impl;

import jbr.springmvc.dao.UserDao;
import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;
import jbr.springmvc.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void register(User user) {
        userDao.register(user);

    }

    public User validateUser(Login login) {
        return userDao.validateUser(login);
    }
}
