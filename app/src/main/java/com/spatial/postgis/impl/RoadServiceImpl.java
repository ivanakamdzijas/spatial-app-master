package com.spatial.postgis.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spatial.postgis.entities.Road;
import com.spatial.postgis.repositories.RoadRepo;
import com.spatial.postgis.services.RoadService;



@Service
public class RoadServiceImpl implements RoadService {

	
	@Autowired
	private RoadRepo roadRepo;
	
	@Override
	public List<Road> findAll() {
		return roadRepo.findAll();
	}

}
