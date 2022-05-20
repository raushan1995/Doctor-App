package com.cg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="patient")
public class Patient {
	@Id
	private int id;
	private String name;
	private String address;
	private String problem;
	
	
	//parameterized constructor
	public Patient(int id, String name, String address, String problem) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.problem = problem;
		
	}
	
	//default constructor
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//getter and setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	
	
	//ToString 
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", address=" + address + ", problem=" + problem + "]";
	}
	
		
	

}
