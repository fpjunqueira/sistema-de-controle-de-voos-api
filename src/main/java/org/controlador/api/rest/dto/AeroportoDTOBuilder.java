package org.controlador.api.rest.dto;

public class AeroportoDTOBuilder {

	private AeroportoDTO dto;
	
	public AeroportoDTOBuilder() {
		this.dto = new AeroportoDTO();
	}

	public AeroportoDTOBuilder setId(Long id) {
		this.dto.setId(id);
		return this;
	}

	public AeroportoDTOBuilder setIata(String iata) {
		this.dto.setIata(iata);
		return this;
	}
	
	public AeroportoDTOBuilder setIcao(String icao) {
		this.dto.setIcao(icao);
		return this;
	}
	
	public AeroportoDTOBuilder setNome(String nome) {
		this.dto.setNome(nome);
		return this;
	}

	public AeroportoDTOBuilder setCidade(String cidade) {
		this.dto.setCidade(cidade);
		return this;
	}

	public AeroportoDTOBuilder setUf(String uf) {
		this.dto.setUf(uf);
		return this;
	}

	public AeroportoDTOBuilder setPais(String pais) {
		this.dto.setPais(pais);
		return this;
	}
	
	public AeroportoDTOBuilder setUtc(String utc) {
		this.dto.setUtc(utc);
		return this;
	}
	
	public AeroportoDTOBuilder setLatitude(Double latitude) {
		this.dto.setLatitude(latitude);
		return this;
	}
	
}
