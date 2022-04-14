package com.example.accessingdata.mongodb.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Property {
	
	@Id
    private int id;
	private String CONTINENT;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCONTINENT() {
		return CONTINENT;
	}
	public void setCONTINENT(String cONTINENT) {
		CONTINENT = cONTINENT;
	}
	
	
	

}
