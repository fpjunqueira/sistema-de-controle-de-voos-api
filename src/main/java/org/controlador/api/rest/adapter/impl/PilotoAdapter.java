package org.controlador.api.rest.adapter.impl;

import java.util.ArrayList;
import java.util.List;

import org.controlador.api.domain.Piloto;
import org.controlador.api.rest.adapter.IAdapter;
import org.controlador.api.rest.dto.PilotoDTO;

public class PilotoAdapter implements IAdapter<Piloto, PilotoDTO>{

	@Override
	public Piloto toDomain(PilotoDTO dto) {
		Piloto piloto = new Piloto();
		piloto.setNome(dto.getNome());
		piloto.setCma(dto.getCma());
		piloto.setDocumento(dto.getDocumento());
		piloto.setHorasDeVoo(dto.getHorasDeVoo());
		piloto.setId(dto.getId());
		return piloto ;
	}

	@Override
	public PilotoDTO toDto(Piloto domain) {
		PilotoDTO piloto = new PilotoDTO();
		piloto.setNome(domain.getNome());
		piloto.setCma(domain.getCma());
		piloto.setDocumento(domain.getDocumento());
		piloto.setHorasDeVoo(domain.getHorasDeVoo());
		piloto.setId(domain.getId());
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
