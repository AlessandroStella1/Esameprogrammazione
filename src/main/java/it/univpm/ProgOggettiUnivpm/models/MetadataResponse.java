package it.univpm.ProgOggettiUnivpm.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MetadataResponse {
	
	public MetadataResponse() {
		this.datas = new ArrayList<MetadataElement>();
		this.stats = new ArrayList<MetadataElement>();
		
		this.datas.add(new MetadataElement("cityId", "Id della città"));
		this.datas.add(new MetadataElement("", ""));
		this.datas.add(new MetadataElement("", ""));
		this.datas.add(new MetadataElement("", ""));
		this.datas.add(new MetadataElement("weather", "condizioni meteo attuali"));
		this.datas.add(new MetadataElement("forecast", "previsioni meteo"));
		this.datas.add(new MetadataElement("temp", "temperature corrente"));
		this.datas.add(new MetadataElement("", ""));
		this.datas.add(new MetadataElement("statistics", "statistiche sui periodi richiesti"));
		this.datas.add(new MetadataElement("", ""));
		
		this.stats.add(new MetadataElement("startDate", "Data di del primo periodo rilevato"));
		this.stats.add(new MetadataElement("countSamples", "Numeri di rilevamenti individuati in base ai filtri di ricerca"));
		this.stats.add(new MetadataElement("avgTemperature", "Temperature media calcolata sui rilevamenti estratti"));
		this.stats.add(new MetadataElement("minTemperature", "Temperature minima calcolata sui rilevamenti estratti"));
		this.stats.add(new MetadataElement("minTemperature", "Temperature massima calcolata sui rilevamenti estratti"));
	}
	
	private List<MetadataElement> datas;
	private List<MetadataElement> stats;

	@JsonProperty("datas")
	public List<MetadataElement> getDatas() {
		return datas;
	}

	@JsonProperty("datas")
	public void setDatas(List<MetadataElement> datas) {
		this.datas = datas;
	}
	
	@JsonProperty("stats")
	public List<MetadataElement> getStats() {
		return stats;
	}

	@JsonProperty("datas")
	public void setStats(List<MetadataElement> stats) {
		this.datas = stats;
	}
}
