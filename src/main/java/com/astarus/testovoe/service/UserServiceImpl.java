package com.astarus.testovoe.service;

import com.astarus.testovoe.dao.UserDAO;
import com.astarus.testovoe.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Implementation of {@link UserService} interface.
 *
 * @author Rustam Mirgazizov
 * @version 1.0
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userDAO.findByEmail(email);
    }

    @Override
    public User findByUuid(String uuid) {
        return userDAO.findByUuid(uuid);
    }


}
