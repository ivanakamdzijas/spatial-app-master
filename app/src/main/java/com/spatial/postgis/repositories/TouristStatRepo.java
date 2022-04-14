package com.spatial.postgis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spatial.postgis.entities.TouristStat;

@Repository
public interface TouristStatRepo extends JpaRepository<TouristStat, Long> {

	List<TouristStat> findAll();
}
