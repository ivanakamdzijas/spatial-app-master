package com.example.accessingdata.serviceimpl;

import java.util.List;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.PrecisionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import com.example.accessingdata.controller.City40Controller;
import com.example.accessingdata.mongodb.entities.City10Mongo;
import com.example.accessingdata.mongodb.entities.City40Mongo;
import com.example.accessingdata.mongodb.entities.ContinentMongo;
import com.example.accessingdata.mongodb.repo.City10MongoRepo;
import com.example.accessingdata.mongodb.repo.City40MongoRepo;
import com.example.accessingdata.mongodb.repo.ContinentMongoRepo;
import com.example.accessingdata.neo4j.entities.City10;
import com.example.accessingdata.neo4j.entities.City40;
import com.example.accessingdata.neo4j.repo.City40Repository;
import com.example.accessingdata.postgis.entities.City10Postgis;
import com.example.accessingdata.postgis.entities.City40Postgis;
import com.example.accessingdata.postgis.repo.City10PostgisRepo;
import com.example.accessingdata.postgis.repo.City40PostgisRepo;
import com.example.accessingdata.service.City40Service;

@Service
public class City40ServiceImpl implements City40Service {
	@Autowired
	private City40Repository cityRepo;
	
	@Autowired
	private City40PostgisRepo cityRepoPostgis;
	
	@Autowired
	private City40MongoRepo cityRepoMongo;
	
	@Autowired
	private ContinentMongoRepo continentRepoMongo;

	
	@Override
	public List<City40> getAllOnDistanceFromBg100(){
		return cityRepo.getAllOnDistanceFromBg100();
	}
	
	@Override
	public List<City40> getAllOnDistanceFromBg200(){
		return cityRepo.getAllOnDistanceFromBg200();
	}
	@Override
	public List<City40> getAllOnDistanceFromBg500(){
		return cityRepo.getAllOnDistanceFromBg500();
	}

	public List<City40> getEuropeRussia(){
		return cityRepo.getEuropeRussia();
	}

	
	public List<City40> getEuropeCities(){
		return cityRepo.getEuropeCities();
	}
	
	/*public City40 save(String city, double lat, double lng) {
		Point p = new Point(lat, lng);
		return cityRepo.save(city, p);
	}*/
	
	public City40 save(String city, String country, double lat, double lng) {
		Point p = new Point(lat, lng);
		City40 cityNeo4j = new City40();
		cityNeo4j.setCity(city);
		cityNeo4j.setCountry(country);
		cityNeo4j.setCoordinates(p);
		return cityRepo.save(cityNeo4j);
	}
	
	//postgis
	
		@Override
		public List<City40Postgis> getAllOnDistanceFromBg100Postgis(){
			return cityRepoPostgis.getAllOnDistanceFromBg100();
		}
		@Override
		public List<City40Postgis> getAllOnDistanceFromBg200Postgis(){
			return cityRepoPostgis.getAllOnDistanceFromBg200();
		}
		@Override
		public List<City40Postgis> getAllOnDistanceFromBg500Postgis(){
			return cityRepoPostgis.getAllOnDistanceFromBg500();
		}
		public List<City40Postgis> getEuropeRussiaPostgis(){
			return cityRepoPostgis.getEuropeRussia();
		}

		
		public List<City40Postgis> getEuropeCitiesPostgis(){
			return cityRepoPostgis.getEuropeCities();
		}
		/*
		public City40Postgis savePostgis(String city, double lat, double lng) {
			//Point p = new Point(lat, lng);
			return cityRepoPostgis.save(city, lat,lng);
		}*/
		
		public City40Postgis savePostgis(String city, String country, double lat, double lng) {
			GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
			org.locationtech.jts.geom.Point p = geometryFactory.createPoint(new Coordinate(lng,lat));
			City40Postgis cityPostgis = new City40Postgis();
		   	cityPostgis.setCity(city);
		   	cityPostgis.setCountry(country);
		   	cityPostgis.setGeom(p);
			return cityRepoPostgis.save(cityPostgis);
		}

		//mongo
		
			@Override
			public List<City40Mongo> getAllOnDistanceFromBg100Mongo(){
				City40Mongo bg = cityRepoMongo.findByCityAndCountry("Belgrade", "Serbia");
				return cityRepoMongo.findByGeomNear(bg.getGeom(), new Distance(100, Metrics.KILOMETERS));
			}
			
			@Override
			public List<City40Mongo> getAllOnDistanceFromBg200Mongo(){
				City40Mongo bg = cityRepoMongo.findByCityAndCountry("Belgrade", "Serbia");
				return cityRepoMongo.findByGeomNear(bg.getGeom(), new Distance(200, Metrics.KILOMETERS));
			}
			
			@Override
			public List<City40Mongo> getAllOnDistanceFromBg500Mongo(){
				City40Mongo bg = cityRepoMongo.findByCityAndCountry("Belgrade", "Serbia");
				return cityRepoMongo.findByGeomNear(bg.getGeom(), new Distance(500, Metrics.KILOMETERS));
			}

			
			
			public List<City40Mongo> getEuropeRussiaMongo(){
				ContinentMongo europe = continentRepoMongo.getEuropePoints();
				return cityRepoMongo.getEuropeRussia(europe.getGeometry());
			}
			
			
			
			public List<City40Mongo> getEuropeCitiesMongo(){
				ContinentMongo europe = continentRepoMongo.getEuropePoints();
				//return cityRepoMongo.findByGeomWithin(europe.getGeometry());
				return cityRepoMongo.getEuropeCities(europe.getGeometry());
			}
			
			public City40Mongo saveMongo(String city, String country, double lat, double lng) {
				Point p = new Point(lng, lat);
				City40Mongo cityMongo = new City40Mongo();
			   	cityMongo.setCity(city);
			   	cityMongo.setCountry(country);
			   	cityMongo.setGeom(p);
				return cityRepoMongo.save(cityMongo);
			}
			
			
	}


