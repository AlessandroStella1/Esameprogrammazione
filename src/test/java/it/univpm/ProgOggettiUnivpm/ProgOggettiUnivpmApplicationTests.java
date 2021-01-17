package it.univpm.ProgOggettiUnivpm;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.util.Assert;

import it.univpm.ProgOggettiUnivpm.exceptions.InvalidConfigurationException;
import it.univpm.ProgOggettiUnivpm.models.EntityWeatherSample;
import it.univpm.ProgOggettiUnivpm.models.ow.OpenWeatherCurrentResponse;
import it.univpm.ProgOggettiUnivpm.services.EntityWeatherSampleRepository;
import it.univpm.ProgOggettiUnivpm.services.OpenWeatherClient;
import it.univpm.ProgOggettiUnivpm.services.ProgOggettiUnivpmConfiguration;

@SpringBootTest
class ProgOggettiUnivpmApplicationTests {

	@Autowired
	private EntityWeatherSampleRepository entityWeatherSampleRepository;

	@Test
	@Transactional
	void checkDatabaseInsert() {
		EntityWeatherSample entity = new EntityWeatherSample();
		entity.setCityId(99999999999L); // inserisco l'ID = 99999999999 convertito in Long tramite il suffisso L
		entity.setCityName("Test city");
		entity.setTemperature(21F); // temperatura = 21 convertito in Float
		entityWeatherSampleRepository.save(entity);
		List<EntityWeatherSample> foundList = entityWeatherSampleRepository.findByCityId(entity.getCityId());
		Assert.isTrue(foundList.size() == 1, "Trovati più record per la città di test");
		EntityWeatherSample found = foundList.get(0);
		Assert.isTrue(found.getCityId() == entity.getCityId(), "ID città non corrispondenti");
		Assert.isTrue(found.getCityName() == entity.getCityName(), "Nomi città non corrispondenti");
		Assert.isTrue(found.getTemperature() == entity.getTemperature(), "Temperature non corrispondenti");
	}

	@Test
	void checkOpenWeatherClient() throws InvalidConfigurationException {
		try {
			ProgOggettiUnivpmConfiguration.Load("config.json");
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
			throw e;
		}
		OpenWeatherCurrentResponse result = OpenWeatherClient.getWeatherById(2177915L);
		Assert.isTrue(result.getCityId() == 2177915, "La città restituita dal client non corrisponde");
		Assert.notNull(result.getMain().getTemp(), "La temperatura è nulla");
		Assert.notNull(result.getWeather(), "Il meteo è nullo");
		Assert.notNull(result.getWeather().size(), "Il meteo ha zero elementi");
	}

}
