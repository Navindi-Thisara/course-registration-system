package com.crs.controller;

import com.crs.model.User;
import com.crs.service.AuthenticationService;

import java.util.Scanner;

public class AuthController {
    private final AuthenticationService authService = new AuthenticationService();
    private final Scanner scanner = new Scanner(System.in);

    public User login() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        return authService.login(username, password);
    }

    public User login(String username, String password) {
        return authService.login(username, password);
    }
}
