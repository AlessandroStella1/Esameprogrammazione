package it.univpm.ProgOggettiUnivpm.models;

import java.time.LocalDateTime;

/**
 * Classe di risposta del servizio del controllo dello stato.
 *
 */

public class StatusResponse {

	private String Status;
	private LocalDateTime LastCheck;
		
	public StatusResponse(String status) {
		this.Status = status;
		this.LastCheck = LocalDateTime.now();
	}

	public LocalDateTime getLastCheck() {
		return LastCheck;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
}
