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
	
}
