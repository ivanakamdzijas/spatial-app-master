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

import com.example.accessingdata.mongodb.entities.City10Mongo;
import com.example.accessingdata.mongodb.entities.City20Mongo;
import com.example.accessingdata.mongodb.entities.ContinentMongo;
import com.example.accessingdata.mongodb.repo.City10MongoRepo;
import com.example.accessingdata.mongodb.repo.City20MongoRepo;
import com.example.accessingdata.mongodb.repo.ContinentMongoRepo;
import com.example.accessingdata.neo4j.entities.City10;
import com.example.accessingdata.neo4j.entities.City20;
import com.example.accessingdata.neo4j.repo.City20Repository;
import com.example.accessingdata.postgis.entities.City10Postgis;
import com.example.accessingdata.postgis.entities.City20Postgis;
import com.example.accessingdata.postgis.repo.City10PostgisRepo;
import com.example.accessingdata.postgis.repo.City20PostgisRepo;
import com.example.accessingdata.service.City20Service;

@Service
public class City20ServiceImpl implements City20Service {
	@Autowired
	private City20Repository cityRepo;

	@Autowired
	private City20PostgisRepo cityRepoPostgis;

	@Autowired
	private City20MongoRepo cityRepoMongo;
	
	@Autowired
	private ContinentMongoRepo continentRepoMongo;
	

	
	@Override
	public List<City20> getAllOnDistanceFromBg100(){
		return cityRepo.getAllOnDistanceFromBg100();
	}
	@Override
	public List<City20> getAllOnDistanceFromBg200(){
		return cityRepo.getAllOnDistanceFromBg200();
	}
	@Override
	public List<City20> getAllOnDistanceFromBg500(){
		return cityRepo.getAllOnDistanceFromBg500();
	}

	public List<City20> getEuropeRussia(){
		return cityRepo.getEuropeRussia();
	}

	
	public List<City20> getEuropeCities(){
		return cityRepo.getEuropeCities();
	}
	
	/*public City20 save(String city, double lat, double lng) {
		Point p = new Point(lat, lng);
		return cityRepo.save(city, p);
	}*/
	
	public City20 save(String city, String country, double lat, double lng) {
		Point p = new Point(lat, lng);
		City20 cityNeo4j = new City20();
		cityNeo4j.setCity(city);
		cityNeo4j.setCountry(country);
		cityNeo4j.setCoordinates(p);
		return cityRepo.save(cityNeo4j);
	}
	
	//postgis
	
	@Override
	public List<City20Postgis> getAllOnDistanceFromBg100Postgis(){
		return cityRepoPostgis.getAllOnDistanceFromBg100();
	}
	@Override
	public List<City20Postgis> getAllOnDistanceFromBg200Postgis(){
		return cityRepoPostgis.getAllOnDistanceFromBg200();
	}
	@Override
	public List<City20Postgis> getAllOnDistanceFromBg500Postgis(){
		return cityRepoPostgis.getAllOnDistanceFromBg500();
	}
	public List<City20Postgis> getEuropeRussiaPostgis(){
		return cityRepoPostgis.getEuropeRussia();
	}

		
	public List<City20Postgis> getEuropeCitiesPostgis(){
		return cityRepoPostgis.getEuropeCities();
	}
	/*	
	public City20Postgis savePostgis(String city, double lat, double lng) {
			//Point p = new Point(lat, lng);
		return cityRepoPostgis.save(city, lat,lng);
	}*/
	
	public City20Postgis savePostgis(String city, String country, double lat, double lng) {
		GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
		org.locationtech.jts.geom.Point p = geometryFactory.createPoint(new Coordinate(lng,lat));
		City20Postgis cityPostgis = new City20Postgis();
	   	cityPostgis.setCity(city);
	   	cityPostgis.setCountry(country);
	   	cityPostgis.setGeom(p);
		return cityRepoPostgis.save(cityPostgis);
	}
	
	//mongo
	
		@Override
		public List<City20Mongo> getAllOnDistanceFromBg100Mongo(){
			City20Mongo bg = cityRepoMongo.findByCityAndCountry("Belgrade", "Serbia");
			return cityRepoMongo.findByGeomNear(bg.getGeom(), new Distance(100, Metrics.KILOMETERS));
		}
			
		@Override
		public List<City20Mongo> getAllOnDistanceFromBg200Mongo(){
			City20Mongo bg = cityRepoMongo.findByCityAndCountry("Belgrade", "Serbia");
			return cityRepoMongo.findByGeomNear(bg.getGeom(), new Distance(200, Metrics.KILOMETERS));
		}
			
		@Override
		public List<City20Mongo> getAllOnDistanceFromBg500Mongo(){
			City20Mongo bg = cityRepoMongo.findByCityAndCountry("Belgrade", "Serbia");
			return cityRepoMongo.findByGeomNear(bg.getGeom(), new Distance(500, Metrics.KILOMETERS));
		}

			
			
		public List<City20Mongo> getEuropeRussiaMongo(){
			ContinentMongo europe = continentRepoMongo.getEuropePoints();
			return cityRepoMongo.getEuropeRussia(europe.getGeometry());	
		}
			
			
			
		public List<City20Mongo> getEuropeCitiesMongo(){
			ContinentMongo europe = continentRepoMongo.getEuropePoints();
			//return cityRepoMongo.findByGeomWithin(europe.getGeometry());		
			return cityRepoMongo.getEuropeCities(europe.getGeometry());
		}
			
		public City20Mongo saveMongo(String city, String country, double lat, double lng) {
			Point p = new Point(lng, lat);
			City20Mongo cityMongo = new City20Mongo();
		   	cityMongo.setCity(city);
		   	cityMongo.setCountry(country);
		   	cityMongo.setGeom(p);
			return cityRepoMongo.save(cityMongo);
		}
			
}

