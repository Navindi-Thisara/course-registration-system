package com.crs.service;

import com.crs.model.User;
import com.crs.repository.UserRepository;

public class AuthenticationService {

    private final UserRepository userRepo = new UserRepository();

    /**
     * Authenticate user by username and password.
     *
     * @param username - the username entered
     * @param password - the password entered
     * @return User object if authentication successful, null otherwise
     */
    public User login(String username, String password) {
        User user = userRepo.getUserByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful for user: " + username);
            return user;
        }

        System.out.println("Invalid username or password.");
        return null;
    }
}
