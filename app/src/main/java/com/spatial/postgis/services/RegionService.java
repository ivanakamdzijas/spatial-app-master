package com.spatial.postgis.services;

import java.util.List;

import com.spatial.postgis.entities.Region;

public interface RegionService {
	
	List<Region> findAll();

}
