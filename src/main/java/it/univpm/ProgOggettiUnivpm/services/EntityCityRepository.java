package it.univpm.ProgOggettiUnivpm.services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.univpm.ProgOggettiUnivpm.models.EntityCity;

/*
 * Repository delle città per cui è attivo il monitoraggio 
 */

@Repository
public interface EntityCityRepository extends CrudRepository<EntityCity, Long> {
}
