package it.univpm.ProgOggettiUnivpm.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.ProgOggettiUnivpm.models.MetadataResponse;

/**
 * Restituisce l'elenco e le descrizioni delle chiavi json generate dalle risposte dei servizi.
 * @author
 *
 */
@RestController
public class MetadataController {
	
	/**
	 * Restituisce l'elenco delle chiavi json previste.
	 * @return 
	 */
	@GetMapping("/metadata")
	public @ResponseBody MetadataResponse Metadata() {
		return new MetadataResponse();
	}
}
