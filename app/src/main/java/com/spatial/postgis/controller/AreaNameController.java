package com.spatial.postgis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.spatial.postgis.entities.AreaName;
import com.spatial.postgis.services.AreaNameService;


@RestController
@RequestMapping("/area_names")
public class AreaNameController {
	
	@Autowired
	private AreaNameService service;
	
	 @GetMapping("/all")
	 public List<AreaName> findAll() {
        return service.findAll();
    }

}
