package org.controlador.api.domain.builder;

import org.controlador.api.domain.Aeroporto;

public class AeroportoBuilder {

	private Aeroporto aeroporto;

	public AeroportoBuilder() {
		this.aeroporto = new Aeroporto();
	}

	public AeroportoBuilder withId(Long id) {
		this.aeroporto.setId(id);
		return this;
	}

	public AeroportoBuilder withIata(String iata) {
		this.aeroporto.setIata(iata);
		return this;
	}

	public AeroportoBuilder withIcao(String icao) {
		this.aeroporto.setIcao(icao);
		return this;
	}

	public AeroportoBuilder withNome(String nome) {
		this.aeroporto.setNome(nome);
		return this;
	}

	public AeroportoBuilder withCidade(String cidade) {
		this.aeroporto.setCidade(cidade);
		return this;
	}

	public AeroportoBuilder withUf(String uf) {
		this.aeroporto.setUf(uf);
		return this;
	}

	public AeroportoBuilder withPais(String pais) {
		this.aeroporto.setPais(pais);
		return this;
	}

	public AeroportoBuilder withUtc(int utc) {
		this.aeroporto.setUtc(utc);
		return this;
	}

	public AeroportoBuilder withLatitude(Double latitude) {
		this.aeroporto.setLatitude(latitude);
		return this;
	}

	public AeroportoBuilder withLongitude(Double longitude) {
		this.aeroporto.setLongitude(longitude);
		return this;
	}

	public Aeroporto create() {
		return this.aeroporto;
	}

}
