package com.spatial.postgis.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spatial.postgis.entities.AreaName;
import com.spatial.postgis.repositories.AreaNameRepo;
import com.spatial.postgis.services.AreaNameService;


@Service
public class AreaNameServiceImpl implements AreaNameService {

	
	@Autowired
	private AreaNameRepo nameRepo;
	
	@Override
	public List<AreaName> findAll() {
		return nameRepo.findAll();
	}

}
