package com.spatial.postgis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spatial.postgis.entities.Area;
import com.spatial.postgis.entities.Destination;
import com.spatial.postgis.entities.Place;
import com.spatial.postgis.services.DestinationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/destinations")
public class DestinationController {

	@Autowired
	private DestinationService service;
	
	
	@PostMapping("/create")
	public void create(@RequestParam  String name, @RequestParam Double lat, @RequestParam Double lon) {
		service.create(name, lat, lon);
	}
	
	@GetMapping("/all")
	 public List<Destination> findAll() {
       return service.findAll();
   }
}
