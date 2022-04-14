package com.example.accessingdata.controller;

import java.util.List;

import org.neo4j.driver.types.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.accessingdata.mongodb.entities.City10Mongo;
import com.example.accessingdata.mongodb.entities.City5Mongo;
import com.example.accessingdata.neo4j.entities.City5;
import com.example.accessingdata.postgis.entities.City10Postgis;
import com.example.accessingdata.postgis.entities.City5Postgis;
import com.example.accessingdata.service.City5Service;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/cities5")
public class City5Controller {

	@Autowired
	private City5Service service;
	
     
     @GetMapping("/neo4j/bg100")
	 public List<City5> getAllOnDistanceFromBg100() {
      return service.getAllOnDistanceFromBg100();
  }
     
     @GetMapping("/neo4j/bg200")
	 public List<City5> getAllOnDistanceFromBg200() {
      return service.getAllOnDistanceFromBg200();
  }
     
     @GetMapping("/neo4j/bg500")
	 public List<City5> getAllOnDistanceFromBg500() {
      return service.getAllOnDistanceFromBg500();
  }
	
	
	@GetMapping("/neo4j/russia")
	 public List<City5> getEuropeRussia() {
     return service.getEuropeRussia();
	}
     
     @GetMapping("/neo4j/europe")
     public List<City5> getEuropeCities(){
    	 return service.getEuropeCities();
     }
     
     @PostMapping("/neo4j/save")
     public City5 save(@RequestParam  String city, @RequestParam String country, @RequestParam Double lat, @RequestParam Double lng) {
    	 
    	 return service.saveNeo4j(city, country, lat, lng);
     }
     
     @GetMapping("/neo4j/all")
     public List<City5> findAll(){
    	 return service.findAll();
     }
     
   //postgis
     @GetMapping("/postgis/bg100")
	 public List<City5Postgis> getAllOnDistanceFromBg100Postgis() {
      return service.getAllOnDistanceFromBg100Postgis();
  }
     
     @GetMapping("/postgis/bg200")
	 public List<City5Postgis> getAllOnDistanceFromBg200Postgis() {
      return service.getAllOnDistanceFromBg200Postgis();
  }
     
     @GetMapping("/postgis/bg500")
	 public List<City5Postgis> getAllOnDistanceFromBg500Postgis() {
      return service.getAllOnDistanceFromBg500Postgis();
  }
     
     @GetMapping("/postgis/russia")
	 public List<City5Postgis> getEuropeRussiaPostgis() {
     return service.getEuropeRussiaPostgis();
	}
     
     @GetMapping("/postgis/europe")
     public List<City5Postgis> getEuropeCitiesPostgis(){
    	 return service.getEuropeCitiesPostgis();
     }
     
     @PostMapping("/postgis/save")
     public City5Postgis savePostgis(@RequestParam  String city, @RequestParam  String country, @RequestParam Double lat, @RequestParam Double lng) {
    	 
    	 return service.savePostgis(city, country, lat, lng);
     }
     
     //mongo
     @GetMapping("/mongo/bg100")
	 public List<City5Mongo> getAllOnDistanceFromBg100Mongo() {
      return service.getAllOnDistanceFromBg100Mongo();
  }
     
     @GetMapping("/mongo/bg200")
	 public List<City5Mongo> getAllOnDistanceFromBg200Mongo() {
      return service.getAllOnDistanceFromBg200Mongo();
  }
     
     @GetMapping("/mongo/bg500")
	 public List<City5Mongo> getAllOnDistanceFromBg500Mongo() {
      return service.getAllOnDistanceFromBg500Mongo();
  }
     
    @GetMapping("/mongo/russia")
	 public List<City5Mongo> getEuropeRussiaMongo() {
    	 return service.getEuropeRussiaMongo();
	}
     
    @GetMapping("/mongo/europe")
    public List<City5Mongo> getEuropeCitiesMongo(){
   	 return service.getEuropeCitiesMongo();
    }
    
    @PostMapping("/mongo/save")
    public City5Mongo saveMongo(@RequestParam  String city, @RequestParam  String country, @RequestParam Double lat, @RequestParam Double lng) {
   	 
   	 return service.saveMongo(city, country, lat, lng);
    }
 
 
}

