package com.astarus.testovoe.dao;

import com.astarus.testovoe.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role, Long> {
}
