package it.univpm.ProgOggettiUnivpm.models.ow;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class OpenWeatherForecastResponse {
	
	private String cod;
	private List<OpenWeatherForecastWeather> list;
	
	@JsonProperty("list")
	public List<OpenWeatherForecastWeather> getList() {
		return list;
	}
	
	@JsonProperty("list")
	public void setList(List<OpenWeatherForecastWeather> list) {
		this.list = list;
	}
	
	@JsonProperty("cod")
	public String getCod() {
		return cod;
	}
	
	@JsonProperty("cod")
	public void setCod(String cod) {
		this.cod = cod;
	}
}
