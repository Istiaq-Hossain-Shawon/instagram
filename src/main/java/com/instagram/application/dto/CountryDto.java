package com.instagram.application.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;


public class CountryDto implements Serializable {

	
	private long countryId;
	
	private String countryName;
	private String sort;	
	
	
	
	
	
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}

	private String logo;
	
	public long getCountryId() {
		return countryId;
	}
	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public CountryDto() {
		super();
	}
	public CountryDto(long id,  String countryName) {
		super();
		this.countryId = id;		
		this.countryName = countryName;
	}
	public long getId() {
		return countryId;
	}
	public void setId(long id) {
		this.countryId = id;
	}
	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}
