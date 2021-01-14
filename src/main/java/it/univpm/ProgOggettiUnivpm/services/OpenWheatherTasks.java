/*
 * https://spring.io/guides/gs/scheduling-tasks/
 */

package it.univpm.ProgOggettiUnivpm.services;

import java.text.SimpleDateFormat;
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
			sample.setByResponse(response.getCityId(), response.getCityName(), 0, response);

			// Verifica se le condizioni meteo per una città ad una certa ora sono già presenti
			if (entityWeatherSampleRepository.findByCityIdAndDateAndForecastDays(sample.getCityId(), sample.getDate(), 0).size() == 0)
			{
				LOGGER.info("Inserisco il meteo attuale: " + sample.info() + " per " + cities.get(i).getId());
				entityWeatherSampleRepository.save(sample);
			}
			else
			{
				LOGGER.info("Ignoro il meteo attuale perchè già presente: " + sample.info() + " per " + cities.get(i).getId());
			}
        }
	}
}