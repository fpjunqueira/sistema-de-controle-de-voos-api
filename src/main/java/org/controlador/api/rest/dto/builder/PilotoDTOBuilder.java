package org.controlador.api.rest.dto.builder;

import org.controlador.api.rest.dto.PilotoDTO;

public class PilotoDTOBuilder {

	private PilotoDTO dto;

	public PilotoDTOBuilder() {
		this.dto = new PilotoDTO();
	}

	public PilotoDTOBuilder withId(Long id) {
		this.dto.setId(id);
		return this;
	}

	public PilotoDTOBuilder withNome(String nome) {
		this.dto.setNome(nome);
		return this;
	}

	public PilotoDTOBuilder withDocumento(String documento) {
		this.dto.setDocumento(documento);
		return this;
	}

	public PilotoDTOBuilder withCma(String cma) {
		this.dto.setCma(cma);
		return this;
	}

	public PilotoDTOBuilder withHorasDeVoo(int horasDeVoo) {
		this.dto.setHorasDeVoo(horasDeVoo);
		return this;
	}

	public PilotoDTO create(){
		return this.dto;
	}
}

