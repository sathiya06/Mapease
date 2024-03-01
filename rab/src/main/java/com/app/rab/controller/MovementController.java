package com.app.rab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.rab.entity.Movement;
import com.app.rab.service.MovementService;


@RestController
@CrossOrigin
public class MovementController {
	@Autowired
	MovementService movementService;
    @PostMapping("/movement")
    public ResponseEntity<?> addMovement(@RequestBody Movement movement) {

        try {
            boolean isSuccessful = movementService.addMovement(movement);
            if (isSuccessful) {
                return ResponseEntity.ok("Movement Added Successfully!");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid farm details");
            }
        } catch (Exception e) {
            // Handle any authentication exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save");
        }
        
    }
    
    @GetMapping("/movement")
    public ResponseEntity<?> getMovements() {
        try {
            return ResponseEntity.ok(movementService.getAllMovement());
        } catch (Exception e) {
            // Handle any authentication exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to get");
        }
        
    }
	
}
