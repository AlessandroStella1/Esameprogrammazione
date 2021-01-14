package it.univpm.ProgOggettiUnivpm.models.ow;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenWeatherBaseWeatherWeather {
	private Integer id;
	private String main;
	private String description;
	private String icon;

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}
	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}
	@JsonProperty("main")
	public String getMain() {
		return main;
	}
	@JsonProperty("main")
	public void setMain(String main) {
		this.main = main;
	}
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}
	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}
	@JsonProperty("icon")
	public String getIcon() {
		return icon;
	}
	@JsonProperty("icon")
	public void setIcon(String icon) {
		this.icon = icon;
	}
}
