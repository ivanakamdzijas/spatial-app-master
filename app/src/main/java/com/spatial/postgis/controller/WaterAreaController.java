package com.spatial.postgis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.spatial.postgis.entities.WaterArea;

import com.spatial.postgis.services.WaterAreaService;

@RestController
@RequestMapping("/water")
public class WaterAreaController {
	
	@Autowired
	private WaterAreaService service;
	
	 @GetMapping("/all")
	 public List<WaterArea> findAll() {
        return service.findAll();
    }
	 @GetMapping("/onDistance")
	 public List<Object> getWaterOnDistance(String region, Double distance){
		return service.getWaterOnDistance(region, distance);
	 }

}
