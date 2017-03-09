package org.controlador.api.service;

import java.util.Date;
import java.util.List;

import org.controlador.api.domain.Voo;
import org.controlador.api.exception.ControladorServiceException;

public interface VooService {
	
	public List<Voo> listarVoos() throws ControladorServiceException;
	
	public Voo getVoo(Long id) throws ControladorServiceException;
	
	public List<Voo> listarVooPorHorarios(Date partida, Date chegada) throws ControladorServiceException;

}
