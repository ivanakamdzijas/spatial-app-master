package com.example.accessingdata.neo4j.entities;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Convert;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.geo.Point;
import org.springframework.data.neo4j.core.schema.GeneratedValue;

@Node("City5")
public class City5 {

  @Id @GeneratedValue private Long id;

  private String city;
  
  private String country;
  
  
  
  

  private Point coordinate;
  
  public City5() {
    // Empty constructor required as of Neo4j API 2.0.5
  };

  public City5(String city, String country, Point  coordinate) {
    this.city = city;
    this.country = country;
    this.coordinate =  coordinate;
  }

  
 

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public String toString() {

    return this.city + ' ' + this.coordinate; 
  }

  public String getCity() {
    return city;
  }
  
  public  Point  getCoordinates() {
	  return  this.coordinate;
  }
  
  public void setCoordinate(Point coordinate) {
		this.coordinate =  coordinate;
	}


  public void setId(Long id) {
	this.id = id;
}


public void setCity(String name ) {
    this.city = name;
  }
}