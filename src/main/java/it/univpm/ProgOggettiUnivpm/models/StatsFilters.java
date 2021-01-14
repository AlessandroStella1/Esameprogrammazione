package it.univpm.ProgOggettiUnivpm.models;

public class StatsFilters {

	public StatsFilters() {
		this.periodType = PeriodType.DAY;
	}

	public enum PeriodType {
		DAY,
		WEEK,
		MONTH
	}
	
	private PeriodType periodType;
	private Long cityId;
	private String cityName;

	public PeriodType getPeriodType() {
		return periodType;
	}

	public void setPeriodType(PeriodType periodType) {
		this.periodType = periodType;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
}
