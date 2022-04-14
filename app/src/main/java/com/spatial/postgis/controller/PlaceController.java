package com.spatial.postgis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spatial.postgis.entities.Place;
import com.spatial.postgis.services.PlaceService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/places")
public class PlaceController {
	
	@Autowired
	private PlaceService service;
	
	 @GetMapping("/all")
	 public List<Place> findAll() {
        return service.findAll();
    }

}
