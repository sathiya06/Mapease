package com.app.rab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.rab.entity.User;
import com.app.rab.repository.UserRepository;
import com.app.rab.util.PasswordEncoder;


@Service
public class UserService {
	
	@Autowired
    UserRepository userRepo;
	@Autowired
	PasswordEncoder passwordEncoder;
	
    public boolean addUser(User user){
        user.setPassword(passwordEncoder.encodePassword(user.getPassword()));
        userRepo.save(user);
        return true;
    }
    
    public boolean authenticateUser(String email, String password) {
    	User user = loadUserByEmail(email);
    	if (user != null && passwordEncoder.verifyPassword(password, user.getPassword())) {
    		return true;
    	}
    	return false;
    }
    
    public User loadUserByEmail(String email) {
        User user = userRepo.findByEmail(email).orElse(null);
        return user;
    }
    
    public List<User> getAllUser(){
        return userRepo.findAll();
    }
    
}
