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
@Table(name = "tourists_statistics")
public class TouristStat {
	
	@Id
	@Column( name = "statistics_id")
	private long id;
	
	@Column( name = "idindikator")
	private String idindikator;
	
	@Column( name = "skrindikator")
	private String skrindikator;
	
	@Column( name = "idvrpod")
	private String idvrpod;
	
	@Column( name = "nvrpod")
	private String nvrpod;
	
	@Column( name = "godmes")
	private String godmes;
	
	@Column( name = "nvrtacka")
	private String nvrtacka;
	
	@Column( name = "idter")
	private String idter;
	
	@ManyToOne
    @JoinColumn(name = "nter")
	private Region region_name;
	
	
	@Column( name = "nturisti")
	private String nturisti;
	
	@Column( name = "vrednost")
	private String vrednost;
	
	@Column( name = "idstatuspodatka")
	private String idstatuspodatka;
	
	@Column( name = "nstatuspodatka")
	private String nstatuspodatka;
	
	@Column( name = "idstatuspoverljivosti")
	private String idstatuspoverljivosti;
	
	@Column( name = "nstatuspoverljivosti")
	private String nstatuspoverljivosti;
	
	@Column( name = "idjedinicamere")
	private String idjedinicamere;
	
	@Column( name = "njedinicamere")
	private String njedinicamere;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdindikator() {
		return idindikator;
	}

	public void setIdindikator(String idindikator) {
		this.idindikator = idindikator;
	}

	public String getSkrindikator() {
		return skrindikator;
	}

	public void setSkrindikator(String skrindikator) {
		this.skrindikator = skrindikator;
	}

	public String getIdvrpod() {
		return idvrpod;
	}

	public void setIdvrpod(String idvrpod) {
		this.idvrpod = idvrpod;
	}

	public String getNvrpod() {
		return nvrpod;
	}

	public void setNvrpod(String nvrpod) {
		this.nvrpod = nvrpod;
	}

	public String getGodmes() {
		return godmes;
	}

	public void setGodmes(String godmes) {
		this.godmes = godmes;
	}

	public String getNvrtacka() {
		return nvrtacka;
	}

	public void setNvrtacka(String nvrtacka) {
		this.nvrtacka = nvrtacka;
	}

	public String getIdter() {
		return idter;
	}

	public void setIdter(String idter) {
		this.idter = idter;
	}

	public Region getRegion_name() {
		return region_name;
	}

	public void setRegion_name(Region region_name) {
		this.region_name = region_name;
	}

	public String getNturisti() {
		return nturisti;
	}

	public void setNturisti(String nturisti) {
		this.nturisti = nturisti;
	}

	public String getVrednost() {
		return vrednost;
	}

	public void setVrednost(String vrednost) {
		this.vrednost = vrednost;
	}

	public String getIdstatuspodatka() {
		return idstatuspodatka;
	}

	public void setIdstatuspodatka(String idstatuspodatka) {
		this.idstatuspodatka = idstatuspodatka;
	}

	public String getNstatuspodatka() {
		return nstatuspodatka;
	}

	public void setNstatuspodatka(String nstatuspodatka) {
		this.nstatuspodatka = nstatuspodatka;
	}

	public String getIdstatuspoverljivosti() {
		return idstatuspoverljivosti;
	}

	public void setIdstatuspoverljivosti(String idstatuspoverljivosti) {
		this.idstatuspoverljivosti = idstatuspoverljivosti;
	}

	public String getNstatuspoverljivosti() {
		return nstatuspoverljivosti;
	}

	public void setNstatuspoverljivosti(String nstatuspoverljivosti) {
		this.nstatuspoverljivosti = nstatuspoverljivosti;
	}

	public String getIdjedinicamere() {
		return idjedinicamere;
	}

	public void setIdjedinicamere(String idjedinicamere) {
		this.idjedinicamere = idjedinicamere;
	}

	public String getNjedinicamere() {
		return njedinicamere;
	}

	public void setNjedinicamere(String njedinicamere) {
		this.njedinicamere = njedinicamere;
	}
	
	
	

}
