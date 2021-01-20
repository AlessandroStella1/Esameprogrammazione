package it.univpm.ProgOggettiUnivpm.controllers;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.ProgOggettiUnivpm.models.BaseResponse;
import it.univpm.ProgOggettiUnivpm.models.EntityWeatherSample;
import it.univpm.ProgOggettiUnivpm.models.StatsFilters;
import it.univpm.ProgOggettiUnivpm.models.StatsFilters.PeriodType;
import it.univpm.ProgOggettiUnivpm.services.EntityWeatherSampleRepository;
import it.univpm.ProgOggettiUnivpm.services.StatsService;

@RestController
public class StatisticsController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StatisticsController.class);

	@Autowired
	private EntityWeatherSampleRepository entityWeatherSampleRepository;

	@GetMapping("/statistics")
	public @ResponseBody BaseResponse Statistic(StatsFilters filters) {
		BaseResponse response = null;
		try
		{
			LocalDateTime startDate = LocalDateTime.now();
			if (filters.getPeriodType() == PeriodType.DAY) {
				startDate = startDate.truncatedTo(ChronoUnit.HOURS);
			}
			else if (filters.getPeriodType() == PeriodType.WEEK) {
				startDate = startDate.truncatedTo(ChronoUnit.WEEKS);
			}
			else if (filters.getPeriodType() == PeriodType.MONTH) {
				startDate = startDate.truncatedTo(ChronoUnit.MONTHS);
			}
			
			List<EntityWeatherSample> samples = null;
			if (filters.getCityId() != null) {
				// statistiche su tutte le rilevazioni a partire dalla data per la città richiesta
				samples = entityWeatherSampleRepository.findByCityIdAndForecastDaysAndDateGreaterThanEqual(filters.getCityId(), 0, startDate);
			}
			else {
				// statistiche su tutte le rilevazioni a partire dalla data
				samples = entityWeatherSampleRepository.findByForecastDaysAndDateGreaterThanEqual(0, startDate);
			}

			if (samples.size() == 0) {
				response = new BaseResponse();
				response.setMessage("Dati richiesti non presenti");
				response.setSuccess(true);
			}
			else
			{
				StatsService statsService = new StatsService(samples);
				response = statsService.analyzePeriods();
				response.setSuccess(true);
			}
		}
		catch (Exception ex){
			response.setSuccess(false);
			response.setMessage(ex.getMessage());
			
			LOGGER.error(ex.getMessage());
			LOGGER.error(ex.getStackTrace().toString());
		}
		return response;
	}
}
