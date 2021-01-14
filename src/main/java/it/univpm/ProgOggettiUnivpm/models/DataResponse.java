package it.univpm.ProgOggettiUnivpm.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataResponse extends BaseResponse{

	public DataResponse() {
		this.forecasts = new ArrayList<DataForecast>();
	}
	private Long cityId;
	private String cityName;
	private Float latitude;
	private Float longitude;
	
	private DataWeather weather;
	private List<DataForecast> forecasts;
	
	private DataStatistics statistics;
	
	@JsonProperty("cityId")
	public Long getCityId() {
		return cityId;
	}

	@JsonProperty("cityId")
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	@JsonProperty("cityName")
	public String getCityName() {
		return cityName;
	}

	@JsonProperty("cityName")
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@JsonProperty("latitude")
	public Float getLatitude() {
		return latitude;
	}

	@JsonProperty("latitude")
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	@JsonProperty("longitude")
	public Float getLongitude() {
		return longitude;
	}

	@JsonProperty("longitude")
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	@JsonProperty("weather")
	public DataWeather getWeather() {
		return weather;
	}

	@JsonProperty("weather")
	public void setWeather(DataWeather weather) {
		this.weather = weather;
	}

	@JsonProperty("forecast")
	public List<DataForecast> getForecasts() {
		return forecasts;
	}

	@JsonProperty("forecast")
	public void setForecasts(List<DataForecast> forecasts) {
		this.forecasts = forecasts;
	}

	@JsonProperty("statistics")
	public DataStatistics getStatistics() {
		return statistics;
	}

	@JsonProperty("statistics")
	public void setStatistics(DataStatistics statistics) {
		this.statistics = statistics;
	}


}
