package org.controlador.api.rest.controller;

import java.util.List;

import org.controlador.api.rest.adapter.impl.AeroportoAdapter;
import org.controlador.api.rest.dto.AeroportoDTO;
import org.controlador.api.service.AeroportoService;
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
@RequestMapping(method = RequestMethod.GET, value = "/aeroportos")
public class AeroportoController {
	
	private final Logger LOG = LoggerFactory.getLogger(AeroportoController.class);

	@Autowired
	public AeroportoAdapter adapter;
	
	@Autowired
	public AeroportoService service;
	
	@GetMapping
	public List<AeroportoDTO> list() {
		LOG.info("Buscando aeroportos");
		List<AeroportoDTO> aeroportos = adapter.toListDto(service.listarAeroportos());
		LOG.info("Retorno busca aeroportos");
		return aeroportos;
	}
 
	@GetMapping(path = "/{id}")
	public AeroportoDTO get(@PathVariable Long id) {
		Assert.notNull(id, "Deve informar id");
		LOG.info("Buscando aeroporto id " + id);
		AeroportoDTO aeroporto = adapter.toDto(service.getAeroporto(id));
		LOG.info("Retorno do aeroporto id " + id);
		return aeroporto;
	}
	
}