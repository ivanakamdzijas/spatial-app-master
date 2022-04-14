package com.spatial.postgis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spatial.postgis.entities.Place;
@Repository
public interface PlaceRepo extends JpaRepository<Place, Long> {

	List<Place> findAll();


}
