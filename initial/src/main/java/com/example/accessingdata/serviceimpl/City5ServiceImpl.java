package com.example.accessingdata.serviceimpl;


import java.util.ArrayList;
import java.util.List;

import org.locationtech.jts.geom.Envelope;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.PrecisionModel;
import org.neo4j.driver.Values;
import org.neo4j.driver.internal.value.PointValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;


import org.springframework.stereotype.Service;

import com.example.accessingdata.mongodb.entities.City10Mongo;
import com.example.accessingdata.mongodb.entities.City5Mongo;
import com.example.accessingdata.mongodb.entities.ContinentMongo;
import com.example.accessingdata.mongodb.repo.City10MongoRepo;
import com.example.accessingdata.mongodb.repo.City5MongoRepo;
import com.example.accessingdata.mongodb.repo.ContinentMongoRepo;
import com.example.accessingdata.neo4j.entities.City5;
import com.example.accessingdata.neo4j.repo.City5Repository;
import com.example.accessingdata.postgis.entities.City10Postgis;
import com.example.accessingdata.postgis.entities.City5Postgis;
import com.example.accessingdata.postgis.repo.City10PostgisRepo;
import com.example.accessingdata.postgis.repo.City5PostgisRepo;
import com.example.accessingdata.service.City5Service;

@Service
public class City5ServiceImpl implements City5Service {
	@Autowired
	private City5Repository cityRepo;
	
	@Autowired
	private City5PostgisRepo cityRepoPostgis;

	@Autowired
	private City5MongoRepo cityRepoMongo;
	
	@Autowired
	private ContinentMongoRepo continentRepoMongo;

	
	/*@Override
	public List<City5> getAllOnDistanceFromBg100(){
		return cityRepo.getAllOnDistanceFromBg100();
	}
	
	@Override
	public List<City5> getAllOnDistanceFromBg200(){
		return cityRepo.getAllOnDistanceFromBg200();
	}

	@Override
	public List<City5> getAllOnDistanceFromBg500(){
		return cityRepo.getAllOnDistanceFromBg500();
	}
	*/
	
	@Override
	public List<City5> getAllOnDistanceFromBg100(){
		/*City5 bg = cityRepo.findByCityAndCountry("Belgrade", "Serbia");
		
		return cityRepo.findByCoordinateNear( bg.getCoordinates(), new Distance(100, Metrics.KILOMETERS));*/
		return cityRepo.getAllOnDistanceFromBg100();
	}
	
	@Override
	public List<City5> getAllOnDistanceFromBg200(){
		/*City5 bg = cityRepo.findByCityAndCountry("Belgrade", "Serbia");
		
		return cityRepo.findByCoordinateNear( bg.getCoordinates(), new Distance(200, Metrics.KILOMETERS));*/
		return cityRepo.getAllOnDistanceFromBg200();
	}
	
	@Override
	public List<City5> getAllOnDistanceFromBg500(){
		/*City5 bg = cityRepo.findByCityAndCountry("Belgrade", "Serbia");
		return  cityRepo.findByCoordinateNear( bg.getCoordinates(), new Distance(500, Metrics.KILOMETERS));*/
		return cityRepo.getAllOnDistanceFromBg500();
	}

	

	public List<City5> getEuropeRussia(){
		return cityRepo.getEuropeRussia();
	}

	
	public List<City5> getEuropeCities(){
		return cityRepo.getEuropeCities();
	}
	
	/*public City5 save(String city, double lat, double lng) {
		//Point p = new Point(lat, lng);
		return cityRepo.save(city,  Values.point(4326, lat, lng));
	}*/
	
	public City5 saveNeo4j(String city, String country, double lat, double lng) {
		Point p = new Point(lat, lng);
		City5 cityNeo4j = new City5();
	   	cityNeo4j.setCity(city);
	   	cityNeo4j.setCountry(country);
	   	cityNeo4j.setCoordinate( p);
		return cityRepo.save(cityNeo4j);
	}
	
