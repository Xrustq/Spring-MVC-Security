package com.astarus.testovoe.service;

/**
 * Service for security.
 *
 * @author Rustam Mirgazizov
 * @version 1.0
 */

public interface SecurityService {

    String findLoggedInEmail();

    void autoLogin(String email, String password);
}
