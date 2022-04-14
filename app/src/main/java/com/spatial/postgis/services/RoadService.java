package com.spatial.postgis.services;

import java.util.List;

import com.spatial.postgis.entities.Road;

public interface RoadService {

	List<Road> findAll();
}
