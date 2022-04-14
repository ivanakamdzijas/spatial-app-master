package com.spatial.postgis.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.locationtech.jts.geom.MultiLineString;

import lombok.Data;


@Data
@Entity
@Table(name = "roads")
public class Road {
	
	@Id
	@Column( name = "gid")
	private long id;
	
	@Column( name = "med_descri")
	private String med_descri;
	
	@Column( name = "rtt_descri")
	private String rtt_descri;
	
	@Column( name = "f_code_des")
	private String f_code_des;
	
	@Column( name = "iso")
	private String iso;
	
	@Column( name = "isocountry")
	private String isocountry;
	
	@Column( name = "geom")
	private MultiLineString geom;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMed_descri() {
		return med_descri;
	}

	public void setMed_descri(String med_descri) {
		this.med_descri = med_descri;
	}

	public String getRtt_descri() {
		return rtt_descri;
	}

	public void setRtt_descri(String rtt_descri) {
		this.rtt_descri = rtt_descri;
	}

	public String getF_code_des() {
		return f_code_des;
	}

	public void setF_code_des(String f_code_des) {
		this.f_code_des = f_code_des;
	}

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public String getIsocountry() {
		return isocountry;
	}

	public void setIsocountry(String isocountry) {
		this.isocountry = isocountry;
	}

	public MultiLineString getGeom() {
		return geom;
	}

	public void setGeom(MultiLineString geom) {
		this.geom = geom;
	}
	
	

}
