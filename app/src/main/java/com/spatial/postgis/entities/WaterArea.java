package com.spatial.postgis.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.locationtech.jts.geom.MultiPolygon;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Entity
@Table(name = "water_areas")
public class WaterArea {
	
	@Id
	@Column( name = "gid")
	private long id;
	
	@Column( name = "iso")
	private String iso;
	
	@Column( name = "country")
	private String country;
	
	@Column( name = "f_code_des")
	private String codeDes;
	
	@Column( name = "hyc_descri")
	private String hycDescri;
	
	@Column( name = "name")
	private String name;
	
	@Column(columnDefinition = "geography")

	private MultiPolygon geom;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCodeDes() {
		return codeDes;
	}

	public void setCodeDes(String codeDes) {
		this.codeDes = codeDes;
	}

	public String getHyDescri() {
		return hycDescri;
	}

	public void setHyDescri(String hycDescri) {
		this.hycDescri = hycDescri;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MultiPolygon getGeom() {
		return geom;
	}

	public void setGeom(MultiPolygon geom) {
		this.geom = geom;
	}

	
	

	
	

}
