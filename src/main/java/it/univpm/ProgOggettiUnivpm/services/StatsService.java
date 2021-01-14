package it.univpm.ProgOggettiUnivpm.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import it.univpm.ProgOggettiUnivpm.models.EntityWeatherSample;
import it.univpm.ProgOggettiUnivpm.models.StatsResponse;

/**
 * 
 * Servizio per il calcolo delle statistiche su un insieme di condizioni meteo rilevate
 *
 */

@Service
public class StatsService {

	/**
	 * Costruttore di classe
	 * @param samples Elenco delle condizioni meteo rilevate
	 */
	public StatsService (List<EntityWeatherSample> samples) {
		this.samples = samples;
	}
	
	public List<EntityWeatherSample> getSamples() {
		return samples;
	}

	public void setSamples(List<EntityWeatherSample> samples) {
		this.samples = samples;
	}

	private List<EntityWeatherSample> samples;
	
	public Integer countPeriods() {
		return this.samples.size();
	}

	/**
	 * Calcola la temperatura media dell'insieme di condizioni meteo
	 * @return Temperatura media 
	 */
	public LocalDateTime minDate() {
		LocalDateTime date = LocalDateTime.now();
		for(int i =0; i < samples.size(); i++) {
			if (samples.get(i).getDate().isBefore(date))
			{
				date = samples.get(i).getDate();
			}
		}
		return date ;
	}

	/**
	 * Calcola la temperatura media dell'insieme di condizioni meteo
	 * @return Temperatura media 
	 */
	public Float avgTemperature() {
		Float value = 0F;
		for(int i =0; i < samples.size(); i++) {
			value = value + samples.get(i).getTemperature();
		}
		return value / samples.size();
	}
	
	/**
	 * Calcola la temperatura minima dell'insieme di condizioni meteo
	 * @return Temperatura minima 
	 */
	public Float minTemperature() {
		Float value = 9999999F;
		for(int i =0; i < samples.size(); i++) {
			if (samples.get(i).getTemperature() < value)
				value = samples.get(i).getTemperature();
		}
		return value;
	}

	/**
	 * Calcola la temperatura massima dell'insieme di condizioni meteo
	 * @return Temperatura massima 
	 */
	public Float maxTemperature() {
		Float value = -9999999F;
		for(int i =0; i < samples.size(); i++) {
			if (samples.get(i).getTemperature() > value)
				value = samples.get(i).getTemperature();
		}
		return value;
	}

	public StatsResponse analyzePeriods() {
		StatsResponse stats = new StatsResponse();
		stats.setStartDate(minDate());	
		stats.setCountSamples(countPeriods());
		stats.setAvgTemperature(avgTemperature());
		stats.setMinTemperature(minTemperature());
		stats.setMaxTemperature(maxTemperature());				
		stats.setSuccess(true);
		return stats;
	}
}
