package com.astarus.testovoe.dao;

import com.astarus.testovoe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findByUuid(String uuid);


}
