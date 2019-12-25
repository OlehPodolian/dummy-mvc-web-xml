package jbr.springmvc.service;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;

/**
 *  Defines the service facade
 */
public interface UserService {
    void register(User user);

    User validateUser(Login login);
}
