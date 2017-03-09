package org.controlador.api.rest.controller;

import java.util.List;

import org.controlador.api.domain.Piloto;
import org.controlador.api.repository.PilotoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PilotoController {
	
    private final Logger LOG = LoggerFactory.getLogger(PilotoController.class);
    
	@Autowired
	PilotoRepository repository;
			
	@RequestMapping(method = RequestMethod.GET, value = "/piloto/{id}")
    public Piloto get(@PathVariable Long id) {
		LOG.info("GET /piloto/" + id);
		Piloto piloto = null;
		try {
			piloto = repository.findById(id);
		} catch (Exception e) {
			LOG.error("Falha ao consultar piloto", e);
		}
		return piloto;
    }

	@RequestMapping(method = RequestMethod.GET, value = "/piloto")
	public List<Piloto> list() {
		LOG.info("GET /piloto/" );
		List<Piloto> all = null;
		try {
			all = repository.findAll();
		} catch (Exception e) {
			LOG.error("Falha ao consultar piloto", e);
		}
		return all;
	}

}