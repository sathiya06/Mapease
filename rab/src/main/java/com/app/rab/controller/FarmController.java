package com.app.rab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.rab.entity.Farm;
import com.app.rab.service.FarmService;

@RestController
@CrossOrigin
public class FarmController {

	@Autowired
	FarmService farmService;
	
    @PostMapping("/farm")
    public ResponseEntity<?> addFarm(@RequestBody Farm farm) {

        try {
            boolean isSuccessful = farmService.addFarm(farm);
            if (isSuccessful) {
                return ResponseEntity.ok("Farm Added Successfully!");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid farm details");
            }
        } catch (Exception e) {
            // Handle any authentication exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save");
        }
        
    }
    
    @GetMapping("/farm")
    public ResponseEntity<?> getFarms() {
        try {
            return ResponseEntity.ok(farmService.getAllFarm());
        } catch (Exception e) {
            // Handle any authentication exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to get");
        }
        
    }
	
}
