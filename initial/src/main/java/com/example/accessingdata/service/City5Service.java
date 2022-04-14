package com.example.accessingdata.service;

import java.util.List;

import org.springframework.data.geo.Point;

import com.example.accessingdata.mongodb.entities.City10Mongo;
import com.example.accessingdata.mongodb.entities.City5Mongo;
import com.example.accessingdata.neo4j.entities.City5;
import com.example.accessingdata.postgis.entities.City10Postgis;
import com.example.accessingdata.postgis.entities.City5Postgis;

public interface City5Service {
	//city5
		List<City5> getAllOnDistanceFromBg100();
		List<City5> getAllOnDistanceFromBg200();
		List<City5> getAllOnDistanceFromBg500();
		List<City5> getEuropeRussia();
		List<City5> getEuropeCities();
		City5 saveNeo4j(String city,String country, double lat, double lng);
		
		List<City5> findAll();
		
		//postgis
		List<City5Postgis> getAllOnDistanceFromBg100Postgis();
		List<City5Postgis> getAllOnDistanceFromBg200Postgis();
		List<City5Postgis> getAllOnDistanceFromBg500Postgis();
		List<City5Postgis> getEuropeRussiaPostgis();
		List<City5Postgis> getEuropeCitiesPostgis();
		City5Postgis savePostgis(String city, String country,double lat, double lng);
		
		//mongo
		List<City5Mongo> getAllOnDistanceFromBg100Mongo();
		List<City5Mongo> getAllOnDistanceFromBg200Mongo();
		List<City5Mongo> getAllOnDistanceFromBg500Mongo();
		List<City5Mongo> getEuropeRussiaMongo();
		List<City5Mongo> getEuropeCitiesMongo();
		City5Mongo saveMongo(String city, String country, double lat, double lng);
}
