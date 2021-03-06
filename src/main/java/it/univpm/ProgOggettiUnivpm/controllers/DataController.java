package it.univpm.ProgOggettiUnivpm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.ProgOggettiUnivpm.models.BaseResponse;
import it.univpm.ProgOggettiUnivpm.models.DataFilters;
import it.univpm.ProgOggettiUnivpm.models.DataResponse;
import it.univpm.ProgOggettiUnivpm.services.DataService;

/**
 * Implementa le API per la consultazione del meteo corrente e le previsoni fino a 5 giorni.
 * 
 *
 */
@RestController
public class DataController {

	@Autowired
	private DataService dataService;

	/**
	 * Restituisce meteo e previsioni per la città, numero di giorni e orario indicati nei parametri.
	 * @param filters Parametri per la ricerca delle condizioni meteo.
	 * @return Condizioni meteo corrente e previsioni per la città richiesta.
	 */
	@GetMapping("/data")
	public @ResponseBody BaseResponse Data(DataFilters filters) {
		try 
		{
			if (filters.getCityName() == null || filters.getCityName().isEmpty())
			{
				BaseResponse response = new BaseResponse();
				response.setSuccess(false);
				response.setMessage("Indicare il nome città, parametro: cityName");
				return response;
			}
			
			if (filters.getHour() < 0 || filters.getHour() > 23)
			{
				BaseResponse response = new BaseResponse();
				response.setSuccess(false);
				response.setMessage("Prametro 'hour' non previsto, indicare un valore compreso tra: 0 e 23");
				return response;
			}
			
			if(filters.getDays() < 1 || filters.getDays() > 5)
			{
				BaseResponse response = new BaseResponse();
				response.setSuccess(false);
				response.setMessage("Prametro 'Days' non previsto, indicare un valore compreso tra: 1 e 5");
				return response;
			}
			
			DataResponse response = dataService.getMeteo(filters);  
			response.setSuccess(true);
			return response;
		}
		
		catch (Exception ex)
		{
			BaseResponse response = new BaseResponse();
			response.setSuccess(false);
			response.setMessage("Errore interno: " + ex.getStackTrace().toString());
			// throw ex;
			return response;
		}
	}
}
