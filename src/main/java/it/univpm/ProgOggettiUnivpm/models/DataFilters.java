package it.univpm.ProgOggettiUnivpm.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataFilters {

	public DataFilters() {
		this.hour = LocalDateTime.now().getHour();
		this.days = 5;
	}

	private String cityName;
	private Integer hour;
	private Integer days;	
	
	@JsonProperty("cityName")
	public String getCityName() {
		return cityName;
	}

	@JsonProperty("cityName")
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@JsonProperty("hour")
	public Integer getHour() {
		return hour;
	}

	@JsonProperty("hour")
	public void setHour(Integer hour) {
		this.hour = hour;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}
	
}
