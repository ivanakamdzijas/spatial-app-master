package com.example.accessingdata.mongodb.repo;

import java.util.List;


import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonMultiPolygon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.accessingdata.mongodb.entities.City20Mongo;



public interface City20MongoRepo extends MongoRepository<City20Mongo, String> {
	
	City20Mongo findByCityAndCountry(String city, String country);
	
	/*@Query(value = "{geom: {$nearSphere: {$geometry:  ?0, $maxDistance: ?1 } }}")
	List<City10Mongo> getAllOnDistanceFromBg(Point geom, int km);*/
	List<City20Mongo> findByGeomNear(Point geom, Distance  d);
	

	@Query(value = "{\"country\":\"Russia\", geom: {$geoIntersects: {$geometry: ?0}}}")
	 List<City20Mongo> getEuropeRussia(GeoJsonMultiPolygon europe);
	
	//class org.springframework.data.mongodb.core.geo.GeoJsonMultiPolygon cannot be cast to class org.springframework.data.geo.Shape
	//List<City10Mongo> findByGeomWithin(GeoJsonMultiPolygon europe);
	//Note that GeoJSON polygons need to define a closed ring. zato ipak radim sa getEuropeCities
	@Query(value ="{geom: {$geoWithin: {$geometry:  ?0}}}")
	List<City20Mongo> getEuropeCities(GeoJsonMultiPolygon europe);
	
	@Override
	<S extends City20Mongo> S save(S city);
	//City10Mongo save(City10Mongo city);
	
	
}
