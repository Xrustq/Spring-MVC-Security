package com.astarus.testovoe.service;

import com.astarus.testovoe.model.User;

/**
 * Service class for {@link com.astarus.testovoe.model.User}
 *
 * @author Rustam Mirgazizov
 * @version 1.0
 */

public interface UserService {

    void save(User user);

    User findByEmail(String email);

    User findByUuid(String uuid);


}
