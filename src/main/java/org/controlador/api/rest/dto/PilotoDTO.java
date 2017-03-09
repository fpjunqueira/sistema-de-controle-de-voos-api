package org.controlador.api.rest.dto;

public class PilotoDTO {

	private Long id;
	private String nome;
	private String documento;
	private String cma;

	private int horasDeVoo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getCma() {
		return cma;
	}

	public void setCma(String cma) {
		this.cma = cma;
	}

	public int getHorasDeVoo() {
		return horasDeVoo;
	}

	public void setHorasDeVoo(int horasDeVoo) {
		this.horasDeVoo = horasDeVoo;
	}
}
