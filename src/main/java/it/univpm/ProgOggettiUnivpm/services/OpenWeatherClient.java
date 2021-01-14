package it.univpm.ProgOggettiUnivpm.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import it.univpm.ProgOggettiUnivpm.models.ow.OpenWeatherCurrentResponse;
import it.univpm.ProgOggettiUnivpm.models.ow.OpenWeatherForecastResponse;

/**
 * Classe di integrazione verso i servizi https://openweathermap.org/api, implementa le chiamate di base.
 */

@Component
public class OpenWeatherClient {

	@Autowired
	public static ProgOggettiUnivpmConfiguration cityWeatherConfiguration;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(OpenWeatherClient.class);
	
	private static final ProgOggettiUnivpmConfiguration configuration = ProgOggettiUnivpmConfiguration.getInstance();

	/**
	 * Titolo del servizio: 5 Day / 3 Hour Forecast
	 * Dettagli del servizio su https://openweathermap.org/forecast5
	 * Restituisce le previsioni meteo a 5 giorni per la città richiesta
	 * @param cityName Nome della città richiesta
	 * @return Previsioni meteo a 5 giorni
	 */
	public static String getForecastStringByName(String cityName)
	{
		LOGGER.info("OpenWeatherClient.getForecastStringByName");
	    final String uri = String.format("http://api.openweathermap.org/data/2.5/forecast?q=%s&appid=%s&units=metric", cityName, configuration.getApiKey());
	    RestTemplate restTemplate = new RestTemplate();	 
	    String result = restTemplate.getForObject(uri, String.class);
	    System.out.println(result);
	    return result;
	}
	
	/**
	 * Titolo del servizio: 5 Day / 3 Hour Forecast
	 * Dettagli del servizio su https://openweathermap.org/forecast5
	 * Restituisce le previsioni meteo a 5 giorni per la città richiesta
	 * @param cityName Nome della città richiesta
	 * @return Previsioni meteo a 5 giorni
	 */
	public static OpenWeatherForecastResponse getForecastByName(String cityName) 
	{
		LOGGER.info("OpenWeatherClient.getForecastByName");
		final String uri = String.format("http://api.openweathermap.org/data/2.5/forecast?q=%s&appid=%s&units=metric", cityName, configuration.getApiKey());
	    RestTemplate restTemplate = new RestTemplate();	 
	    OpenWeatherForecastResponse result = restTemplate.getForObject(uri, OpenWeatherForecastResponse.class);
	    System.out.println(result);
	    return result;
	}

	/**
	 * Titolo del servizio: 5 Day / 3 Hour Forecast
	 * Dettagli del servizio su https://openweathermap.org/current
	 * @param cityId Identificativo della città richiesta
	 * @return Previsioni meteo a 5 giorni
	 */
	public static OpenWeatherForecastResponse getForecastById(Long cityId)
	{
		LOGGER.info("OpenWeatherClient.getForecastById");
		final String uri = String.format("http://api.openweathermap.org/data/2.5/forecast?id=%s&appid=%s&units=metric", cityId, configuration.getApiKey());
	    RestTemplate restTemplate = new RestTemplate();	 
	    OpenWeatherForecastResponse result = restTemplate.getForObject(uri, OpenWeatherForecastResponse.class);
	    System.out.println(result);
	    return result;
	}

	/**
	 * Titolo del servizio: Current Weather Data
	 * Dettagli del servizio su https://openweathermap.org/current
	 * Restituisce il meteo corrente della città indicata in input
	 * @param cityId Identificativo della città richiesta
	 * @return Meteo corrente
	 */
	public static OpenWeatherCurrentResponse getWeatherById(Long cityId)
	{
		LOGGER.info("OpenWeatherClient.getWeatherById");
		final String uri = String.format("http://api.openweathermap.org/data/2.5/weather?id=%s&appid=%s&units=metric", cityId, configuration.getApiKey());
	    RestTemplate restTemplate = new RestTemplate();	 
	    OpenWeatherCurrentResponse result = restTemplate.getForObject(uri, OpenWeatherCurrentResponse.class);
	    System.out.println(result);
	    return result;
	}

	/**
	 * Titolo del servizio: Current Weather Data
	 * Dettagli del servizio su https://openweathermap.org/current
	 * Restituisce il meteo corrente della città indicata in input
	 * @param cityName Nome della città richiesta
	 * @return Meteo corrente
	 */
	public static OpenWeatherCurrentResponse getWeatherByName(String cityName)
	{
		LOGGER.info("OpenWeatherClient.getWeatherByName");
		final String uri = String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric", cityName, configuration.getApiKey());
	    RestTemplate restTemplate = new RestTemplate();	 
	    OpenWeatherCurrentResponse result = restTemplate.getForObject(uri, OpenWeatherCurrentResponse.class);
	    System.out.println(result);
	    return result;
	}
		
		
}
