package org.controlador.api.rest.adapter.impl;

import java.util.ArrayList;
import java.util.List;

import org.controlador.api.domain.Piloto;
import org.controlador.api.rest.adapter.IAdapter;
import org.controlador.api.rest.dto.PilotoDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class PilotoAdapter implements IAdapter<Piloto, PilotoDTO>{

	@Override
	public Piloto toDomain(PilotoDTO dto) {
		Piloto piloto = new Piloto();
		BeanUtils.copyProperties(dto, piloto);
		return piloto ;
	}

	@Override
	public PilotoDTO toDto(Piloto domain) {
		PilotoDTO piloto = new PilotoDTO();
		BeanUtils.copyProperties(domain, piloto);
		return piloto;
	}

	@Override
	public List<Piloto> toListDomain(List<PilotoDTO> dto) {
		List<Piloto> pilotos = new ArrayList<Piloto>();
		for (PilotoDTO pilotoDTO : dto) {
			pilotos.add(toDomain(pilotoDTO));
		}
		return pilotos;
	}

	@Override
	public List<PilotoDTO> toListDto(List<Piloto> domain) {
		List<PilotoDTO> dtos = new ArrayList<PilotoDTO>();
		for (Piloto piloto : domain) {
			dtos.add(toDto(piloto));
		}
		return dtos;
	}

}
