package it.univpm.ProgOggettiUnivpm.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe filtro utilizzata come parametro per la ricerca del meteo di una città.
 * @author
 *
 */
public class DataFilters {

	public DataFilters() {
		this.hour = LocalDateTime.now().getHour();
		this.days = 5;
	}

	/**
	 * Nome della città per cui eseguire la ricerca meteo.
	 */
	private String cityName;
	/**
	 * Orario richiesto per la ricerca delle previsioni meteo. Come default assume l'orario dell'esecuzione della ricerca.
	 */
	private Integer hour;
	/**
	 * numero di giorni richiesti dall'utente per le previsioni meteo. Come default assume il valore 5. I valori ammessi vanno da 1 a 5.
	 */
	private Integer days;	
	
	@JsonProperty("cityName")
	public String getCityName() {
		return cityName;
	}

	@JsonProperty("cityName")
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@JsonProperty("hour")
	public Integer getHour() {
		return hour;
	}

	@JsonProperty("hour")
	public void setHour(Integer hour) {
		this.hour = hour;
	}

	/**
	 * numero di giorni richiesti dall'utente per le previsioni meteo 
	 */
	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}
	
}
