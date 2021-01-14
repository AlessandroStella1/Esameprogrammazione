package it.univpm.ProgOggettiUnivpm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

import it.univpm.ProgOggettiUnivpm.exceptions.InvalidConfigurationException;
import it.univpm.ProgOggettiUnivpm.models.EntityCity;
import it.univpm.ProgOggettiUnivpm.services.ProgOggettiUnivpmConfiguration;
import it.univpm.ProgOggettiUnivpm.services.EntityCityRepository;
import it.univpm.ProgOggettiUnivpm.services.OpenWeatherClient;

@SpringBootApplication
@EnableScheduling
@EntityScan
public class ProgOggettiUnivpmApplication {

	private static final Logger LOGGER=LoggerFactory.getLogger(OpenWeatherClient.class);
	
	private static final ProgOggettiUnivpmConfiguration configuration = ProgOggettiUnivpmConfiguration.getInstance();

	@Autowired
	private EntityCityRepository entityCityRepository;

	public static void main(String[] args) {
		try {
			LOGGER.info("main");
			
			LOGGER.info("carico configurazione");
			ProgOggettiUnivpmConfiguration.Load("config.json");
			
			LOGGER.info("apiKey " + ProgOggettiUnivpmConfiguration.getInstance().getApiKey());
			SpringApplication.run(ProgOggettiUnivpmApplication.class, args);			
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
			LOGGER.error("File di configurazione non valido. Impossibile avviare il servizio");
		}
	}
	
	/**
	 * Eseguita subito dopo l'inizializzazione dell'applicatione. 
	 * Per ogni città presente nel file di configurazione, verifica la presenza nella tabella,
	 * se non presente la inserisce
	 */
	@PostConstruct
    public void init() {
		LOGGER.info("init");
        
		LOGGER.info("in database risultano " + entityCityRepository.count() + " città per il monitoraggio"); 
		/* Carica l'elenco delle città prevista dalla configurazione json e, se
		 * non presenti, le carica in tabella
		 */
		if (configuration.getCities() != null)
		{
			for (int i=0; i< configuration.getCities().size(); i++) {
				Long cityId = configuration.getCities().get(i);
				if (!entityCityRepository.existsById(cityId)) {
					LOGGER.info("aggiungo alla schedulazione " + cityId);
					EntityCity city = new EntityCity(cityId);
					entityCityRepository.save(city);
				}
				else
				{
					LOGGER.info("scarto dalla schedulazione " + cityId + " perchè già presente");
				}			
			}
		}
		LOGGER.info("fine init");
    }
}
