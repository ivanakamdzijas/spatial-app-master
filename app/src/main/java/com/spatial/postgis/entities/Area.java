package com.spatial.postgis.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.locationtech.jts.geom.MultiPolygon;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "areas")
public class Area {

	
	@Id
	@Column( name = "gid")
	private long id;
	
	@Column( name = "gid_0")
	private String contry;
	
	@Column( name = "name_0")
	private String contry_name;
	
	@Column( name = "gid_1")
	private String area_number;
	
	
	
	@ManyToOne
    @JoinColumn(name = "name_1")
	private AreaName area_name;
	
	@Column( name = "nl_name_1")
	private String area_cyrillic;
	
	@Column( name = "gid_2")
	private String city_number;
	
	@Column( name = "name_2")
	private String city;
	
	@Column( name = "varname_2")
	private String city_varname;
	
	@Column( name = "nl_name_2")
	private String city_cyrillic;
	
	@Column( name = "type_2")
	private String type;
	
	@Column( name = "engtype_2")
	private String engtype;
	
	@Column( name = "cc_2")
	private String cc;
	
	@Column( name = "hasc_2")
	private String hasc;
	
	@Column( name = "geom", columnDefinition = "geography")
	private MultiPolygon geom;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContry() {
		return contry;
	}

	public void setContry(String contry) {
		this.contry = contry;
	}

	public String getContry_name() {
		return contry_name;
	}

	public void setContry_name(String contry_name) {
		this.contry_name = contry_name;
	}

	public String getArea_number() {
		return area_number;
	}

	public void setArea_number(String area_number) {
		this.area_number = area_number;
	}

	public AreaName getArea() {
		return area_name;
	}

	public void setArea(AreaName area_name) {
		this.area_name = area_name;
	}

	public String getArea_cyrillic() {
		return area_cyrillic;
	}

	public void setArea_cyrillic(String area_cyrillic) {
		this.area_cyrillic = area_cyrillic;
	}

	public String getCity_number() {
		return city_number;
	}

	public void setCity_number(String city_number) {
		this.city_number = city_number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity_varname() {
		return city_varname;
	}

	public void setCity_varname(String city_varname) {
		this.city_varname = city_varname;
	}

	public String getCity_cyrillic() {
		return city_cyrillic;
	}

	public void setCity_cyrillic(String city_cyrillic) {
		this.city_cyrillic = city_cyrillic;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEngtype() {
		return engtype;
	}

	public void setEngtype(String engtype) {
		this.engtype = engtype;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getHasc() {
		return hasc;
	}

	public void setHasc(String hasc) {
		this.hasc = hasc;
	}

	public MultiPolygon getGeom() {
		return geom;
	}

	public void setGeom(MultiPolygon geom) {
		this.geom = geom;
	}
	
	
}
