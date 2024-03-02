package com.app.rab.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    	
    	HashMap<String, String> response = new HashMap<>();

        try {
            boolean isSuccessful = farmService.addFarm(farm);
            if (isSuccessful) {
                return ResponseEntity.ok(response.put("success", "Farm Added Successfully!"));
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response.put("error", "Invalid farm details"));
            }
        } catch (Exception e) {
            // Handle any authentication exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response.put("error", "Failed to save"));
        }
        
    }
    
    class DeleteFarmParam{
    	private String id;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public DeleteFarmParam(String id) {
			super();
			this.id = id;
		}

		public DeleteFarmParam() {
			super();
		}
    	
    }
    
    @DeleteMapping("/farm")
    public ResponseEntity<?> deleteFarm(@RequestBody String id) {
    	System.out.print(id);
        try {
            boolean isSuccessful = farmService.deleteFarm(id);
            if (isSuccessful) {
                return ResponseEntity.ok("Farm Deleted Successfully!");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid farm Id");
            }
        } catch (Exception e) {
            // Handle any authentication exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete");
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
