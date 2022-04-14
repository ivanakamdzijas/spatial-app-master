package com.example.accessingdata.service;

import java.util.List;

import com.example.accessingdata.mongodb.entities.City10Mongo;
import com.example.accessingdata.mongodb.entities.City20Mongo;
import com.example.accessingdata.neo4j.entities.City20;
import com.example.accessingdata.postgis.entities.City10Postgis;
import com.example.accessingdata.postgis.entities.City20Postgis;

public interface City20Service {
	
		List<City20> getAllOnDistanceFromBg100();
		List<City20> getAllOnDistanceFromBg200();
		List<City20> getAllOnDistanceFromBg500();
		List<City20> getEuropeRussia();
		List<City20> getEuropeCities();
		City20 save(String city, String country, double lat, double lng);
		
		//postgis
		List<City20Postgis> getAllOnDistanceFromBg100Postgis();
		List<City20Postgis> getAllOnDistanceFromBg200Postgis();
		List<City20Postgis> getAllOnDistanceFromBg500Postgis();
		List<City20Postgis> getEuropeRussiaPostgis();
		List<City20Postgis> getEuropeCitiesPostgis();
		City20Postgis savePostgis(String city,String country, double lat, double lng);
		
		//mongo
		List<City20Mongo> getAllOnDistanceFromBg100Mongo();
		List<City20Mongo> getAllOnDistanceFromBg200Mongo();
		List<City20Mongo> getAllOnDistanceFromBg500Mongo();
		List<City20Mongo> getEuropeRussiaMongo();
		List<City20Mongo> getEuropeCitiesMongo();
		City20Mongo saveMongo(String city, String country, double lat, double lng);
}

