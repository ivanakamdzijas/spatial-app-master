package com.example.accessingdata.neo4j.repo;

import java.util.List;



import org.neo4j.driver.Value;
import org.neo4j.driver.types.Point;

import org.springframework.data.geo.Distance;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.neo4j.types.GeographicPoint2d;
import org.springframework.transaction.annotation.Transactional;

import com.example.accessingdata.neo4j.entities.City5;

public interface City5Repository extends Neo4jRepository<City5, Long> {

	//City5 findByCityAndCountry(String city, String country);
	
	//List<City5> findByCoordinateNear(Point value, Distance  d);

	@Query(value = "MATCH (c1:City5) MATCH (c2:City5) WHERE c1.city='Belgrade'  AND  c1.country='Serbia'  AND distance(c1.coordinate,c2.coordinate)<=100000 RETURN DISTINCT c2")
	  List<City5> getAllOnDistanceFromBg100();
	
	@Query(value = "MATCH (c1:City5) WHERE c1.city='Belgrade' AND c1.country='Serbia' MATCH (c2:City5) WHERE distance(c1.coordinate,c2.coordinate)<=200000 RETURN DISTINCT c2")
	  List<City5> getAllOnDistanceFromBg200();
	
	@Query(value = "MATCH (c1:City5) WHERE c1.city='Belgrade' AND c1.country='Serbia' MATCH (c2:City5) WHERE distance(c1.coordinate,c2.coordinate)<=500000 RETURN DISTINCT c2")
	  List<City5> getAllOnDistanceFromBg500();
	
	@Query(value = "MATCH (c:City5) WHERE c.country= 'Russia'\r\n"
			+ "CALL spatial.intersects('Continents', c.coordinate) yield node as n WHERE n.CONTINENT='Europe'\r\n"
			+ "RETURN DISTINCT c ")
	  List<City5> getEuropeRussia();
	
	@Query(value ="MATCH (c:City5) MATCH (co:Cont) WHERE co.continent='Europe' and spatial.algo.withinPolygon(c.coordinate, co.polygons) RETURN  c ")
	List<City5> getEuropeCities();
	
	List<City5> findAll();
	
	/*@Query(value =" CREATE (c:City5 {city: ?#{#city}, coordinate:?#{#p} }) ")
	City5 save(String city, Value p);*/
	@Transactional
	@Modifying
	@Override
	<S extends City5> S save(S city);
	
}
	
	