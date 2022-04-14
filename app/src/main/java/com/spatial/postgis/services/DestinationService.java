package com.spatial.postgis.services;

import java.util.List;

import com.spatial.postgis.entities.Destination;

public interface DestinationService {
	
	//Destination insert(Destination d);
	void create(final String name, final Double lat, final Double lng);

	List<Destination> findAll();
}
