package com.example.accessingdata.service;

import java.util.List;

import org.springframework.data.geo.Point;

import com.example.accessingdata.mongodb.entities.City10Mongo;
import com.example.accessingdata.mongodb.entities.ContinentMongo;
import com.example.accessingdata.neo4j.entities.City10;
import com.example.accessingdata.postgis.entities.City10Postgis;








public interface City10Service {
	//city10
		List<City10> getAllOnDistanceFromBg100();
		List<City10> getAllOnDistanceFromBg200();
		List<City10> getAllOnDistanceFromBg500();
		List<City10> getEuropeRussia();
		List<City10> getEuropeCities();
		City10 save(String city,String country, double lat, double lng);
		
		//postgis
		List<City10Postgis> getAllOnDistanceFromBg100Postgis();
		List<City10Postgis> getAllOnDistanceFromBg200Postgis();
		List<City10Postgis> getAllOnDistanceFromBg500Postgis();
		List<City10Postgis> getEuropeRussiaPostgis();
		List<City10Postgis> getEuropeCitiesPostgis();
		City10Postgis savePostgis(String city, String country, double lat, double lng);
		
		//mongo
		List<City10Mongo> getAllOnDistanceFromBg100Mongo();
		List<City10Mongo> getAllOnDistanceFromBg200Mongo();
		List<City10Mongo> getAllOnDistanceFromBg500Mongo();
		List<City10Mongo> getEuropeRussiaMongo();
		List<City10Mongo> getEuropeCitiesMongo();
		City10Mongo saveMongo(String city, String country, double lat, double lng);
		
}
