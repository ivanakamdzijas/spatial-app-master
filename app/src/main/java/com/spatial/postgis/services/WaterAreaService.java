package com.spatial.postgis.services;

import java.util.List;


import com.spatial.postgis.entities.WaterArea;

public interface WaterAreaService {
	List<WaterArea> findAll();

	List<Object> getWaterOnDistance(String region, Double distance);
}
