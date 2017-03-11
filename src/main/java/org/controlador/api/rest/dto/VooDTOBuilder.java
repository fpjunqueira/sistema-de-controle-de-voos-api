package org.controlador.api.rest.dto;

import java.util.Date;

public class VooDTOBuilder {
	
	private VooDTO vooDTO;
	
	public VooDTOBuilder() {
		this.vooDTO = new VooDTO();
	}

	public VooDTOBuilder setHorarios(Date horarioPartida, Date horarioChegada) {
		this.vooDTO.setPartida(horarioPartida);
		this.vooDTO.setChegada(horarioChegada);
		return this;
	}
	
	public VooDTOBuilder setHorarioPartida(Date horarioPartida) {
		this.vooDTO.setPartida(horarioPartida);
		return this;
	}
	
	public VooDTOBuilder setHorarioChegada(Date horarioChegada) {
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
