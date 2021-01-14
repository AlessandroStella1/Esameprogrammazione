package it.univpm.ProgOggettiUnivpm.models.ow;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenWeatherBaseCoord {
	
	private Float latitude;
	private Float longitude;
	
	@JsonProperty("lat")
	public Float getLatitude() {
		return latitude;
	}

	@JsonProperty("lat")
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	
	@JsonProperty("lon")
	public Float getLongitude() {
		return longitude;
	}
	
	@JsonProperty("lon")
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	
}
