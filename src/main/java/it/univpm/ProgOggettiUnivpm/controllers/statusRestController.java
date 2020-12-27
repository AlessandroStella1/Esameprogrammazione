package it.univpm.ProgOggettiUnivpm.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.ProgOggettiUnivpm.models.StatusResponse;

@RestController
public class statusRestController {

	@GetMapping("/status")
	public StatusResponse CheckStatus() {
		return new StatusResponse("Ok");
	}
}

