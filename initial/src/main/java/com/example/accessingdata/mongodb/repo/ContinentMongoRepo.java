package com.example.accessingdata.mongodb.repo;

import java.util.List;

import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.accessingdata.mongodb.entities.ContinentMongo;



public interface ContinentMongoRepo extends MongoRepository<ContinentMongo, String>  {

	@Query(value = "{\"properties.CONTINENT\":\"Europe\"}")
	ContinentMongo getEuropePoints();
}
