package it.univpm.ProgOggettiUnivpm.services;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.univpm.ProgOggettiUnivpm.models.EntityWeatherSample;
 
/*
 * Respository delle condizioni meteo salvate ogni ora
 */

@Repository
public interface EntityWeatherSampleRepository extends CrudRepository<EntityWeatherSample, Long> {
	List<EntityWeatherSample> findByCityId(@Param("cityId") Long cityId);
	List<EntityWeatherSample> findByCityIdAndDateAndForecastDays(@Param("cityId") Long cityId, @Param("date") LocalDateTime date, @Param("forecast_days") Integer forecastDays);
	List<EntityWeatherSample> findByCityIdAndForecastDaysAndDateGreaterThanEqual(@Param("cityId") Long cityId, @Param("forecast_days") Integer forecastDays, @Param("date") LocalDateTime date);
	List<EntityWeatherSample> findByForecastDaysAndDateGreaterThanEqual(@Param("forecast_days") Integer forecastDays, @Param("date") LocalDateTime date);
}
