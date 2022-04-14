package com.example.accessingdata.mongodb.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("cities40")
public class City40Mongo {

    @Id
    private String id;
    private String city;
    private String country;
    private Point geom;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Point getGeom() {
		return geom;
	}
	public void setGeom(Point geom) {
		this.geom = geom;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
    
}
