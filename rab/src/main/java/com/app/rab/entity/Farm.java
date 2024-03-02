package com.app.rab.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Farm {
    @Id
    private String id;
    private String name;
    private String address;
    private String city;
    private String state;
    private Integer postalCode;
    private Double latitude;
    private Double longitude;
    private Integer totalAnimals;
    
	public Farm() {
		super();
	}

	public Farm(String id, String name, String address, String city, String state, Integer postalCode, Double latitude,
			Double longitude, Integer totalAnimals) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.totalAnimals = totalAnimals;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Integer getTotalAnimals() {
		return totalAnimals;
	}
	public void setTotalAnimals(Integer totalAnimals) {
		this.totalAnimals = totalAnimals;
	}

	@Override
	public String toString() {
		return "Farm [id=" + id + ", name=" + name + ", address=" + address + ", city=" + city + ", state=" + state
				+ ", postalCode=" + postalCode + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", totalAnimals=" + totalAnimals + "]";
	}
    

}
