package it.univpm.ProgOggettiUnivpm.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.univpm.ProgOggettiUnivpm.models.ow.OpenWeatherCurrentResponse;

/**
 * Classe utilizzata nella risposta servizio data per le condizioni meteo correnti.
 * @author 
 *
 */

public class DataWeather {
	
	public DataWeather() {		
	}
	
	public DataWeather(OpenWeatherCurrentResponse weather) {
		this.temp = weather.getMain().getTemp();
		this.tempMin = weather.getMain().getTempMin();
		this.tempMax = weather.getMain().getTempMax();
		this.pressure = weather.getMain().getPressure();
		this.humidity = weather.getMain().getHumidity();
	}
	
	/**
	 * Temperatura corrente.
	 */
	private float temp;
	/**
	 * Temperatura minima.
	 */
	private float tempMin;
	/**
	 * Temperatura massima.
	 */
	private float tempMax;
	/**
	 * Pressione corrente.
	 */
	private int pressure;
	/**
	 * Umidità corrente.
	 */
	private int humidity;
	
	@JsonProperty("tempMin")
	public float getTempMin() {
		return tempMin;
	}

	@JsonProperty("tempMin")
	public void setTempMin(float tempMin) {
		this.tempMin = tempMin;
	}

	@JsonProperty("tempMax")
	public float getTempMax() {
		return tempMax;
	}

	@JsonProperty("tempMax")
	public void setTempMax(float tempMax) {
		this.tempMax = tempMax;
	}

	@JsonProperty("pressure")
	public int getPressure() {
		return pressure;
	}

	@JsonProperty("pressure")
	public void setPressure(int pressure) {
		this.pressure = pressure;
	}

	@JsonProperty("humidity")
	public int getHumidity() {
		return humidity;
	}

	@JsonProperty("humidity")
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	@JsonProperty("temp")
	public float getTemp() {
		return temp;
	}

	@JsonProperty("temp")
	public void setTemp(float temp) {
		this.temp = temp;
	}
}