	public List<City5> findAll(){
		return cityRepo.findAll();
	}
	
	
	//postgis
	
	@Override
	public List<City5Postgis> getAllOnDistanceFromBg100Postgis(){
		return cityRepoPostgis.getAllOnDistanceFromBg100();
	}
	@Override
	public List<City5Postgis> getAllOnDistanceFromBg200Postgis(){
		return cityRepoPostgis.getAllOnDistanceFromBg200();
	}
	@Override
	public List<City5Postgis> getAllOnDistanceFromBg500Postgis(){
		return cityRepoPostgis.getAllOnDistanceFromBg500();
	}
	public List<City5Postgis> getEuropeRussiaPostgis(){
		return cityRepoPostgis.getEuropeRussia();
	}

		
	public List<City5Postgis> getEuropeCitiesPostgis(){
		return cityRepoPostgis.getEuropeCities();
	}
		/*
	public City5Postgis savePostgis(String city, double lat, double lng) {
		//Point p = new Point(lat, lng);
		return cityRepoPostgis.save(city, lat,lng);
	}*/
	
	public City5Postgis savePostgis(String city, String country, double lat, double lng) {
		GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
		org.locationtech.jts.geom.Point p = geometryFactory.createPoint(new org.locationtech.jts.geom.Coordinate(lng,lat));
		City5Postgis cityPostgis = new City5Postgis();
	   	cityPostgis.setCity(city);
	   	cityPostgis.setCountry(country);
	   	cityPostgis.setGeom(p);
		return cityRepoPostgis.save(cityPostgis);
	}
	
	


	//mongo
	
		@Override
		public List<City5Mongo> getAllOnDistanceFromBg100Mongo(){
			City5Mongo bg = cityRepoMongo.findByCityAndCountry("Belgrade", "Serbia");
			System.out.print(bg.getGeom());
			return cityRepoMongo.getAllOnDistanceFromBg(bg.getGeom().getX(), bg.getGeom().getY(), 100000);
			
		}
		
		
		
		@Override
		public List<City5Mongo> getAllOnDistanceFromBg200Mongo(){
			City5Mongo bg = cityRepoMongo.findByCityAndCountry("Belgrade", "Serbia");
			//return cityRepoMongo.findByGeomNear((GeoJsonPoint) bg.getGeom(), new Distance(200, Metrics.KILOMETERS));
			System.out.print(bg.getGeom());
			return cityRepoMongo.getAllOnDistanceFromBg(bg.getGeom().getX(), bg.getGeom().getY(), 200000);
		
		}
		
		@Override
		public List<City5Mongo> getAllOnDistanceFromBg500Mongo(){
			City5Mongo bg = cityRepoMongo.findByCityAndCountry("Belgrade", "Serbia");
			System.out.print(bg.getGeom());
			return cityRepoMongo.getAllOnDistanceFromBg(bg.getGeom().getX(), bg.getGeom().getY(), 500000);
		}
		
		
		public List<City5Mongo> getEuropeRussiaMongo(){
			ContinentMongo europe = continentRepoMongo.getEuropePoints();
			return cityRepoMongo.getEuropeRussia(europe.getGeometry());
		}
		
		
		
		public List<City5Mongo> getEuropeCitiesMongo(){
			ContinentMongo europe = continentRepoMongo.getEuropePoints();
			return cityRepoMongo.getEuropeCities(europe.getGeometry());
		}
		
		public City5Mongo saveMongo(String city, String country, double lat, double lng) {
			//GeoJsonPoint p = new GeoJsonPoint(lng, lat);
			GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
			org.locationtech.jts.geom.Point p = geometryFactory.createPoint(new org.locationtech.jts.geom.Coordinate(lng,lat));
			
			City5Mongo cityMongo = new City5Mongo();
		   	cityMongo.setCity(city);
		   	cityMongo.setCountry(country);
		   	cityMongo.setGeom(p);
			return cityRepoMongo.save(cityMongo);
		}

		

		
		
		
}



