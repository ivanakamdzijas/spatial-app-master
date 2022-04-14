package com.spatial.postgis.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spatial.postgis.entities.Area;
import com.spatial.postgis.entities.TouristStat;
import com.spatial.postgis.repositories.AreaRepo;
import com.spatial.postgis.repositories.TouristStatRepo;
import com.spatial.postgis.services.AreaService;
import com.spatial.postgis.services.TouristStatService;

@Service
public class TouristStatServiceImpl implements TouristStatService {

	
	@Autowired
	private TouristStatRepo statRepo;
	
	@Override
	public List<TouristStat> findAll() {
		return statRepo.findAll();
	}

}
