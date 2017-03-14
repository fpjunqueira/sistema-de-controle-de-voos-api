package org.controlador.api.rest.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.controlador.api.rest.adapter.impl.VooAdapter;
import org.controlador.api.rest.dto.VooDTO;
import org.controlador.api.service.VooService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
			@RequestParam(value = "dataInicial", required = false) String dataInicial,
			@RequestParam(value = "dataFinal", required = false) String dataFinal) {
		LOG.info("Buscando voos com decolagem entre " + dataInicial + " e " + dataFinal);
		
		List<VooDTO> todos = new ArrayList<VooDTO>();
		if (StringUtils.isEmpty(dataInicial) || StringUtils.isEmpty(dataFinal)) {
			todos = vooAdapter.toListDto(service.listarVoos());
		} else {
			todos = vooAdapter.toListDto(service.listarVoosPorHorarios(getLocalDateTime(dataInicial), getLocalDateTime(dataFinal)));
		}
		LOG.info("Retornando voos com decolagem " + dataInicial + "e chegada" + dataFinal);
		return todos;

	}
	
	private LocalDateTime getLocalDateTime(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		return LocalDateTime.parse(date, formatter);
	}

	@GetMapping(path = "/{id}")
	public VooDTO get(@PathVariable Long id) {
		LOG.info("Buscando voo id " + id);
		VooDTO voo = vooAdapter.toDto(service.getVoo(id));		
		LOG.info("Retorno do voo id " + id);
		return voo;
	}

}
