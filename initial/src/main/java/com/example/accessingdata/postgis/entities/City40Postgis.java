package com.example.accessingdata.postgis.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.locationtech.jts.geom.Point;

import lombok.Data;

@Data
@Entity
@Table(name = "cities40",schema="public")
public class City40Postgis {

	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column( name = "id")
	private String id;
	
	@Column( name = "city")
	private String city;
	
	@Column( name = "country")
	private String country;
	
	@Column(columnDefinition = "geometry")
	private Point geom;
	
	


	
	
	

	public City40Postgis(String id, String city,String country, Point geom) {
		
		this.id = id;
		this.city = city;
		this.country = country;
		this.geom = geom;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public City40Postgis() {
		
	}



	public Point getGeom() {
		return geom;
	}

	public void setGeom(Point geom) {
		this.geom = geom;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String name) {
		this.city = name;
	}

	
	
	
	
	
}
