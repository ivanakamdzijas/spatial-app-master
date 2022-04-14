package com.spatial.postgis.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.locationtech.jts.geom.Point;

import lombok.Data;

@Data
@Entity
@Table(name = "destinations")
public class Destination {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column( name = "destination_id")
	private long id;
	
	@Column( name = "name")
	private String name;
	
	@Column( name = "lat")
	private double lat;
	
	@Column( name = "lon")
	private double lng;
	
	@Column(columnDefinition = "geometry")
	private Point geom;
	
	


	
	
	

	public Destination(long id, String name, double lat, double lng, Point geom) {
		
		this.id = id;
		this.name = name;
		this.lat = lat;
		this.lng = lng;
		this.geom = geom;
	}



	public Destination() {
		
	}



	public Point getGeom() {
		return geom;
	}

	public void setGeom(Point geom) {
		this.geom = geom;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}
	
	
	
}
