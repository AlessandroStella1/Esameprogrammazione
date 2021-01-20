/*
 * https://spring.io/guides/gs/scheduling-tasks/
 */

package it.univpm.ProgOggettiUnivpm.services;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import it.univpm.ProgOggettiUnivpm.models.EntityCity;
import it.univpm.ProgOggettiUnivpm.models.EntityWeatherSample;
import it.univpm.ProgOggettiUnivpm.models.ow.OpenWeatherCurrentResponse;
import it.univpm.ProgOggettiUnivpm.models.ow.OpenWeatherForecastResponse;
import it.univpm.ProgOggettiUnivpm.models.ow.OpenWeatherForecastWeather;

/**
 * Contiene le operazioni pianificate, ad intervalli regolari verifica la presenza in tabella del meteo attuale per una specifica città.
 * La cadenza fixedRate è in millisecondi, viene quindi impostata a 30 minuti: 30 * 60 * 1000 = 1800000.
 * Le condizioni del meteo attuale vengono memorizzate ignorando i minuti e i secondi, nel caso di più letture disponibili per la stessa ora,
 * viene considerata solo la prima.
 */

@Component
public class OpenWheatherTasks {

	private static final Logger LOGGER = LoggerFactory.getLogger(OpenWheatherTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Autowired
	private EntityCityRepository entityCityRepository;

	@Autowired
	private EntityWeatherSampleRepository entityWeatherSampleRepository;
	
	/**
	 * Salva le condizioni meteo attuali per ogni città presente in EntityCityRepository
	 * L'operazione viene eseguita ogni 30 minuti dopo 30 secondi dall'avvio dell'applicazione
	 */
	@Scheduled(initialDelay=30000, fixedRate = 18000000)
	// @Scheduled(initialDelay=30000, fixedRate = 10000)
	public void persistCurrentWeather() {
		LOGGER.info("Richiedo condizioni meteo correnti {}", dateFormat.format(new Date()));
		LOGGER.info("In database risultano " + entityCityRepository.count() + " città per il monitoraggio"); 

		List<EntityCity> cities = (List<EntityCity>) entityCityRepository.findAll();
		
		for (int i = 0; i < cities.size(); i++) {
			OpenWeatherCurrentResponse response = OpenWeatherClient.getWeatherById(cities.get(i).getId());
			
			// Converte le informazioni ottenute da OW () nell'entità di database (EntityWeatherSample) 
			EntityWeatherSample sample = new EntityWeatherSample();
			// setByResponse è compatibile con OpenWeatherCurrentResponse perchè accetta come ultimo parametro OpenWeatherBaseWeather
			// che ne rappresenta la classe base
			sample.setByResponse(response.getCityId(), response.getCityName(), 0, response);

			// Verifica se le condizioni meteo per una città ad una certa ora sono già presenti
			if (entityWeatherSampleRepository.findByCityIdAndDateAndForecastDays(sample.getCityId(), sample.getDate(), 0).size() == 0)
			{
				LOGGER.info(String.format("Inserisco il meteo attuale: %s per %s", sample.info(), cities.get(i).getId()));
				entityWeatherSampleRepository.save(sample);
			}
			else
			{
				LOGGER.info(String.format("Ignoro il meteo attuale perchè già presente: %s per %s", sample.info(), cities.get(i).getId()));
			}
        }
	}
	
	@Scheduled(initialDelay=5000, fixedRate = 18000000)
	// @Scheduled(initialDelay=30000, fixedRate = 10000)
	public void persistForecastWeather() {
		LOGGER.info("Richiedo previsioni meteo");
		LOGGER.info("In database risultano " + entityCityRepository.count() + " città per il monitoraggio"); 

		List<EntityCity> cities = (List<EntityCity>) entityCityRepository.findAll();
		
		for (int i = 0; i < cities.size(); i++) {
			
			Long cityId = cities.get(i).getId();
			OpenWeatherForecastResponse response = OpenWeatherClient.getForecastById(cityId);
			
			for(OpenWeatherForecastWeather forecast : response.getList()) {
				// determino il numero di giorni
				int forecastDays = (int) Duration.between(LocalDateTime.now(), forecast.getDate()).toDays();
				// considero solo le previsioni per i giorni futuri
				if (forecastDays > 0)
				{
					// Converte le informazioni ottenute da OW () nell'entità di database (EntityWeatherSample)				
					EntityWeatherSample sample = new EntityWeatherSample();
					// setByResponse è compatibile con OpenWeatherForecastWeather perchè accetta come ultimo parametro OpenWeatherBaseWeather
					// che ne rappresenta la classe base
					sample.setByResponse(cities.get(i).getId(), cities.get(i).getCityIName(), forecastDays, forecast);
		
					// Verifica se le previsioni meteo per una città ad una certa ora sono già presenti
					if (entityWeatherSampleRepository.findByCityIdAndDateAndForecastDays(sample.getCityId(), sample.getDate(), forecastDays).size() == 0)
					{
						LOGGER.info(String.format("Inserisco le previsioni meteo: %s per %s gg %s", sample.info(), cities.get(i).getId(), forecastDays));
						entityWeatherSampleRepository.save(sample);
					}
					else
					{
						LOGGER.info(String.format("Ignoro le previsioni meteo perchè già presenti: %s per %s gg %s", sample.info(), cities.get(i).getId(), forecastDays));
					}
				}
				else
				{
					LOGGER.info(String.format("Ignoro le previsioni meteo perchè numero giorni previsione == 0: %s gg %s", cities.get(i).getId(), forecastDays));
				}
			}
        }
	}

}