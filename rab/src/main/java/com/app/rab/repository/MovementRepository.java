package com.app.rab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.rab.entity.Movement;

public interface MovementRepository extends JpaRepository<Movement, Integer>{

}
