package it.univpm.ProgOggettiUnivpm.models;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.univpm.ProgOggettiUnivpm.models.ow.OpenWeatherForecastWeather;

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
	
	private Long dt;

	private float temp;
	private float tempMin;
	private float tempMax;
	private int pressure;
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
