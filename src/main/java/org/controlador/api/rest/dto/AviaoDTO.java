package org.controlador.api.rest.dto;

public class AviaoDTO {

	private Long id;
	private String modelo;
	private String fabricante;
	private String ano;
	private String registro;
	
	public AviaoDTO() {
	}
	
	public AviaoDTO(Long id, String modelo, String fabricante, String ano, String registro) {
		this.id = id;
		this.modelo = modelo;
		this.fabricante = fabricante;
		this.ano = ano;
		this.registro = registro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

}
