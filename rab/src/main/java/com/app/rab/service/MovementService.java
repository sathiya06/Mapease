package com.app.rab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.rab.entity.Movement;
import com.app.rab.repository.MovementRepository;

@Service
public class MovementService {

	@Autowired
	MovementRepository movementRepo;
    @Autowired
    FarmService farmService;
	
    public boolean addMovement (Movement move){
    	int originFarmCapacity = farmService.getFarmAnimalsCount(move.getOriginFarmId());
    	if (originFarmCapacity >= move.getItemsMoved()) {
    		farmService.updateFarmAnimalsCount(move.getOriginFarmId(), -move.getItemsMoved());
    		farmService.updateFarmAnimalsCount(move.getDestinationFarmId(), move.getItemsMoved());
    		movementRepo.save(move);
            return true;
    	}
    	return false;
    }
    
    public List<Movement> getAllMovement(){
    	List<Movement> allMovements =  movementRepo.findAll();
    	for(Movement movement: allMovements) {
    		movement.setOriginFarmId(farmService.getFarmName(movement.getOriginFarmId()));
    		movement.setDestinationFarmId(farmService.getFarmName(movement.getDestinationFarmId()));
    	}
    	return allMovements;
    }
	
}
