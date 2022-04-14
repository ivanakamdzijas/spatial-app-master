package com.example.accessingdata.neo4j.entities;



import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.neo4j.driver.Value;


import org.springframework.boot.context.properties.bind.Name;
import org.springframework.data.geo.Point;
import org.springframework.data.neo4j.core.convert.ConvertWith;
import org.springframework.data.neo4j.core.schema.GeneratedValue;

@Node
public class City10 {

  @Id @GeneratedValue private Long id;

  private String city;
  
  private String country;
  
 private Point coordinate;
  public City10() {
    // Empty constructor required as of Neo4j API 2.0.5
  };

  public City10(String city,String country, Point coordinate) {
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