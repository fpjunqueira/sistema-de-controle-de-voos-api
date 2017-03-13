package org.controlador.api.rest.dto;

public class PilotoDTO {

	private Long id;
	private String nome;
	private String documento;
	private String cma;
	private int horasDeVoo;

	public PilotoDTO() {
	}
	
	public PilotoDTO(Long id, String nome, String documento, String cma, int horasDeVoo) {
		this.id = id;
		this.nome = nome;
		this.documento = documento;
		this.cma = cma;
		this.horasDeVoo = horasDeVoo;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cma == null) ? 0 : cma.hashCode());
		result = prime * result + ((documento == null) ? 0 : documento.hashCode());
		result = prime * result + horasDeVoo;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PilotoDTO other = (PilotoDTO) obj;
		if (cma == null) {
			if (other.cma != null)
				return false;
		} else if (!cma.equals(other.cma))
			return false;
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equals(other.documento))
			return false;
		if (horasDeVoo != other.horasDeVoo)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
}
