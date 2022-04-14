package com.spatial.postgis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spatial.postgis.entities.Region;

@Repository
public interface RegionRepo extends JpaRepository<Region, String> {

	List<Region> findAll();
}