package it.univpm.ProgOggettiUnivpm.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Risposta del servizio data.
 * @author 
 *
 */
public class DataResponse extends BaseResponse{

	public DataResponse() {
		this.forecasts = new ArrayList<DataForecast>();
	}
	
	/**
	 * Id della città richiesta.
	 */
	private Long cityId;
	/**
	 * Nome della città richiesta.
	 */
	private String cityName;
	/**
	 * Latitudine della città richiesta.
	 */
	private Float latitude;
	/**
	 * Longitudine della città richiesta.
	 */
	private Float longitude;
	
	/**
	 * Condizioni meteo per la città richiesta.
	 */
	private DataWeather weather;
	/**
	 * Previsioni meteo per la città richiesta.
	 */
	private List<DataForecast> forecasts;
	/**
	 * Valori medi, minimi e massimi delle previsioni.
	 */
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
