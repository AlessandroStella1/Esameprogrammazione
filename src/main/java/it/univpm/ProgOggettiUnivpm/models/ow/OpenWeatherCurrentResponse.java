package it.univpm.ProgOggettiUnivpm.models.ow;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenWeatherCurrentResponse extends OpenWeatherBaseWeather  {
	
	private Long cityId;
	private String cityName;
	private String cod;
	private OpenWeatherBaseCoord coordinate;
	
	@JsonProperty("cod")
	public String getCod() {
		return cod;
	}
	
	@JsonProperty("cod")
	public void setCod(String cod) {
		this.cod = cod;
	}

	@JsonProperty("id")
	public Long getCityId() {
		return cityId;
	}

	@JsonProperty("id")
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	@JsonProperty("name")
	public String getCityName() {
		return cityName;
	}

	@JsonProperty("name")
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@JsonProperty("coord")
	public OpenWeatherBaseCoord getCoordinate() {
		return coordinate;
	}

	@JsonProperty("coord")
	public void setCoordinate(OpenWeatherBaseCoord coordinate) {
		this.coordinate = coordinate;
	}
}
