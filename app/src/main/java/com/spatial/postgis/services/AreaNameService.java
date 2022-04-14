package com.spatial.postgis.services;

import java.util.List;

import com.spatial.postgis.entities.Area;
import com.spatial.postgis.entities.AreaName;

public interface AreaNameService {
	List<AreaName> findAll();
}
