package com.spatial.postgis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spatial.postgis.entities.Destination;


@Repository
public interface DestinationRepo extends JpaRepository<Destination, Long> {


	@Transactional
	@Modifying
	@Query(value = "insert into destinations(name, lat, lon, geom) values (:name, :lat, :lon, ST_SetSRID(ST_Point( :lon, :lat ), 4326)\\:\\:geometry)", nativeQuery = true)
	void create(final String name, final Double lat, final Double lon);

	List<Destination> findAll();
	
}