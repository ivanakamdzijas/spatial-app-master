package com.example.accessingdata.neo4j.entities;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import org.neo4j.driver.internal.InternalPoint2D;

import org.springframework.boot.context.properties.bind.Name;
import org.springframework.data.geo.Point;
import org.springframework.data.neo4j.core.convert.ConvertWith;
import org.springframework.data.neo4j.core.schema.GeneratedValue;

@Node
public class City20 {

  @Id @GeneratedValue private Long id;

  private String city;
  private String country;

  
 private Point coordinate;
  public City20() {
    // Empty constructor 
  };

  public City20(String city,  String country, Point coordinate) {
    this.city = city;
    this.country = country;
    this.coordinate= coordinate;
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
  
  public void setCoordinates(Point coordinate) {
	  this.coordinate=coordinate;
  }

  public void setCity(String name ) {
    this.city = name;
  }
}