package org.controlador.api.rest.controller;

import java.util.Date;
import java.util.List;

import org.controlador.api.exception.ControladorServiceException;
import org.controlador.api.rest.adapter.impl.VooAdapter;
import org.controlador.api.rest.dto.VooDTO;
import org.controlador.api.service.VooService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VooController {

	private final Logger LOG = LoggerFactory.getLogger(VooController.class);

	private VooAdapter vooAdapter;

	@Autowired
	VooService service;

	public VooController() {
		vooAdapter = new VooAdapter();
	}	

	@RequestMapping(method = RequestMethod.GET, value = "/voo")
	public List<VooDTO> list(@RequestParam(value = "decolagem", required = false) Date decolagem,
			@RequestParam(value = "pouso", required = false) Date pouso) throws ControladorServiceException {
		List<VooDTO> todos = null;
		if (decolagem != null && pouso != null) {
			LOG.info("GET /voo?partida=" + decolagem + "&chegada" + pouso);
			todos = vooAdapter.toListDto(service.listarVooPorHorarios(decolagem, pouso));
		} else {
			LOG.info("GET /voo");
			todos = vooAdapter.toListDto(service.listarVoos());
		}
		return todos;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/voo/{id}")
	public VooDTO get(@PathVariable Long id) {
		LOG.info("GET /voo/" + id);
		VooDTO voo = null;
		try {
			voo = vooAdapter.toDto(service.getVoo(id));
		} catch (Exception e) {
			LOG.error("Falha ao consultar voo", e);
		}
		return voo;
	}

}
