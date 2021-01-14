package it.univpm.ProgOggettiUnivpm.services;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univpm.ProgOggettiUnivpm.models.DataFilters;
import it.univpm.ProgOggettiUnivpm.models.DataForecast;
import it.univpm.ProgOggettiUnivpm.models.DataResponse;
import it.univpm.ProgOggettiUnivpm.models.DataStatistics;
import it.univpm.ProgOggettiUnivpm.models.DataWeather;
import it.univpm.ProgOggettiUnivpm.models.EntityCity;
import it.univpm.ProgOggettiUnivpm.models.ow.OpenWeatherCurrentResponse;
import it.univpm.ProgOggettiUnivpm.models.ow.OpenWeatherForecastResponse;
import it.univpm.ProgOggettiUnivpm.models.ow.OpenWeatherForecastWeather;

/**
 * Servizio di supporto per l'esecuzione dei calcoli necessari per la visualizzazione
 * del meteo richiesto dall'utente 
 */

@Service
public class DataService {
	
	@Autowired
	private EntityCityRepository entityCityRepository;

	public DataResponse getMeteo(DataFilters filters) {
		
		// Esegue la chiamata per ottenere le condizioni attuali
		OpenWeatherCurrentResponse owWeatherResponse = OpenWeatherClient.getWeatherByName(filters.getCityName());
		
		// Esegue la chiamata per ottenere i forecast		
		OpenWeatherForecastResponse owForecastResponse = OpenWeatherClient.getForecastById(owWeatherResponse.getCityId());

		/*
		 * Verifica se la città è tra quelle in monitoraggio, altrimenti la aggiunge.
		 * Dopo circa mezz'ora verrà eseguito il salvataggio delle condizioni dal task predisposto.
		 */
		Long cityId = owWeatherResponse.getCityId();
		if (!entityCityRepository.existsById(cityId)) {
			EntityCity city = new EntityCity(cityId);
			city.setCityIName(owWeatherResponse.getCityName());
			entityCityRepository.save(city);
		}
		
		// restringo i periodi di previsione in base al numero di giorni richiesto
		ArrayList<OpenWeatherForecastWeather> forecastsSelect = new ArrayList<OpenWeatherForecastWeather>(); 
		LocalDateTime startDate = LocalDateTime.now().truncatedTo(ChronoUnit.DAYS).plusDays(1).minusSeconds(1);
		LocalDateTime endDate = LocalDateTime.now().truncatedTo(ChronoUnit.DAYS).plusDays(filters.getDays()+1).minusSeconds(1);
		for (OpenWeatherForecastWeather forecast : owForecastResponse.getList()) {
			if (forecast.getDate().isAfter(startDate) && forecast.getDate().isBefore(endDate)) {
				forecastsSelect.add(forecast);
			}
		}
		
		// Analizza le risposte e prepara i dati per l'utente
		DataResponse response = new DataResponse();
		response.setCityId(owWeatherResponse.getCityId());
		response.setCityName(owWeatherResponse.getCityName());
		response.setLatitude(owWeatherResponse.getCoordinate().getLatitude());
		response.setLongitude(owWeatherResponse.getCoordinate().getLongitude());
		
		// condizioni meteo correnti
		response.setWeather(new DataWeather(owWeatherResponse));
		
		// previsioni meteo, considero solo quelle selezionate e per la fascia oraria richiesta
		Integer referenceHour3 = Math.round(filters.getHour() / 3) * 3 + 1;
		for (OpenWeatherForecastWeather forecast : forecastsSelect) {
			// preparo i dati da restituire
			DataForecast data = new DataForecast(forecast);
			if (data.getDate().getHour() == referenceHour3) {
				response.getForecasts().add(data);
			}
		}
			
		// statistiche
		DataStatistics statistics = new DataStatistics(owForecastResponse.getList()); 
		response.setStatistics(statistics);
		
		return response;
	}

}
