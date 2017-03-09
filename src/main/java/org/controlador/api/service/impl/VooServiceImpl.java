package org.controlador.api.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.controlador.api.domain.Voo;
import org.controlador.api.exception.ControladorServiceException;
import org.controlador.api.repository.VooRepository;
import org.controlador.api.service.VooService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VooServiceImpl implements VooService {

	private final Logger LOG = LoggerFactory.getLogger(VooServiceImpl.class);
	
	@Autowired
	private VooRepository repository;

	@Override
	public List<Voo> listarVoos() throws ControladorServiceException {
		LOG.debug("Listar Voo service");
		List<Voo> voos = new ArrayList<Voo>();	
		try {
			voos = repository.findAll();
		} catch (Exception e) {
			throw new ControladorServiceException("Falha ao listar voos", e);
		}
		return voos;
	}

	@Override
	public Voo getVoo(Long id) throws ControladorServiceException {
		LOG.debug("consultar Voo service");
		Voo voo = new Voo();
		try {
			voo = repository.findById(id);
		} catch (Exception e) {
			throw new ControladorServiceException("Falha ao consultar voo", e);
		}
		return voo;
	}

	@Override
	public List<Voo> listarVooPorHorarios(Date partida, Date chegada) throws ControladorServiceException {
		LOG.debug("Listar Voo Por Horarios service");
		if (partida.after(chegada)) {
			throw new ControladorServiceException("Partida não pode ser mair que chegada do voo");
		}
		
		List<Voo> voos = new ArrayList<Voo>();
		try {
			voos = repository.findByHorarios(partida, chegada);
		} catch (Exception e) {
			throw new ControladorServiceException("Falha ao consultar voo por horarios", e);
		}
		return voos;
	}	

}
