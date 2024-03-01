package com.app.rab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.rab.entity.User;
import com.app.rab.service.UserService;
import com.app.rab.util.ResponseObject;


@RestController
@RequestMapping("/auth")
@CrossOrigin
public class UserController {
	
	@Autowired
	UserService userService;
	
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {

		
        try {
            // Add the user using your service
        	user.setRoles(1);
            boolean isRegistered = userService.addUser(user);

            if (isRegistered) {
                return ResponseEntity.ok(new ResponseObject(user.getEmail()));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
            }
        } catch (Exception e) {
            // Handle any authentication exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Authentication failed");
        }
        
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseObject> login(@RequestBody User user) {

        try {
            // Authenticate the user using your service
            boolean isAuthenticated = userService.authenticateUser(user.getEmail(), user.getPassword());

            if (isAuthenticated) {
                return ResponseEntity.ok(new ResponseObject(user.getEmail()));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseObject("Invalid username or password"));
            }
        } catch (Exception e) {
            // Handle any authentication exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseObject("Authentication failed"));
        }
    }
	
}
