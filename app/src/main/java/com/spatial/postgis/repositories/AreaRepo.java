package com.spatial.postgis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spatial.postgis.entities.Area;

@Repository
public interface AreaRepo extends JpaRepository<Area, Long> {

	List<Area> findAll();
}
