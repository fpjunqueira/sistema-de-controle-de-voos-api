package org.controlador.api.rest.adapter.impl;

import java.util.ArrayList;
import java.util.List;

import org.controlador.api.domain.StatusVoo;
import org.controlador.api.domain.Voo;
import org.controlador.api.rest.adapter.IAdapter;
import org.controlador.api.rest.dto.VooDTO;

public class VooAdapter implements IAdapter<Voo, VooDTO> {

	private PilotoAdapter pilotoAdapter;
	private AviaoAdapter aviaoAdapter;
	private AeroportoAdapter aeroportoAdapter;

	public VooAdapter() {
		this.pilotoAdapter = new PilotoAdapter();
		this.aviaoAdapter = new AviaoAdapter();
		this.aeroportoAdapter = new AeroportoAdapter();
	}
	
	@Override
	public Voo toDomain(VooDTO dto) {
		Voo voo = new Voo();
		voo.setChegada(dto.getChegada());
		voo.setPartida(dto.getPartida());
		voo.setAviao(aviaoAdapter.toDomain(dto.getAviao()));
		voo.setPiloto(pilotoAdapter.toDomain(dto.getPiloto()));
		voo.setOrigem(aeroportoAdapter.toDomain(dto.getOrigem()));
		voo.setDestino(aeroportoAdapter.toDomain(dto.getDestino()));
		voo.setId(dto.getId());
		voo.setStatus(resolverStatus(dto.getStatus()));
		return voo ;
	}

	private StatusVoo resolverStatus(String status) {
		if (StatusVoo.AGENDADO.toString().equals(status)) {
			return StatusVoo.AGENDADO;
		}
		if (StatusVoo.AGUARDANDO_DECOLAGEM.toString().equals(status)) {
			return StatusVoo.AGUARDANDO_DECOLAGEM;
		}
		if (StatusVoo.REALIZADO.toString().equals(status)) {
			return StatusVoo.REALIZADO;
		}
		if (StatusVoo.CANCELADO.toString().equals(status)) {
			return StatusVoo.CANCELADO;
		}
		if (StatusVoo.EM_CURSO.toString().equals(status)) {
			return StatusVoo.AGENDADO;
		}
		return null;
	}

	@Override
	public VooDTO toDto(Voo domain) {
		VooDTO voo = new VooDTO();
		voo.setPartida(domain.getPartida());
		voo.setChegada(domain.getChegada());
		voo.setPiloto(pilotoAdapter.toDto(domain.getPiloto()));
		voo.setAviao(aviaoAdapter.toDto(domain.getAviao()));
		voo.setOrigem(aeroportoAdapter.toDto(domain.getOrigem()));
		voo.setDestino(aeroportoAdapter.toDto(domain.getDestino()));
		voo.setStatus(domain.getStatus().toString());
		voo.setId(domain.getId());
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
}		return dtos;
	}

}
