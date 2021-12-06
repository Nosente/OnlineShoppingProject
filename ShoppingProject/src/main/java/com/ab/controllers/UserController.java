package com.ab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ab.entities.User;
import com.ab.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping(path = "/login", consumes = { MediaType.APPLICATION_JSON_VALUE })
    User loginUser(@Validated(User.class) @RequestBody User user) {
        System.out.println("Username: " + user.getUsername());
        System.out.println("Password: " + user.getPassword());
        User resUser = userService.authenticateUser(user.getUsername(), user.getPassword());

        if (resUser != null) {
            System.out.println("User: " + resUser.getUsername() + " have " + resUser.getOrders().size() + " orders.");
        } else {
            System.out.println("User not found.");
        }

        return resUser;
    }
}
