package com.spatial.postgis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spatial.postgis.entities.TouristStat;
import com.spatial.postgis.services.TouristStatService;

@RestController
@RequestMapping("/stats")
public class TouristStatController {
	
	@Autowired
	private TouristStatService service;
	
	 @GetMapping("/all")
	 public List<TouristStat> findAll() {
        return service.findAll();
    }

}
