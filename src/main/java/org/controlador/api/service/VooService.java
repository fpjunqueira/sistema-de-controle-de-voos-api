package org.controlador.api.service;

import java.time.LocalDateTime;
import java.util.List;

import org.controlador.api.domain.Voo;
import org.controlador.api.repository.VooRepository;
import org.dom4j.IllegalAddException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class VooService {

	private final Logger LOG = LoggerFactory.getLogger(VooService.class);
	
	@Autowired
	private VooRepository repository;

	public List<Voo> listarVoos(){
		LOG.debug("Listar Voo service");
		return repository.findAll();
	}

	public Voo getVoo(Long id) {
		Assert.notNull(id, "Deve informar id");
		LOG.debug("Consultar Voo service");
		return repository.findById(id);		
	}

	public List<Voo> listarVoosPorHorarios(LocalDateTime decolagem, LocalDateTime pouso) {
		Assert.notNull(decolagem);
		Assert.notNull(pouso);
		LOG.debug("Listar Voo Por Horarios service");
		if (decolagem.isAfter(pouso)) {
			throw new IllegalAddException("Hora de descolagem deve ser menor que hora de pouso do voo");
		}	
		return repository.findByHorarios(decolagem, pouso);
	}	
}
