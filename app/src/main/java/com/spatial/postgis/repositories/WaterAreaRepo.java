package com.spatial.postgis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.spatial.postgis.entities.WaterArea;

public interface WaterAreaRepo extends JpaRepository<WaterArea, Long> {

	List<WaterArea> findAll();
	
	@Transactional
	@Modifying
	@Query(value = "SELECT ST_Transform(w.geom,4326),  CAST(w.name AS VARCHAR), tt.tacka, CAST(tt.city AS VARCHAR),, ST_Distance(ST_Transform(tt.tacka,2163), w.geom) "
			+ " FROM water_areas w,  areas a, area_names names,  (SELECT ST_PointOnSurface(ST_Transform(p.geom,4326)) as tacka, p.city as city "
			+ "				FROM area_names names, areas a, places p, water_areas w "
			+ "				WHERE names.area_name = a.name_1 AND "
			+ "				 names.region_name =:region "
			+ "					AND ST_ContainsProperly(a.geom, p.geom) "
			+ "					 LIMIT 1) as tt "
			+ " WHERE names.area_name = a.name_1 AND "
			+ "				 names.region_name = :region AND "
			+ "				 (ST_Contains(a.geom, w.geom) OR ST_Intersects(a.geom, w.geom)) "
			+ "   AND ST_DWithin(ST_Transform(tt.tacka,2163), w.geom, :distance)",nativeQuery = true)
	List<Object> getWaterOnDistance(String region, Double distance);

}
