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
				new Farm("464KBIF", "my_farm_name_R", "733, fake Street", "Sac City", "IA", 50583, 46.07227, -93.91527, 1000),
				
				new Farm("225ZGAJ", "my_farm_name_J", "154, fake Street", "Bethany", "MO", 64424, 41.90538, -97.56184, 1000),
				new Farm("180UCBY", "my_farm_name_B", "707, fake Street", "Clay Center", "NE", 68933, 42.10786, -101.59227, 1000),
				new Farm("582PHBR", "my_farm_name_E", "217, fake Street", "Albion", "IN", 46701, 42.97002, -88.94877, 1000),
				new Farm("360FDCZ", "my_farm_name_I", "308, fake Street", "Hampton", "IA", 50441, 44.33265, -96.68334, 1000),
				new Farm("733DTME", "my_farm_name_C", "026, fake Street", "Shelby", "IA", 51570, 43.07102,	-99.01941, 1000),
				new Farm("715ELOH", "my_farm_name_H", "813, fake Street", "Edison", "NE", 68936, 41.87143,	-103.33981, 1000),
				new Farm("325UDIW", "my_farm_name_B", "582, fake Street", "Pittsfield", "IL", 62363, 41.0829,	-94.3104, 1000),
				new Farm("671HMJV", "my_farm_name_J", "501, fake Street", "Leopold", "IN", 47551, 39.67177,	-90.09549, 1000),
				
				new Farm("477EDVX", "my_farm_name_K", "028, fake Street", "Battle Creek", "IA", 51006, 45.88508, -94.49498, 1000),
				new Farm("611ULSK", "my_farm_name_M", "112, fake Street", "Havelock", "IA", 50574, 46.36619,	-93.63721, 1000),
				new Farm("027RDXY", "my_farm_name_S", "012, fake Street", "Wawaka", "IN", 46794, 45.03986,	-84.37985, 1000),
				new Farm("220FAPG", "my_farm_name_S", "834, fake Street", "Fonda", "IN", 50540, 46.22264,	-93.76849, 1000),
				new Farm("554DGRT", "my_farm_name_O", "058, fake Street", "Ute", "IA", 51060, 45.53324,	-94.59197, 1000),
				new Farm("853OBOV", "my_farm_name_R", "550, fake Street", "Edison", "NE", 68936, 43.80099,	-98.72475, 1000),
				new Farm("453YIAE", "my_farm_name_Q", "846, fake Street", "Altona", "IL", 61414, 44.67619,	-89.01749, 1000),
				new Farm("730AOYL", "my_farm_name_T", "613, fake Street", "Flat Rock", "IL", 62427, 42.391528,	-86.477042, 1000)
				
				
				));
		
		//adding all movement data
		movementRepo.saveAll(Arrays.asList(
				new Movement("Mypigcompany", "FINISH TO FINISH", "376DQUF", "778EYUX", "Swine", 1000, "18-04-2011"),
				new Movement("Mypigcompany", "SOW TO FINISH", "088WKFT", "464KBIF", "Swine", 1000, "18-04-2011")
				));
		
      System.out.println("----------All Data saved into Database----------------------");
   
	}

}
