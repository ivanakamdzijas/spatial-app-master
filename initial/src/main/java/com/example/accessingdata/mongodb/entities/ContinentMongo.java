package com.example.accessingdata.mongodb.entities;

import org.locationtech.jts.geom.MultiPolygon;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonMultiPolygon;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("continents")
public class ContinentMongo {
	
	@Id
    private String id;
	private GeoJsonMultiPolygon geometry;
	private Property properties;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public GeoJsonMultiPolygon getGeometry() {
		return geometry;
	}
	public void setGeometry(GeoJsonMultiPolygon geometry) {
		this.geometry = geometry;
	}
	public Property getProperties() {
		return properties;
	}
	public void setProperties(Property properties) {
		this.properties = properties;
	}
	public ContinentMongo(String id, GeoJsonMultiPolygon geometry, Property properties) {
		super();
		this.id = id;
		this.geometry = geometry;
		this.properties = properties;
	}
	public ContinentMongo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
