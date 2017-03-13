package org.controlador.api.rest.dto.builder;

import org.controlador.api.rest.dto.AviaoDTO;

public class AviaoDTOBuilder {

	private AviaoDTO dto;

	public AviaoDTOBuilder() {
		this.dto = new AviaoDTO();
	}

	public AviaoDTOBuilder withId(Long idAviao) {
		dto.setId(idAviao);
		return this;
	}

	public AviaoDTOBuilder withModelo(String modelo) {
		dto.setModelo(modelo);
		return this;
	}

	public AviaoDTOBuilder withFabricante(String fabricante) {
		dto.setFabricante(fabricante);
		return this;
	}

	public AviaoDTOBuilder withAno(String ano) {
		dto.setAno(ano);
		return this;
	}

	public AviaoDTOBuilder withRegistro(String registro) {
		dto.setRegistro(registro);
		return this;
	}

	public AviaoDTO create() {
		return this.dto;
	}

}
