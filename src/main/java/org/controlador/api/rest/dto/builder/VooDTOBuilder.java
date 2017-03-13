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
	
	public VooDTOBuilder withId(Long id) {
		this.vooDTO.setId(id);
		return this;
	} 

	public VooDTOBuilder withHorarios(LocalDateTime horarioPartida, LocalDateTime horarioChegada) {
		this.vooDTO.setPartida(horarioPartida);
		this.vooDTO.setChegada(horarioChegada);
		return this;
	}
	
	public VooDTOBuilder withHorarioPartida(LocalDateTime horarioPartida) {
		this.vooDTO.setPartida(horarioPartida);
		return this;
	}
	
	public VooDTOBuilder withHorarioChegada(LocalDateTime horarioChegada) {
		this.vooDTO.setChegada(horarioChegada);
		return this;
	}
	
	public VooDTOBuilder withOrigemDestino(AeroportoDTO origem, AeroportoDTO destino) {
		this.vooDTO.setOrigem(origem);
		this.vooDTO.setDestino(destino);
		return this;
	}
	
	public VooDTOBuilder withAviao(AviaoDTO aviao) {
		this.vooDTO.setAviao(aviao);
		return this;
	}
	
	public VooDTOBuilder withPiloto(PilotoDTO piloto) {
		vooDTO.setPiloto(piloto);
		return this;
	}
	
	public VooDTOBuilder withStatus(String status) {
		vooDTO.setStatus(status);
		return this;
	}
	
	public VooDTO create() {
		return this.vooDTO;
	}

}
