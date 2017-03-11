package org.controlador.api.service;

import java.util.ArrayList;
import java.util.List;

import org.controlador.api.domain.Piloto;
import org.controlador.api.repository.PilotoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class PilotoService {

	private final Logger LOG = LoggerFactory.getLogger(PilotoService.class);
	
	@Autowired
	private PilotoRepository repository;
	
	public List<Piloto> listarPilotos() {
		LOG.debug("Listar pilotos service");
		List<Piloto> pilotos = (ArrayList<Piloto>) repository.findAll();
		return pilotos;
	}
	
	public Piloto getPiloto(Long id) {
		Assert.notNull(id, "Deve informar id");
		LOG.debug("Consultar Piloto service");
		return repository.findById(id);
	}
}
