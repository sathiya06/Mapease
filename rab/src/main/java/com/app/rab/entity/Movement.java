package com.app.rab.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Movement {
	@Id
	@GeneratedValue
	private Integer movementId;
	private String company;
	private String reason;
	private String originFarmId;
	private String destinationFarmId;
	private String species;
	private Integer itemsMoved;
	private String movementDate;
	
	public Movement() {
		super();
	}
	
	public Movement(String company, String reason, String originFarmId, String destinationFarmId, String species,
			Integer itemsMoved, String movementDate) {
		super();
		this.company = company;
		this.reason = reason;
		this.originFarmId = originFarmId;
		this.destinationFarmId = destinationFarmId;
		this.species = species;
		this.itemsMoved = itemsMoved;
		this.movementDate = movementDate;
	}
	
	public Movement(Integer movementId, String company, String reason, String originFarmId, String destinationFarmId,
			String species, Integer itemsMoved, String movementDate) {
		super();
		this.movementId = movementId;
		this.company = company;
		this.reason = reason;
		this.originFarmId = originFarmId;
		this.destinationFarmId = destinationFarmId;
		this.species = species;
		this.itemsMoved = itemsMoved;
		this.movementDate = movementDate;
	}

	public Integer getMovementId() {
		return movementId;
	}
	public void setMovementId(Integer movementId) {
		this.movementId = movementId;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getOriginFarmId() {
		return originFarmId;
	}
	public void setOriginFarmId(String originFarmId) {
		this.originFarmId = originFarmId;
	}
	public String getDestinationFarmId() {
		return destinationFarmId;
	}
	public void setDestinationFarmId(String destinationFarmId) {
		this.destinationFarmId = destinationFarmId;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public Integer getItemsMoved() {
		return itemsMoved;
	}
	public void setItemsMoved(Integer itemsMoved) {
		this.itemsMoved = itemsMoved;
	}
	public String getMovementDate() {
		return movementDate;
	}
	public void setMovementDate(String movementDate) {
		this.movementDate = movementDate;
	}
	
}
