package it.univpm.ProgOggettiUnivpm.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.ProgOggettiUnivpm.models.MetadataResponse;

@RestController
public class MetadataController {
	@GetMapping("/metadata")
	public @ResponseBody MetadataResponse Metadata() {
		return new MetadataResponse();
	}
}
