package com.example.accessingdata.neo4j.repo;


import java.util.List;

import org.springframework.data.geo.Point;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import com.example.accessingdata.neo4j.entities.City40;
import com.example.accessingdata.neo4j.entities.City5;

public interface City40Repository extends Neo4jRepository<City40, Long> {

	
	
	@Query(value = "MATCH (c1:City40) WHERE c1.city='Belgrade' AND c1.country='Serbia' MATCH (c2:City40) WHERE distance(c1.coordinate,c2.coordinate)<=100000 RETURN DISTINCT c2")
	  List<City40> getAllOnDistanceFromBg100();
	
	@Query(value = "MATCH (c1:City40) WHERE c1.city='Belgrade' AND c1.country='Serbia' MATCH (c2:City40) WHERE distance(c1.coordinate,c2.coordinate)<=200000 RETURN DISTINCT c2")
	  List<City40> getAllOnDistanceFromBg200();
	
	@Query(value = "MATCH (c1:City40) WHERE c1.city='Belgrade' AND c1.country='Serbia' MATCH (c2:City40) WHERE distance(c1.coordinate,c2.coordinate)<=500000 RETURN  DISTINCT c2")
	  List<City40> getAllOnDistanceFromBg500();
	
	@Query(value = "MATCH (c:City40) WHERE c.country= 'Russia'\r\n"
			+ "CALL spatial.intersects('Continents', c.coordinate) yield node as n WHERE n.CONTINENT='Europe'\r\n"
			+ "RETURN DISTINCT c ")
	  List<City40> getEuropeRussia();
	
	@Query(value ="MATCH (c:City40) MATCH (co:Cont) WHERE co.continent='Europe' and spatial.algo.withinPolygon(c.coordinate, co.polygons) RETURN DISTINCT c limit 50")
	List<City40> getEuropeCities();
	
	/*@Query(value =" CREATE (c:City5 {city: ?#{#city}, coordinate:?#{#p} }) ")
	City40 save(String city, Point p);*/
	
	@Override
	<S extends City40> S save(S city);
	}

	