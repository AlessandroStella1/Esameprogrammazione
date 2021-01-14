package it.univpm.ProgOggettiUnivpm.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.ProgOggettiUnivpm.models.ow.OpenWeatherCurrentResponse;
import it.univpm.ProgOggettiUnivpm.models.ow.OpenWeatherForecastResponse;
import it.univpm.ProgOggettiUnivpm.services.OpenWeatherClient;

@RestController
public class TestController {

	@GetMapping("/getForecastStringByName")
	public @ResponseBody String getForecastStringByNameTest() {
		String result = OpenWeatherClient.getForecastStringByName("Ancona");
		return result;
	}
	
	@GetMapping("/getForecastByName")
	public @ResponseBody OpenWeatherForecastResponse getForecastByNameTest() {
		OpenWeatherForecastResponse result = OpenWeatherClient.getForecastByName("Ancona");
		return result;
	}
	
	@GetMapping("/getWeatherById")
	public @ResponseBody OpenWeatherCurrentResponse getWeatherByIdTest() {
		OpenWeatherCurrentResponse result = OpenWeatherClient.getWeatherById(2177915L);
		return result;
	}
}
