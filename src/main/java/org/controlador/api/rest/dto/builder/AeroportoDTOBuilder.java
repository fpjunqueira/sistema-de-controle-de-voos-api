package org.controlador.api.rest.dto.builder;

import org.controlador.api.rest.dto.AeroportoDTO;

public class AeroportoDTOBuilder {

	private AeroportoDTO aeroporto;
	
	public AeroportoDTOBuilder() {
		this.aeroporto = new AeroportoDTO();
	}

	public AeroportoDTOBuilder withId(Long id) {
		this.aeroporto.setId(id);
		return this;
	}

	public AeroportoDTOBuilder withIata(String iata) {
		this.aeroporto.setIata(iata);
		return this;
	}
	
	public AeroportoDTOBuilder withIcao(String icao) {
		this.aeroporto.setIcao(icao);
		return this;
	}
	
	public AeroportoDTOBuilder withNome(String nome) {
		this.aeroporto.setNome(nome);
		return this;
	}

	public AeroportoDTOBuilder withCidade(String cidade) {
		this.aeroporto.setCidade(cidade);
		return this;
	}

	public AeroportoDTOBuilder withUf(String uf) {
		this.aeroporto.setUf(uf);
		return this;
	}

	public AeroportoDTOBuilder withPais(String pais) {
		this.aeroporto.setPais(pais);
		return this;
	}
	
	public AeroportoDTOBuilder withUtc(int utc) {
		this.aeroporto.setUtc(utc);
		return this;
	}
	
	public AeroportoDTOBuilder withLatitude(Double latitude) {
		this.aeroporto.setLatitude(latitude);
		return this;
	}
	
}
