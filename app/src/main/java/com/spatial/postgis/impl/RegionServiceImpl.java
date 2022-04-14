package com.spatial.postgis.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spatial.postgis.entities.Region;
import com.spatial.postgis.repositories.RegionRepo;
import com.spatial.postgis.services.RegionService;

@Service
public class RegionServiceImpl implements RegionService {

	
	@Autowired
	private RegionRepo regionRepo;
	
	@Override
	public List<Region> findAll() {
		return regionRepo.findAll();
	}

}
