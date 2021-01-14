package it.univpm.ProgOggettiUnivpm.models.ow;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenWeatherForecastWeather extends OpenWeatherBaseWeather {	
	
	private Float pop;

	@JsonProperty("pop")
	public float getPop() {
		return pop;
	}

	@JsonProperty("pop")
	public void setPop(float pop) {
		this.pop = pop;
	}
}
