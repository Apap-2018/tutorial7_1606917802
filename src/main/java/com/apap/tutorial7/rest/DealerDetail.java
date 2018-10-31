package com.apap.tutorial7.rest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Date;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DealerDetail {

	private String status;
		
	@JsonProperty("building-licence")
	private Integer buildingLicence;
	
	@JsonProperty("valid-until")
	private Date validUntil;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getBuildingLicence() {
		return buildingLicence;
	}

	public void setBuildingLicence(Integer buildingLicence) {
		this.buildingLicence = buildingLicence;
	}

	public Date getValidUntil() {
		return validUntil;
	}

	public void setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
	}
	
}
