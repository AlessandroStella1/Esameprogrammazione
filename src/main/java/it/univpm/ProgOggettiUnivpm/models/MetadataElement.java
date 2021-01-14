package it.univpm.ProgOggettiUnivpm.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MetadataElement {
	
	public MetadataElement(String code, String description) {
		this.code = code;
		this.description = description;
	}
	
	private String code;
	private String description;
	
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}
	
	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}
	
	@JsonProperty("code")
	public String getCode() {
		return code;
	}
	
	@JsonProperty("code")
	public void setCode(String code) {
		this.code = code;
	}
}
