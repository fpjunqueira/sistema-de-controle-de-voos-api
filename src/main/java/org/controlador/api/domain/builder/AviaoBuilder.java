package org.controlador.api.domain.builder;

import org.controlador.api.domain.Aviao;

public class AviaoBuilder {

	private Aviao aviao;

	public AviaoBuilder() {
		this.aviao = new Aviao();
	}

	public AviaoBuilder withId(Long id) {
		this.aviao.setId(id);
		return this;
	}

	public AviaoBuilder withModelo(String modelo) {
		this.aviao.setModelo(modelo);
		return this;
	}

	public AviaoBuilder withFabricante(String fabricante) {
		this.aviao.setFabricante(fabricante);
		return this;
	}

	public AviaoBuilder withAno(String ano) {
		this.aviao.setAno(ano);
		return this;
	}

	public AviaoBuilder withRegistro(String registro) {
		this.aviao.setRegistro(registro);
		return this;
	}

	public Aviao create() {
		return this.aviao;
	}
}
