package it.univpm.ProgOggettiUnivpm.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.univpm.ProgOggettiUnivpm.models.ow.OpenWeatherForecastWeather;

public class DataStatistics {

	public DataStatistics() {		
	}
	
	public DataStatistics(List<OpenWeatherForecastWeather> forecasts) {	
		this.tempMin = 9999F;
		this.tempMax = -999F;
		this.tempAvg = -999F;
		this.pressureMin = 9999;
		this.pressureMax = -999;
		this.pressureAvg = -999;
		this.humidityMin = 9999;
		this.humidityMax = -999;
		this.humidityAvg = -999;
		
		for( OpenWeatherForecastWeather forecast : forecasts) {
			if (this.tempMin > forecast.getMain().getTempMin())
				this.tempMin = forecast.getMain().getTempMin();
			if (this.tempMax < forecast.getMain().getTempMax())
				this.tempMax = forecast.getMain().getTempMax();
			if (this.tempAvg == -999F)
				this.tempAvg = forecast.getMain().getTemp();
			else
				this.tempAvg = (this.tempAvg + forecast.getMain().getTemp()) / 2;
			
			if (this.pressureMin > forecast.getMain().getPressure())
				this.pressureMin = forecast.getMain().getPressure();
			if (this.pressureMax < forecast.getMain().getPressure())
				this.pressureMax = forecast.getMain().getPressure();
			if (this.pressureAvg == -999F)
				this.pressureAvg = forecast.getMain().getPressure();
			else
				this.pressureAvg = (this.pressureAvg + forecast.getMain().getPressure()) / 2;
			
			if (this.humidityMin > forecast.getMain().getHumidity())
				this.humidityMin = forecast.getMain().getHumidity();
			if (this.humidityMax < forecast.getMain().getHumidity())
				this.humidityMax = forecast.getMain().getHumidity();
			if (this.humidityAvg == -999F)
				this.humidityAvg = forecast.getMain().getHumidity();
			else
				this.humidityAvg = (this.humidityAvg + forecast.getMain().getHumidity()) / 2;
			
		}
	}

	private Float tempMin;
	private Float tempMax;
	private Float tempAvg;

	private Integer pressureMin;
	private Integer pressureMax;
	private Integer pressureAvg;

	private Integer humidityMin;
	private Integer humidityMax;
	private Integer humidityAvg;

	@JsonProperty("tempMin")
	public Float getTempMin() {
		return tempMin;
	}

	@JsonProperty("tempMin")
	public void setTempMin(Float tempMin) {
		this.tempMin = tempMin;
	}

	@JsonProperty("tempMax")
	public Float getTempMax() {
		return tempMax;
	}

	@JsonProperty("tempMax")
	public void setTempMax(Float tempMax) {
		this.tempMax = tempMax;
	}

	@JsonProperty("tempAvg")
	public Float getTempAvg() {
		return tempAvg;
	}

	@JsonProperty("tempAvg")
	public void setTempAvg(Float tempAvg) {
		this.tempAvg = tempAvg;
	}

	@JsonProperty("pressureMin")
	public Integer getPressureMin() {
		return pressureMin;
	}

	@JsonProperty("pressureMin")
	public void setPressureMin(Integer pressureMin) {
		this.pressureMin = pressureMin;
	}

	@JsonProperty("pressureMax")
	public Integer getPressureMax() {
		return pressureMax;
	}

	@JsonProperty("pressureMax")
	public void setPressureMax(Integer pressureMax) {
		this.pressureMax = pressureMax;
	}

	@JsonProperty("pressureAvg")
	public Integer getPressureAvg() {
		return pressureAvg;
	}

	@JsonProperty("pressureAvg")
	public void setPressureAvg(Integer pressureAvg) {
		this.pressureAvg = pressureAvg;
	}

	@JsonProperty("humidityMin")
	public Integer getHumidityMin() {
		return humidityMin;
	}
	
	@JsonProperty("humidityMin")
	public void setHumidityMin(Integer humidityMin) {
		this.humidityMin = humidityMin;
	}

	@JsonProperty("humidityMax")
	public Integer getHumidityMax() {
		return humidityMax;
	}

	@JsonProperty("humidityMax")
	public void setHumidityMax(Integer humidityMax) {
		this.humidityMax = humidityMax;
	}

	@JsonProperty("humidityAvg")
	public Integer getHumidityAvg() {
		return humidityAvg;
	}

	@JsonProperty("humidityAvg")
	public void setHumidityAvg(Integer humidityAvg) {
		this.humidityAvg = humidityAvg;
	}
}
