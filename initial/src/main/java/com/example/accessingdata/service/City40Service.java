package com.example.accessingdata.service;

import java.util.List;

import com.example.accessingdata.mongodb.entities.City10Mongo;
import com.example.accessingdata.mongodb.entities.City40Mongo;
import com.example.accessingdata.neo4j.entities.City40;
import com.example.accessingdata.postgis.entities.City10Postgis;
import com.example.accessingdata.postgis.entities.City40Postgis;

public interface City40Service {

		List<City40> getAllOnDistanceFromBg100();
		List<City40> getAllOnDistanceFromBg200();
		List<City40> getAllOnDistanceFromBg500();
		List<City40> getEuropeRussia();
		List<City40> getEuropeCities();
		City40 save(String city, String country, double lat, double lng);
		//postgis
		List<City40Postgis> getAllOnDistanceFromBg100Postgis();
		List<City40Postgis> getAllOnDistanceFromBg200Postgis();
		List<City40Postgis> getAllOnDistanceFromBg500Postgis();
		List<City40Postgis> getEuropeRussiaPostgis();
		List<City40Postgis> getEuropeCitiesPostgis();
		City40Postgis savePostgis(String city,String country, double lat, double lng);
		
		//mongo
		List<City40Mongo> getAllOnDistanceFromBg100Mongo();
		List<City40Mongo> getAllOnDistanceFromBg200Mongo();
		List<City40Mongo> getAllOnDistanceFromBg500Mongo();
		List<City40Mongo> getEuropeRussiaMongo();
		List<City40Mongo> getEuropeCitiesMongo();
		City40Mongo saveMongo(String city, String country, double lat, double lng);
}
