package org.controlador.api.rest.controller;

import java.util.List;

import org.controlador.api.rest.adapter.impl.PilotoAdapter;
import org.controlador.api.rest.dto.PilotoDTO;
import org.controlador.api.service.PilotoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(method = RequestMethod.GET, value = "/pilotos")
public class PilotoController {
	
    private final Logger LOG = LoggerFactory.getLogger(PilotoController.class);
    
    @Autowired
    private PilotoAdapter adapter;
    
	@Autowired
	private PilotoService service;
			
	@GetMapping("/{id}")
    public PilotoDTO get(@PathVariable Long id) {
		Assert.notNull(id, "Deve informar id");
		LOG.info("Buscando piloto id " + id);
		PilotoDTO piloto = adapter.toDto(service.getPiloto(id));
		LOG.info("Retorno do piloto id " + id);
		return piloto;
	}

	@GetMapping
	public List<PilotoDTO> list() {
		LOG.info("Buscando pilotos");
		List<PilotoDTO> pilotos = adapter.toListDto(service.listarPilotos());
		LOG.info("Retorno busca pilotos");
		return pilotos;
	}

}