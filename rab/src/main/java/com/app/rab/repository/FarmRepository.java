package com.app.rab.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;

import com.app.rab.entity.Farm;

public interface FarmRepository extends JpaRepository<Farm, String>{
	
	@Query("SELECT f.name FROM Farm f WHERE f.id = :farmId")
	Optional<String> findNameById(@Param("farmId") String id);
	
	@Query("SELECT f.totalAnimals FROM Farm f WHERE f.id = :farmId")
	Optional<Integer> getTotalAnimalsById(@Param("farmId") String id);
	
	@Modifying
	@Transactional
	@Query("UPDATE Farm f SET f.totalAnimals = f.totalAnimals + :newCapacity WHERE f.id = :farmId")
	int updateFarmTotalAnimalsById(@Param("farmId") String farmId, @Param("newCapacity") int newCapacity);
	
	
}
