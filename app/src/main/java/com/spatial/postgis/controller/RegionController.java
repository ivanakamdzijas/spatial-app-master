package com.spatial.postgis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spatial.postgis.entities.Region;
import com.spatial.postgis.services.RegionService;



@RestController
@RequestMapping("/regions")
public class RegionController {
	
	@Autowired
	private RegionService service;
	
	 @GetMapping("/all")
	 public List<Region> findAll() {
        return service.findAll();
    }

}

