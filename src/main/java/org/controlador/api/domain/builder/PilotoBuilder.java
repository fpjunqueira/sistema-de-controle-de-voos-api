package org.controlador.api.domain.builder;

import org.controlador.api.domain.Piloto;

public class PilotoBuilder {

	private Piloto piloto;

	public PilotoBuilder() {
		this.piloto = new Piloto();
	}

	public PilotoBuilder withId(Long id) {
		this.piloto.setId(id);
		return this;
	}

	public PilotoBuilder withNome(String nome) {
		this.piloto.setNome(nome);
		return this;
	}

	public PilotoBuilder withDocumento(String documento) {
		this.piloto.setDocumento(documento);
		return this;
	}

	public PilotoBuilder withCma(String cma) {
		this.piloto.setCma(cma);
		return this;
	}

	public PilotoBuilder withHorasDeVoo(int horasDeVoo) {
		this.piloto.setHorasDeVoo(horasDeVoo);
		return this;
	}

	public Piloto create() {
		return this.piloto;
	}
}
