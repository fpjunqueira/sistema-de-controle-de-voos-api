package org.controlador.api.rest.adapter.impl;

import java.util.ArrayList;
import java.util.List;

import org.controlador.api.domain.Aviao;
import org.controlador.api.rest.adapter.IAdapter;
import org.controlador.api.rest.dto.AviaoDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AviaoAdapter implements IAdapter<Aviao, AviaoDTO>{

	@Override
	public Aviao toDomain(AviaoDTO dto) {
		Aviao aviao = new Aviao();
		BeanUtils.copyProperties(dto, aviao);
		return aviao;
	}

	@Override
	public AviaoDTO toDto(Aviao domain) {
		AviaoDTO aviao = new AviaoDTO();
		BeanUtils.copyProperties(domain, aviao);
		return aviao;
	}

	@Override
	public List<Aviao> toListDomain(List<AviaoDTO> dto) {
		List<Aviao> domains = new ArrayList<>();
		for (AviaoDTO aviaoDTO : dto) {
			domains.add(toDomain(aviaoDTO));
		}
		return domains;
	}

	@Override
	public List<AviaoDTO> toListDto(List<Aviao> domain) {
		List<AviaoDTO> dtos = new ArrayList<AviaoDTO>();
		for (Aviao aviao : domain) {
			dtos.add(toDto(aviao));
		}
		return dtos;
	}

}
