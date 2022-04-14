package com.spatial.postgis.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spatial.postgis.entities.Area;
import com.spatial.postgis.repositories.AreaRepo;
import com.spatial.postgis.services.AreaService;

@Service
public class AreaServiceImpl implements AreaService {

	
	@Autowired
	private AreaRepo areaRepo;
	
	@Override
	public List<Area> findAll() {
		return areaRepo.findAll();
	}

}
