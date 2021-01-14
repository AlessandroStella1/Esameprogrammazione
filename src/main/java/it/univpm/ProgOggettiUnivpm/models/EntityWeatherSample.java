package it.univpm.ProgOggettiUnivpm.models;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import it.univpm.ProgOggettiUnivpm.models.ow.OpenWeatherBaseWeather;

@Entity
@Table(name="cw_samples")
public class EntityWeatherSample {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="city_id")
	private Long cityId;
	
	@Column(name="city_name")
	private String cityName;
	
	// se 0 indica il meteo corrente, se > 0 indica la previsione
	@Column(name="forecast_days")
	private Integer forecastDays; 
	
	@Column(name="date_epoch")
	private Long dateEpoch;
	
	@Column(name="date")
	private LocalDateTime date;
	
	@Column(name="weather")
	private String weather;

	@Column(name="temperature")
	private Float temperature;

	@Column(name="feels_like")
	private Float feelsLike;

	@Column(name="temp_min")
	private Float tempMin;

	@Column(name="temp_max")
	private Float tempMax;

	@Column(name="pressure")
	private Integer pressure;

	@Column(name="humidity")
	private Integer humidity;

	@Column(name="record_date")
	private LocalDateTime recordDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityIName) {
		this.cityName = cityIName;
	}

	public Integer getForecastDays() {
		return forecastDays;
	}

	public void setForecastDays(Integer forecastDays) {
		this.forecastDays = forecastDays;
	}

	public Long getDateEpoch() {
		return dateEpoch;
	}

	public void setDateEpoch(Long dateEpoch) {
		this.dateEpoch = dateEpoch;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date.truncatedTo(ChronoUnit.HOURS);
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public Float getTemperature() {
		return temperature;
	}

	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}

	public Float getFeelsLike() {
		return feelsLike;
	}

	public void setFeelsLike(Float feelsLike) {
		this.feelsLike = feelsLike;
	}

	public Float getTempMin() {
		return tempMin;
	}

	public void setTempMin(Float tempMin) {
		this.tempMin = tempMin;
	}

	public Float getTempMax() {
		return tempMax;
	}

	public void setTempMax(Float tempMax) {
		this.tempMax = tempMax;
	}

	public Integer getPressure() {
		return pressure;
	}

	public void setPressure(Integer pressure) {
		this.pressure = pressure;
	}

	public Integer getHumidity() {
		return humidity;
	}

	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}
	
	public LocalDateTime getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(LocalDateTime recordDate) {
		this.recordDate = recordDate;
	}
	
	/**
	 * Valorizza le prorietà della class di database corrente a partire dalla risposta del servizio OpenWeather (OpenWeatherBaseWeather)
	 * @param cityId ID della città per cui sono state rilevate le previsioni 
	 * @param cityName Nome della città per cui sono state rilevate le previsioni
	 * @param forecastDays Numero di giorni se si tratta di una previsione, altrimenti 0 per il meteo corrente
	 * @param sample Dati meteorologici
	 */
	public void setByResponse(Long cityId, String cityName, Integer forecastDays, OpenWeatherBaseWeather sample) {
		this.setCityId(cityId);
		this.setCityName(cityName);
		this.setTemperature(sample.getMain().getTemp());
		this.setForecastDays(forecastDays); 
		this.setDateEpoch(sample.getDt());
		this.setDate(sample.getDate());
		this.setTemperature(sample.getMain().getTemp());
		this.setFeelsLike(sample.getMain().getFeelsLike());
		this.setTempMin (sample.getMain().getTempMin());
		this.setTempMax (sample.getMain().getTempMax());
		this.setPressure (sample.getMain().getPressure());
		this.setHumidity (sample.getMain().getHumidity());
		this.setWeather (sample.getWeather().get(0).getMain());
		this.setRecordDate (LocalDateTime.now());
	}
	
	public String info() {
		return this.getCityName() + " " + this.getDate().toString();
	}
}
