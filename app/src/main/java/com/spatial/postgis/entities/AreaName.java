package com.spatial.postgis.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "area_names")
public class AreaName {
	

	@Id
	@Column( name = "area_name")
	private String area_name;
	

	@ManyToOne
    @JoinColumn(name = "region_name")
	private Region region_name;


	public String getArea_name() {
		return area_name;
	}


	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}


	public Region getRegion_name() {
		return region_name;
	}


	public void setRegion_name(Region region_name) {
		this.region_name = region_name;
	}
	
	

}
