package com.example.accessingdata.mongodb.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.mongodb.core.geo.GeoJsonMultiPolygon;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.accessingdata.mongodb.entities.City5Mongo;



public interface City5MongoRepo extends MongoRepository<City5Mongo, String> {
	
	City5Mongo findByCityAndCountry(String city, String country);
	//List<City5Mongo> findAll();

	@Query(value = "{geom: {$nearSphere: {$geometry:  {	coordinates : [?0,?1]}, $maxDistance: ?2 } }}")
	List<City5Mongo> getAllOnDistanceFromBg(double x, double y, int km);
	//ovo dole je ya prvu veryiju
	//List<City5Mongo> findByGeomNear(GeoJsonPoint geom, Distance  d);
	

	@Query(value = "{\"country\":\"Russia\", geom: {$geoIntersects: {$geometry: ?0}}}")
	 List<City5Mongo> getEuropeRussia(GeoJsonMultiPolygon europe);
	
	//class org.springframework.data.mongodb.core.geo.GeoJsonMultiPolygon cannot be cast to class org.springframework.data.geo.Shape
	//List<City10Mongo> findByGeomWithin(GeoJsonMultiPolygon europe);
	//Note that GeoJSON polygons need to define a closed ring. zato ipak radim sa getEuropeCities
	@Query(value ="{geom: {$geoWithin: {$geometry:  ?0}}}")
	List<City5Mongo> getEuropeCities(GeoJsonMultiPolygon europe);
	
	@Modifying
	@Transactional
	@Override
	<S extends City5Mongo> S save(S city);
	//City10Mongo save(City10Mongo city);
	
	
}

