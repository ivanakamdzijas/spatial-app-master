package com.spatial.postgis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spatial.postgis.entities.Area;
import com.spatial.postgis.services.AreaService;

@RestController
@RequestMapping("/areas")
public class AreaController {
	
	@Autowired
	private AreaService service;
	
	 @GetMapping("/all")
	 public List<Area> findAll() {
        return service.findAll();
    }

}
