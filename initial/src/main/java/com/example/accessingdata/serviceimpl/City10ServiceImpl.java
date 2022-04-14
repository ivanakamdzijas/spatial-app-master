package com.example.accessingdata.serviceimpl;

import java.util.List;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.PrecisionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonMultiPolygon;
import org.springframework.data.web.PageableHandlerMethodArgumentResolverSupport;
import org.springframework.stereotype.Service;


import com.example.accessingdata.mongodb.entities.City10Mongo;
import com.example.accessingdata.mongodb.entities.ContinentMongo;
import com.example.accessingdata.mongodb.repo.City10MongoRepo;
import com.example.accessingdata.mongodb.repo.ContinentMongoRepo;
import com.example.accessingdata.neo4j.entities.City10;
import com.example.accessingdata.neo4j.repo.City10Repository;
import com.example.accessingdata.postgis.entities.City10Postgis;
import com.example.accessingdata.postgis.repo.City10PostgisRepo;
import com.example.accessingdata.service.City10Service;

@Service
public class City10ServiceImpl implements City10Service {
	@Autowired
	private City10Repository cityRepo;
	
	@Autowired
	private City10PostgisRepo cityRepoPostgis;

	
	@Autowired
	private City10MongoRepo cityRepoMongo;
	
	@Autowired
	private ContinentMongoRepo continentRepoMongo;

	
	
	
	@Override
	public List<City10> getAllOnDistanceFromBg100(){
		return cityRepo.getAllOnDistanceFromBg100();
	}
	
	
	
	@Override
	public List<City10> getAllOnDistanceFromBg200(){
		return cityRepo.getAllOnDistanceFromBg200();
	}
	@Override
	public List<City10> getAllOnDistanceFromBg500(){
		return cityRepo.getAllOnDistanceFromBg500();
	}

	public List<City10> getEuropeRussia(){
		return cityRepo.getEuropeRussia();
	}

	
	public List<City10> getEuropeCities(){
		return cityRepo.getEuropeCities();
	}
	
	/*public City10 save(String city, double lat, double lng) {
		Point p = new Point(lat, lng);
		return cityRepo.save(city, p);
	}*/
	
	public City10 save(String city, String country, double lat, double lng) {
		Point p = new Point(lng, lat);
		City10 cityNeo4j = new City10();
		cityNeo4j.setCity(city);
		cityNeo4j.setCountry(country);
		cityNeo4j.setCoordinates(p);
		return cityRepo.save(cityNeo4j);
	}
	
	//postgis
	
	@Override
	public List<City10Postgis> getAllOnDistanceFromBg100Postgis(){
		return cityRepoPostgis.getAllOnDistanceFromBg100();
	}
	@Override
	public List<City10Postgis> getAllOnDistanceFromBg200Postgis(){
		return cityRepoPostgis.getAllOnDistanceFromBg200();
	}
	@Override
	public List<City10Postgis> getAllOnDistanceFromBg500Postgis(){
		return cityRepoPostgis.getAllOnDistanceFromBg500();
	}
	public List<City10Postgis> getEuropeRussiaPostgis(){
		return cityRepoPostgis.getEuropeRussia();
	}

	
	public List<City10Postgis> getEuropeCitiesPostgis(){
		return cityRepoPostgis.getEuropeCities();
	}
	
	/*public City10Postgis savePostgis(String city, double lat, double lng) {
		//Point p = new Point(lat, lng);
		return cityRepoPostgis.save(city, lat,lng);
	}*/
	
	public City10Postgis savePostgis(String city, String country, double lat, double lng) {
		GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
		org.locationtech.jts.geom.Point p = geometryFactory.createPoint(new Coordinate(lng,lat));
		City10Postgis cityPostgis = new City10Postgis();
	   	cityPostgis.setCity(city);
	   	cityPostgis.setCountry(country);
	   	cityPostgis.setGeom(p);
		return cityRepoPostgis.save(cityPostgis);
	}
	
	
	//mongo
	
		@Override
		public List<City10Mongo> getAllOnDistanceFromBg100Mongo(){
			City10Mongo bg = cityRepoMongo.findByCityAndCountry("Belgrade", "Serbia");
			return cityRepoMongo.findByGeomNear(bg.getGeom(), new Distance(100, Metrics.KILOMETERS));
		}
		
		@Override
		public List<City10Mongo> getAllOnDistanceFromBg200Mongo(){
			City10Mongo bg = cityRepoMongo.findByCityAndCountry("Belgrade", "Serbia");
			return cityRepoMongo.findByGeomNear(bg.getGeom(), new Distance(200, Metrics.KILOMETERS));
		}
		
		@Override
		public List<City10Mongo> getAllOnDistanceFromBg500Mongo(){
			City10Mongo bg = cityRepoMongo.findByCityAndCountry("Belgrade", "Serbia");
			return cityRepoMongo.findByGeomNear(bg.getGeom(), new Distance(500, Metrics.KILOMETERS));
		}

		
		
		public List<City10Mongo> getEuropeRussiaMongo(){
			ContinentMongo europe = continentRepoMongo.getEuropePoints();
			return cityRepoMongo.getEuropeRussia(europe.getGeometry());
		}
		
		
		
		public List<City10Mongo> getEuropeCitiesMongo(){
			ContinentMongo europe = continentRepoMongo.getEuropePoints();
			//return cityRepoMongo.findByGeomWithin(europe.getGeometry());
			return cityRepoMongo.getEuropeCities(europe.getGeometry());
		}
		
		public City10Mongo saveMongo(String city, String country, double lat, double lng) {
			Point p = new Point(lat, lng);
			City10Mongo cityMongo = new City10Mongo();
		   	cityMongo.setCity(city);
		   	cityMongo.setCountry(country);
		   	cityMongo.setGeom(p);
			return cityRepoMongo.save(cityMongo);
		}
		
		
}

