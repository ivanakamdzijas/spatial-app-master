package com.spatial.postgis.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spatial.postgis.entities.Area;
import com.spatial.postgis.entities.Destination;
import com.spatial.postgis.repositories.DestinationRepo;

import com.spatial.postgis.services.DestinationService;

@Service
public class DestinationServiceImpl implements DestinationService {
	@Autowired
	private DestinationRepo destinationRepo;

	
	@Override
	public void create(final String name, final Double lat, final Double lon) {
		destinationRepo.create(name, lat, lon);
	}
	
	
	@Override
	public List<Destination> findAll() {
		return destinationRepo.findAll();
	}


	
	
}
