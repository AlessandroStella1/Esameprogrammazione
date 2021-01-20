package it.univpm.ProgOggettiUnivpm.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe di base per le risposte dei servizi, restituisce l'esito dell'elaborazione e 
 * l'eventuale messaggio di errore.
 *
 */
public class BaseResponse {
	/**
	 * Esito dell'elaborazione: true in caso di esito positivo e false in caso di errore. 
	 */
	private Boolean success;
	/**
	 * Messaggio di errore.
	 */
	private String message;
	
	@JsonProperty("success")
	public Boolean getSuccess() {
		return success;
	}
	
	@JsonProperty("success")
	public void setSuccess(Boolean result) {
		this.success = result;
	}
	
	@JsonProperty("message")
	public String getMessage() {
		return message;
	}
	
	@JsonProperty("message")
	public void setMessage(String message) {
		this.message = message;
	}
	
}
