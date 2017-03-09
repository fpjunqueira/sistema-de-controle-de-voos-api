package org.controlador.api.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "piloto")
public class Piloto implements Serializable {

	private static final long serialVersionUID = 3948422488740192186L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String documento;
	
	@NotNull
	private String cma;
	
	@NotNull
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
