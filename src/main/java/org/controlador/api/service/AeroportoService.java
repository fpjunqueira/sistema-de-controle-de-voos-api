
package org.controlador.api.service;

import java.util.List;

import org.controlador.api.domain.Aeroporto;
import org.controlador.api.repository.AeroportoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AeroportoService {
	
	private final Logger LOG = LoggerFactory.getLogger(VooService.class);
	
	@Autowired
	private AeroportoRepository repository;
	
	public Aeroporto getAeroporto(Long id) {
		LOG.debug("Consultar Aeroporto service");
		return repository.findById(id);
	}

	public List<Aeroporto> listarAeroportos() {
		LOG.debug("Buscar aeroportos service");
		List<Aeroporto> listAeroportos = repository.findAll();
		return listAeroportos;
	}
}
