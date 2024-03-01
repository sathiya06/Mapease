package com.app.rab.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="_user")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String email;
    private Integer roles;
    private String password;
    
    
    
	public User() {
		super();
	}
	public User(Integer id, String name, String email, Integer roles, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.roles = roles;
		this.password = password;
	}
	
	public User( String name, String email, Integer roles, String password) {
		super();
		this.name = name;
		this.email = email;
		this.roles = roles;
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getRoles() {
		return roles;
	}
	public void setRoles(Integer roles) {
		this.roles = roles;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", roles=" + roles + ", password=" + password + "]";
	}
    
    
}
