package org.controlador.api.rest.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VooDTO {

	private Long id;
	private LocalDateTime partida;
	private LocalDateTime chegada;
	private PilotoDTO piloto;
	private AviaoDTO aviao;
	private AeroportoDTO origem;
	private AeroportoDTO destino;
	private String status;

	public VooDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getPartida() {
		return partida;
	}

	public void setPartida(LocalDateTime partida) {
		this.partida = partida;
	}

	public LocalDateTime getChegada() {
		return chegada;
	}

	public void setChegada(LocalDateTime chegada) {
		this.chegada = chegada;
	}

	public PilotoDTO getPiloto() {
		return piloto;
	}

	public void setPiloto(PilotoDTO piloto) {
		this.piloto = piloto;
	}

	public AviaoDTO getAviao() {
		return aviao;
	}

	public void setAviao(AviaoDTO aviao) {
		this.aviao = aviao;
	}

	public AeroportoDTO getOrigem() {
		return origem;
	}

	public void setOrigem(AeroportoDTO origem) {
		this.origem = origem;
	}

	public AeroportoDTO getDestino() {
		return destino;
	}

	public void setDestino(AeroportoDTO destino) {
		this.destino = destino;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String formatarData(LocalDateTime data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		return data.format(formatter);
	}

	public String getHorarioDeChegadaLocal() {
		return formatarData(calcularHorarioLocal(getDestino().getUtc(), getChegada()));
	}

	public String getHorarioDePartidaLocal() {
		return formatarData(calcularHorarioLocal(getOrigem().getUtc(), getPartida()));
	}

	public String getHorarioDeChegadaUTC() {
		return formatarData(this.chegada);
	}

	public String getHorarioDePartidaUTC() {
		return formatarData(this.partida);
	}

	private LocalDateTime calcularHorarioLocal(int utc, LocalDateTime horario) {
		return horario.plusHours(utc);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aviao == null) ? 0 : aviao.hashCode());
		result = prime * result + ((chegada == null) ? 0 : chegada.hashCode());
		result = prime * result + ((destino == null) ? 0 : destino.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((origem == null) ? 0 : origem.hashCode());
		result = prime * result + ((partida == null) ? 0 : partida.hashCode());
		result = prime * result + ((piloto == null) ? 0 : piloto.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		VooDTO other = (VooDTO) obj;
		if (aviao == null) {
			if (other.aviao != null)
				return false;
		} else if (!aviao.equals(other.aviao))
			return false;
		if (chegada == null) {
			if (other.chegada != null)
				return false;
		} else if (!chegada.equals(other.chegada))
			return false;
		if (destino == null) {
			if (other.destino != null)
				return false;
		} else if (!destino.equals(other.destino))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (origem == null) {
			if (other.origem != null)
				return false;
		} else if (!origem.equals(other.origem))
			return false;
		if (partida == null) {
			if (other.partida != null)
				return false;
		} else if (!partida.equals(other.partida))
			return false;
		if (piloto == null) {
			if (other.piloto != null)
				return false;
		} else if (!piloto.equals(other.piloto))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
}
