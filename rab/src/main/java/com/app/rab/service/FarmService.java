package com.app.rab.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.rab.entity.Farm;
import com.app.rab.repository.FarmRepository;

@Service
public class FarmService {
	
	@Autowired
    FarmRepository farmRepo;
	
    public boolean addFarm (Farm farm){
        farmRepo.save(farm);
        return true;
    }
    
    public List<Farm> getAllFarm(){
        return farmRepo.findAll();
    }
    
    public String getFarmName(String id){
    	Optional<String> farmName = farmRepo.findNameById(id);
    	if (farmName.isPresent()) {
    	    return farmName.get();
    	} else {
    	    return "";
    	}
    }
    
    public Integer getFarmAnimalsCount(String id){
    	Optional<Integer> farmAnimalsCount = farmRepo.getTotalAnimalsById(id);
    	if (farmAnimalsCount.isPresent()) {
    	    return farmAnimalsCount.get();
    	} else {
    	    return 0;
    	}
    }
    
    public boolean updateFarmAnimalsCount(String id, int newCapacity) {
    	int rowsUpdated = farmRepo.updateFarmTotalAnimalsById(id, newCapacity);
    	return rowsUpdated > 0;
    }
	
}
