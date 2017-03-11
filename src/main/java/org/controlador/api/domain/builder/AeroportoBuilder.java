package org.controlador.api.domain.builder;

import org.controlador.api.rest.dto.AeroportoDTO;

public class AeroportoBuilder {

	private AeroportoDTO dto;
	
	public AeroportoBuilder() {
		this.dto = new AeroportoDTO();
	}

	public AeroportoBuilder setId(Long id) {
		this.dto.setId(id);
		return this;
	}

	public AeroportoBuilder setIata(String iata) {
		this.dto.setIata(iata);
		return this;
	}
	
	public AeroportoBuilder setIcao(String icao) {
		this.dto.setIcao(icao);
		return this;
	}
	
	public AeroportoBuilder setNome(String nome) {
		this.dto.setNome(nome);
		return this;
	}

	public AeroportoBuilder setCidade(String cidade) {
		this.dto.setCidade(cidade);
		return this;
	}

	public AeroportoBuilder setUf(String uf) {
		this.dto.setUf(uf);
		return this;
	}

	public AeroportoBuilder setPais(String pais) {
		this.dto.setPais(pais);
		return this;
	}
	
	public AeroportoBuilder setUtc(int utc) {
		this.dto.setUtc(utc);
		return this;
	}
	
	public AeroportoBuilder setLatitude(Double latitude) {
		this.dto.setLatitude(latitude);
		return this;
	}
	
}
