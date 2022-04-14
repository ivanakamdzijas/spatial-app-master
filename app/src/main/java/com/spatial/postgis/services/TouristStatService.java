package com.spatial.postgis.services;

import java.util.List;

import com.spatial.postgis.entities.TouristStat;

public interface TouristStatService {
	List<TouristStat> findAll();
}
