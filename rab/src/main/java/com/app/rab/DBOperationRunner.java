package com.app.rab;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.rab.entity.Farm;
import com.app.rab.entity.Movement;
import com.app.rab.entity.User;
import com.app.rab.repository.FarmRepository;
import com.app.rab.repository.MovementRepository;
import com.app.rab.service.FarmService;
import com.app.rab.service.UserService;



@Component
public class DBOperationRunner implements CommandLineRunner{

	
    @Autowired
    UserService userService;
    @Autowired
    MovementRepository movementRepo;
    @Autowired
    FarmRepository farmRepo;
    @Autowired
    FarmService farmService;
    
	@Override
	public void run(String... args) throws Exception {
		
		// Adding a admin user and normal user
		userService.addUser(new User( "demo", "demo@gmail.com", 0, "pass"));
		userService.addUser(new User( "demo1", "demo1@gmail.com", 1, "pass"));
		
		//adding all farm data
		farmRepo.saveAll(Arrays.asList(
				new Farm("376DQUF", "my_farm_name_B", "163, fake Street", "Carthage", "IL", 62321, 42.04312, -94.73784, 1000),
				new Farm("778EYUX", "my_farm_name_L", "743, fake Street", "Sheffield", "IA", 50475, 46.38174, -92.14026, 1000),
				new Farm("088WKFT", "my_farm_name_C", "677, fake Street", "Edison", "NE", 68936, 41.99145, -103.34611, 1000),
				new Farm("464KBIF", "my_farm_name_R", "733, fake Street", "Sac City", "IA", 50583, 46.07227, -93.91527, 1000)
				));
		
		//adding all movement data
		movementRepo.saveAll(Arrays.asList(
				new Movement("Mypigcompany", "FINISH TO FINISH", "376DQUF", "778EYUX", "Swine", 1000, "18-04-2011"),
				new Movement("Mypigcompany", "SOW TO FINISH", "088WKFT", "464KBIF", "Swine", 1000, "18-04-2011")
				));
		
      System.out.println("----------All Data saved into Database----------------------");
   
	}

}
