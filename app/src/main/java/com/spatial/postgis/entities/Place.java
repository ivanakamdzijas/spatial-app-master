package com.spatial.postgis.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.locationtech.jts.geom.Point;




import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Data
@Entity
@Table(name = "places")
public class Place {

	@Id
	@Column( name = "place_id")
	private long id;
	
	@Column( name = "city")
	private String city;
	
	@Column( name = "lat")
	private double lat;
	
	@Column( name = "lng")
	private double lng;
	
	@Column( name = "country")
	private String country;
	
	@Column( name = "iso2")
	private String iso2;
	
	@Column( name = "admin_name")
	private String admin_name;


	@Column( name = "capital")
	private String capital;
	
	
	@Column(columnDefinition = "geometry")
	private Point geom;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
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


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getIso2() {
		return iso2;
	}


	public void setIso2(String iso2) {
		this.iso2 = iso2;
	}


	public String getAdmin_name() {
		return admin_name;
	}


	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}


	public String getCapital() {
		return capital;
	}


	public void setCapital(String capital) {
		this.capital = capital;
	}


	public Point getGeom() {
		return geom;
	}


	public void setGeom(Point geom) {
		this.geom = geom;
	}
	
	
}
