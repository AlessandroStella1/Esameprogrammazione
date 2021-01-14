package it.univpm.ProgOggettiUnivpm.services;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.univpm.ProgOggettiUnivpm.exceptions.InvalidConfigurationException;

/**
 * Classe contenente la configurazione di base.
 * La configurazione viene letta dal file json passato alla funzione "Load",
 * in genere il file di configurazione è config.json presente nel percorso principale del progetto
 */
public final class ProgOggettiUnivpmConfiguration {
	
	private ProgOggettiUnivpmConfiguration() {}
	
	private static final ProgOggettiUnivpmConfiguration INSTANCE = new ProgOggettiUnivpmConfiguration();
	
	public static ProgOggettiUnivpmConfiguration getInstance() {
        return INSTANCE;
    }

	/**
	 *  Elenco delle città in base al contenuto di city.list.json
	 */
	private List<Long> cities ;
	
	/**
	 * Chiave privata per l'accesso alle API di Openweather
	 */
	private String apiKey;
	
	public Boolean validConfiguration() {
		return apiKey != "";
	}
	
	@JsonProperty("apiKey")
	public String getApiKey() {
		return this.apiKey;
	}

	@JsonProperty("apiKey")
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	@JsonProperty("cities")
	public List<Long> getCities() {
		return this.cities;
	}

	@JsonProperty("cities")
	public void setCities(List<Long> cities) {
		this.cities = cities;
	}

	/**
	 * Carica la configurazione di base del progetto
	 * @param filePath Percorso del file di configurazione
	 * @throws InvalidConfigurationException Errore nella lettura del file di configurazione
	 */
	public static void Load(String filePath) throws InvalidConfigurationException {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			ProgOggettiUnivpmConfiguration config = objectMapper.readValue(new File(filePath), ProgOggettiUnivpmConfiguration.class);
			ProgOggettiUnivpmConfiguration.getInstance().setApiKey(config.getApiKey());
			ProgOggettiUnivpmConfiguration.getInstance().setCities(config.getCities());
			
			if (config.getApiKey() == "")
				throw new InvalidConfigurationException("File di configurazione non valido: apiKey mancante");
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new InvalidConfigurationException("File di configurazione non valido: " + e.getMessage());
		}
	}
}