package org.controlador.api.rest.adapter.impl;

import java.util.ArrayList;
import java.util.List;

import org.controlador.api.domain.Aeroporto;
import org.controlador.api.rest.adapter.IAdapter;
import org.controlador.api.rest.dto.AeroportoDTO;

public class AeroportoAdapter implements IAdapter<Aeroporto, AeroportoDTO> {

	@Override
	public Aeroporto toDomain(AeroportoDTO dto) {
		Aeroporto aeroporto = new Aeroporto();
		aeroporto.setCidade(dto.getCidade());
		aeroporto.setIata(dto.getIata());
		aeroporto.setIcao(dto.getIcao());
		aeroporto.setId(dto.getId());
		aeroporto.setLatitude(dto.getLatitude());
		aeroporto.setLongitude(dto.getLongitude());
		aeroporto.setNome(dto.getNome());
		aeroporto.setPais(dto.getPais());
		aeroporto.setUf(dto.getUf());
		aeroporto.setUtc(dto.getUtc());
		return aeroporto;
	}

	@Override
	public AeroportoDTO toDto(Aeroporto domain) {
		AeroportoDTO aeroporto = new AeroportoDTO();
		aeroporto.setCidade(domain.getCidade());
		aeroporto.setIata(domain.getIata());
		aeroporto.setIcao(domain.getIcao());
		aeroporto.setId(domain.getId());
		aeroporto.setLatitude(domain.getLatitude());
		aeroporto.setLongitude(domain.getLongitude());
		aeroporto.setNome(domain.getNome());
		aeroporto.setPais(domain.getPais());
		aeroporto.setUf(domain.getUf());
		aeroporto.setUtc(domain.getUtc());
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
