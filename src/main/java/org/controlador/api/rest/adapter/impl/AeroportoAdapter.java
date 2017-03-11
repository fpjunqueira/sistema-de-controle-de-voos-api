package org.controlador.api.rest.adapter.impl;

import java.util.ArrayList;
import java.util.List;

import org.controlador.api.domain.Aeroporto;
import org.controlador.api.rest.adapter.IAdapter;
import org.controlador.api.rest.dto.AeroportoDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AeroportoAdapter implements IAdapter<Aeroporto, AeroportoDTO> {

	@Override
	public Aeroporto toDomain(AeroportoDTO dto) {
		Aeroporto aeroporto = new Aeroporto();
		BeanUtils.copyProperties(dto, aeroporto);
		return aeroporto;
	}

	@Override
	public AeroportoDTO toDto(Aeroporto domain) {
		AeroportoDTO aeroporto = new AeroportoDTO();
		BeanUtils.copyProperties(domain, aeroporto);
		return aeroporto ;
	}

	@Override
	public List<Aeroporto> toListDomain(List<AeroportoDTO> dto) {
		List<Aeroporto> domains = new ArrayList<Aeroporto>();
		for (AeroportoDTO aeroportoDTO : dto) {
			domains.add(toDomain(aeroportoDTO));
		}
		return domains;
	}

	@Override
	public List<AeroportoDTO> toListDto(List<Aeroporto> domain) {
		List<AeroportoDTO> dtos = new ArrayList<AeroportoDTO>();
		for (Aeroporto aeroporto : domain) {
			dtos.add(toDto(aeroporto));
		}
		return dtos;
	}

}
