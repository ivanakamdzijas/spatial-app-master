package com.spatial.postgis.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spatial.postgis.entities.Place;
import com.spatial.postgis.repositories.PlaceRepo;
import com.spatial.postgis.services.PlaceService;


@Service
public class PlaceServiceImpl implements PlaceService{
	
	@Autowired
	private PlaceRepo placeRepo;

	@Override
	public List<Place> findAll() {
		return placeRepo.findAll();
	}

}
