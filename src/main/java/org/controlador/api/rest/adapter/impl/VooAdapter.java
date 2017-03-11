package org.controlador.api.rest.adapter.impl;

import java.util.ArrayList;
import java.util.List;

import org.controlador.api.domain.StatusVoo;
import org.controlador.api.domain.Voo;
import org.controlador.api.rest.adapter.IAdapter;
import org.controlador.api.rest.controller.VooController;
import org.controlador.api.rest.dto.VooDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VooAdapter implements IAdapter<Voo, VooDTO> {

	private final Logger LOG = LoggerFactory.getLogger(VooController.class);

	@Autowired
	private PilotoAdapter pilotoAdapter;
	
	@Autowired
	private AviaoAdapter aviaoAdapter;
	
	@Autowired
	private AeroportoAdapter aeroportoAdapter;
	
	@Override
	public Voo toDomain(VooDTO dto) {
		Voo voo = new Voo();
		String[] ignorarPropriedades = {"aviao", "piloto", "origem", "destino", "status"};
		BeanUtils.copyProperties(dto, voo, ignorarPropriedades);
		voo.setAviao(aviaoAdapter.toDomain(dto.getAviao()));
		voo.setPiloto(pilotoAdapter.toDomain(dto.getPiloto()));
		voo.setOrigem(aeroportoAdapter.toDomain(dto.getOrigem()));
		voo.setDestino(aeroportoAdapter.toDomain(dto.getDestino()));
		voo.setStatus(resolverStatus(dto.getStatus()));
		return voo ;
	}

	private StatusVoo resolverStatus(String status) {		
		try{
			return StatusVoo.valueOf(status);			
		}catch(IllegalArgumentException e){
			LOG.error("Não foi possível encontrar status do voo", e);
		}
	
		return null;
	}

	@Override
	public VooDTO toDto(Voo domain) {
		VooDTO voo = new VooDTO();
		String[] ignorarPropriedades = {"aviao", "piloto", "origem", "destino", "status"};
		BeanUtils.copyProperties(domain, voo, ignorarPropriedades);
		voo.setPiloto(pilotoAdapter.toDto(domain.getPiloto()));
		voo.setAviao(aviaoAdapter.toDto(domain.getAviao()));
		voo.setOrigem(aeroportoAdapter.toDto(domain.getOrigem()));
		voo.setDestino(aeroportoAdapter.toDto(domain.getDestino()));
		voo.setStatus(domain.getStatus().toString());
		return voo ;
	}

	@Override
	public List<Voo> toListDomain(List<VooDTO> dto) {
		List<Voo> domains = new ArrayList<Voo>();
		for (VooDTO vooDTO : dto) {
			domains.add(toDomain(vooDTO));
		}
		return domains;
	}

	@Override
	public List<VooDTO> toListDto(List<Voo> domain) {
		List<VooDTO> dtos = new ArrayList<VooDTO>();
		for (Voo voo : domain) {
			dtos.add(toDto(voo));
		}		
		return dtos;
	}

}
