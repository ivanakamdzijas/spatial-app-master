package com.spatial.postgis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spatial.postgis.entities.AreaName;

@Repository
public interface AreaNameRepo extends JpaRepository<AreaName, String> {

	List<AreaName> findAll();
}
