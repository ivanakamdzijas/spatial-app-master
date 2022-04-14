package com.example.accessingdata.postgis.repo;


import java.util.List;

import org.springframework.data.geo.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.accessingdata.postgis.entities.City10Postgis;
import com.example.accessingdata.postgis.entities.City20Postgis;


@Repository
public interface City20PostgisRepo  extends JpaRepository<City20Postgis, String> {


		

@Query(value = "SELECT c2.* \r\n"
				+ "FROM  cities20 c1, cities20 c2\r\n"
				+ "WHERE c1.city='Belgrade' AND c1.country='Serbia'  AND\r\n"
				+ "	 ST_DWithin(ST_Transform(c1.geom,3035), ST_Transform(c2.geom,3035), 100000)", nativeQuery = true)
List<City20Postgis> getAllOnDistanceFromBg100();
		

@Query(value = "SELECT c2.* \r\n"
				+ "FROM  cities20 c1, cities20 c2\r\n"
				+ "WHERE c1.city='Belgrade' AND c1.country='Serbia'  AND\r\n"
				+ "	 ST_DWithin(ST_Transform(c1.geom,3035), ST_Transform(c2.geom,3035), 200000)", nativeQuery = true)
List<City20Postgis> getAllOnDistanceFromBg200();
		

@Query(value = "SELECT c2.* \r\n"
				+ "FROM  cities20 c1, cities20 c2\r\n"
				+ "WHERE c1.city='Belgrade' AND c1.country='Serbia'  AND\r\n"
				+ "	 ST_DWithin(ST_Transform(c1.geom,3035), ST_Transform(c2.geom,3035), 500000)", nativeQuery = true)
List<City20Postgis> getAllOnDistanceFromBg500();
		
@Query(value = "SELECT c.* FROM   cities20 c, continents cont	WHERE c.country ='Russia' AND cont.continent='Europe' AND ST_Intersects(cont.geom, c.geom)", nativeQuery = true)
List<City20Postgis> getEuropeRussia();
		
@Query(value ="SELECT  c.* \r\n"
				+ "FROM continents cont, cities20 c \r\n"
				+ "WHERE cont.continent = 'Europe' AND ST_Within(c.geom, cont.geom)", nativeQuery = true)
List<City20Postgis> getEuropeCities();
/*		
@Transactional
@Modifying
@Query(value = "insert into cities20(name, lat, lon, geom) values (:name, :lat, :lon, ST_SetSRID(ST_Point( :lon, :lat ), 4326)\\:\\:geometry)", nativeQuery = true)
City20Postgis save(final String name, final Double lat, final Double lon);
*/

City20Postgis save(City20Postgis city);
	}