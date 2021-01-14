package it.univpm.ProgOggettiUnivpm.models.ow;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenWeatherBaseWeatherMain {
	private float temp;
	private float feelsLike;
	private float tempMin;
	private float tempMax;
	private int pressure;
	private int seaLevel;
	private int grndLevel;
	private int humidity;
	private float tempKf;
	
	@JsonProperty("feels_like")
	public float getFeelsLike() {
		return feelsLike;
	}

	@JsonProperty("feels_like")
	public void setFeelsLike(float feelsLike) {
		this.feelsLike = feelsLike;
	}

	@JsonProperty("temp_min")
	public float getTempMin() {
		return tempMin;
	}

	@JsonProperty("temp_min")
	public void setTempMin(float tempMin) {
		this.tempMin = tempMin;
	}

	@JsonProperty("temp_max")
	public float getTempMax() {
		return tempMax;
	}

	@JsonProperty("temp_max")
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

	@JsonProperty("sea_level")
	public int getSeaLevel() {
		return seaLevel;
	}

	@JsonProperty("sea_level")
	public void setSeaLevel(int seaLevel) {
		this.seaLevel = seaLevel;
	}

	@JsonProperty("grnd_level")
	public int getGrndLevel() {
		return grndLevel;
	}

	@JsonProperty("grnd_level")
	public void setGrndLevel(int grndLevel) {
		this.grndLevel = grndLevel;
	}

	@JsonProperty("humidity")
	public int getHumidity() {
		return humidity;
	}

	@JsonProperty("humidity")
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	@JsonProperty("temp_kf")
	public float getTempKf() {
		return tempKf;
	}

	@JsonProperty("temp_kf")
	public void setTempKf(float tempKf) {
		this.tempKf = tempKf;
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
