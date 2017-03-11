package org.controlador.api.rest.controller;

import java.util.Date;
import java.util.List;

import org.controlador.api.rest.adapter.impl.VooAdapter;
import org.controlador.api.rest.dto.VooDTO;
import org.controlador.api.service.VooService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(method = RequestMethod.GET, value = "/voos")
public class VooController {

	private final Logger LOG = LoggerFactory.getLogger(VooController.class);

	@Autowired
	private VooAdapter vooAdapter;

	@Autowired
	private VooService service;

	@GetMapping
	public List<VooDTO> list(
			@RequestParam(value = "decolagem", required = false) Date decolagem,
			@RequestParam(value = "pouso", required = false) Date pouso) {
		LOG.info("Buscando voos com decolagem " + decolagem + "e chegada" + pouso);
		List<VooDTO> todos = vooAdapter.toListDto(service.listarVoosPorHorarios(decolagem, pouso));
		LOG.info("Retornando voos com decolagem " + decolagem + "e chegada" + pouso);
		return todos;

	}
	
	@GetMapping(path = "/{id}")
	public VooDTO get(@PathVariable Long id) {
		LOG.info("Buscando voo id " + id);
		VooDTO voo = vooAdapter.toDto(service.getVoo(id));		
		LOG.info("Retorno do voo id " + id);
		return voo;
	}

}
