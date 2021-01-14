package it.univpm.ProgOggettiUnivpm.models;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StatsResponse extends BaseResponse {
	
	private LocalDateTime startDate;
	private Integer countSamples;
	
	private Float avgTemperature;
	private Float minTemperature;
	private Float maxTemperature;

	
	/*
	private List<StatPeriodTempResponse> temperaturePeriods;
	private List<StatPeriodMeteoResponse> meteoPeriods;
	
	public List<StatPeriodTempResponse> getTemperaturePeriods() {
		return temperaturePeriods;
	}
	
	public void setTemperaturePeriods(List<StatPeriodTempResponse> temperaturePeriods) {
		this.temperaturePeriods = temperaturePeriods;
	}

	public List<StatPeriodMeteoResponse> getMeteoPeriods() {
		return meteoPeriods;
	}

	public void setMeteoPeriods(List<StatPeriodMeteoResponse> meteoPeriods) {
		this.meteoPeriods = meteoPeriods;
	}
*/
	@JsonProperty("startDate")
	public LocalDateTime getStartDate() {
		return startDate;
	}

	@JsonProperty("startDate")
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	
	@JsonProperty("countSamples")
	public Integer getCountSamples() {
		return countSamples;
	}

	@JsonProperty("countSamples")
	public void setCountSamples(Integer countSamples) {
		this.countSamples = countSamples;
	}

	@JsonProperty("avgTemperature")
	public Float getAvgTemperature() {
		return avgTemperature;
	}

	@JsonProperty("avgTemperature")
	public void setAvgTemperature(Float avgTemperature) {
		this.avgTemperature = avgTemperature;
	}

	@JsonProperty("minTemperature")
	public Float getMinTemperature() {
		return minTemperature;
	}

	@JsonProperty("minTemperature")
	public void setMinTemperature(Float minTemperature) {
		this.minTemperature = minTemperature;
	}

	@JsonProperty("maxTemperature")
	public Float getMaxTemperature() {
		return maxTemperature;
	}

	@JsonProperty("maxTemperature")
	public void setMaxTemperature(Float maxTemperature) {
		this.maxTemperature = maxTemperature;
	}

	
}
