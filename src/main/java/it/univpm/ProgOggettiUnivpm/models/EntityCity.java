package it.univpm.ProgOggettiUnivpm.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe di accesso al database per le entità city.
 * @author 
 *
 */

@Entity
@Table(name="cw_cities")
public class EntityCity {
	
	public EntityCity() {
		this.recordDate = LocalDateTime.now();
	}
	
	public EntityCity(Long cityId) {
		this.id = cityId;
		this.recordDate = LocalDateTime.now();
	}
	
	@Id
	private Long id;
	
	@Column(name="record_date")
	private LocalDateTime recordDate;
	
	@Column(name="city_name")
	private String cityIName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(LocalDateTime recordDate) {
		this.recordDate = recordDate;
	}

	public String getCityIName() {
		return cityIName;
	}

	public void setCityIName(String cityIName) {
		this.cityIName = cityIName;
	}
}
