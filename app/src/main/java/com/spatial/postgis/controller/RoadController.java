package com.spatial.postgis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spatial.postgis.entities.Road;
import com.spatial.postgis.services.RoadService;

@RestController
@RequestMapping("/roads")
public class RoadController {
	
	@Autowired
	private RoadService service;
	
	 @GetMapping("/all")
	 public List<Road> findAll() {
        return service.findAll();
    }

}
