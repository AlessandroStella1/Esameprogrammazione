package it.univpm.ProgOggettiUnivpm.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseResponse {
	private Boolean success;
	private String message;
	
	@JsonProperty("success")
	public Boolean getSuccess() {
		return success;
	}
	
	@JsonProperty("success")
	public void setSuccess(Boolean result) {
		this.success = result;
	}
	
	@JsonProperty("message")
	public String getMessage() {
		return message;
	}
	
	@JsonProperty("message")
	public void setMessage(String message) {
		this.message = message;
	}
	
}
