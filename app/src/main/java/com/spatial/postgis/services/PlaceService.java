package com.spatial.postgis.services;

import java.util.List;


import com.spatial.postgis.entities.Place;

public interface PlaceService {
	List<Place> findAll();
}
