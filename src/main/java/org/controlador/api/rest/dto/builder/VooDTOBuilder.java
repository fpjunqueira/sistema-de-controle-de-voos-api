package org.controlador.api.rest.dto.builder;

import java.time.LocalDateTime;

import org.controlador.api.rest.dto.AeroportoDTO;
import org.controlador.api.rest.dto.AviaoDTO;
import org.controlador.api.rest.dto.PilotoDTO;
import org.controlador.api.rest.dto.VooDTO;

public class VooDTOBuilder {
	
	private VooDTO vooDTO;
	
	public VooDTOBuilder() {
		this.vooDTO = new VooDTO();
	}

	public VooDTOBuilder setHorarios(LocalDateTime horarioPartida, LocalDateTime horarioChegada) {
		this.vooDTO.setPartida(horarioPartida);
		this.vooDTO.setChegada(horarioChegada);
		return this;
	}
	
	public VooDTOBuilder setHorarioPartida(LocalDateTime horarioPartida) {
		this.vooDTO.setPartida(horarioPartida);
		return this;
	}
	
	public VooDTOBuilder setHorarioChegada(LocalDateTime horarioChegada) {
		this.vooDTO.setChegada(horarioChegada);
		return this;
	}
	
	public VooDTOBuilder setOrigemDestino(AeroportoDTO origem, AeroportoDTO destino) {
		this.vooDTO.setOrigem(origem);
		this.vooDTO.setDestino(destino);
		return this;
	}
	
	public VooDTOBuilder setAviao(AviaoDTO aviao) {
		this.vooDTO.setAviao(aviao);
		return this;
	}
	
	public VooDTOBuilder setPiloto(PilotoDTO piloto) {
		vooDTO.setPiloto(piloto);
		return this;
	}
	
	public VooDTOBuilder setPiloto(String status) {
		vooDTO.setStatus(status);
		return this;
	}
	
	public VooDTO build() {
		return this.vooDTO;
	}

}
