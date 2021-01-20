package it.univpm.ProgOggettiUnivpm.models;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.univpm.ProgOggettiUnivpm.models.ow.OpenWeatherForecastWeather;

/**
 * Classe di risposta del servizio /data.
 * @author
 *
 */
public class DataForecast {
	public DataForecast() {
		
	}
	
	public DataForecast(OpenWeatherForecastWeather forecast) {
		this.dt = forecast.getDt();
		this.temp = forecast.getMain().getTemp();
		this.tempMin = forecast.getMain().getTempMin();
		this.tempMax = forecast.getMain().getTempMax();
		this.pressure = forecast.getMain().getPressure();
		this.humidity = forecast.getMain().getHumidity();
	}
	
	/**
	 * Data della previsione corrente.
	 */
	
	private Long dt;

	/**
	 * Temperature stimata.
	 */
	private float temp;
	/**
	 * Temperature minima stimata.
	 */
	private float tempMin;
	/**
	 * Temperature massima stimata.
	 */
	private float tempMax;
	/**
	 * Pressione stimata.
	 */
	private int pressure;
	/**
	 * Umidità stimata.
	 */
	private int humidity;
	

	@JsonProperty("date")
	public LocalDateTime getDate() {
		return LocalDateTime.ofInstant(Instant.ofEpochSecond(dt), ZoneId.systemDefault());
	}
	
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
