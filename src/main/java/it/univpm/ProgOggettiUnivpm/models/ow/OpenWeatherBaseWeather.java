package it.univpm.ProgOggettiUnivpm.models.ow;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenWeatherBaseWeather {
	private Long dt;
	private OpenWeatherBaseWeatherMain main;
	private Integer visibility;
	private List<OpenWeatherBaseWeatherWeather> weather;

	@JsonProperty("dt")
	public Long getDt() {
		return dt;
	}
	
	@JsonProperty("dt")
	public void setDt(Long dt) {
		this.dt = dt;
	}

	@JsonProperty("date")
	public LocalDateTime getDate() {
		return LocalDateTime.ofInstant(Instant.ofEpochSecond(dt), ZoneId.systemDefault());
	}

	@JsonProperty("main")
	public OpenWeatherBaseWeatherMain getMain() {
		return main;
	}

	@JsonProperty("main")
	public void setMain(OpenWeatherBaseWeatherMain main) {
		this.main = main;
	}


	@JsonProperty("visibility")
	public int getVisibility() {
		return visibility;
	}

	@JsonProperty("visibility")
	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}

	@JsonProperty("weather")
	public List<OpenWeatherBaseWeatherWeather> getWeather() {
		return weather;
	}

	@JsonProperty("weather")
	public void setWeather(List<OpenWeatherBaseWeatherWeather> weather) {
		this.weather = weather;
	}

	
}
