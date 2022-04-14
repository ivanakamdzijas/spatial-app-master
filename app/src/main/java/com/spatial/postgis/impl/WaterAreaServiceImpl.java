package com.spatial.postgis.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spatial.postgis.entities.WaterArea;
import com.spatial.postgis.repositories.WaterAreaRepo;
import com.spatial.postgis.services.WaterAreaService;

@Service
public class WaterAreaServiceImpl implements WaterAreaService  {
	
	@Autowired
	private WaterAreaRepo waterRepo;
	
	@Override
	public List<WaterArea> findAll() {
		return waterRepo.findAll();
	}
	
	public List<Object> getWaterOnDistance(String region, Double distance){
		return waterRepo.getWaterOnDistance(region, distance);
	}

}
