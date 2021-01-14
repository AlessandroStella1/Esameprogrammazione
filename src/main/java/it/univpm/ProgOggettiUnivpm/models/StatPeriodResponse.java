package it.univpm.ProgOggettiUnivpm.models;

import java.time.LocalDate;

public class StatPeriodResponse {
	
	private StatsFilters.PeriodType periodType;
	private LocalDate startDate;
	private LocalDate endDate;
	
	public StatsFilters.PeriodType getPeriodType() {
		return periodType;
	}
	
	public void setPeriodType(StatsFilters.PeriodType periodType) {
		this.periodType = periodType;
	}
	
	public LocalDate getStartDate() {
		return startDate;
	}
	
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	public LocalDate getEndDate() {
		return endDate;
	}
	
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
}
