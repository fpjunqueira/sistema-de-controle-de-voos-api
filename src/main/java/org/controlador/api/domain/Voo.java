package org.controlador.api.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.controlador.api.converter.LocalDateTimeConverter;

@Entity
@Table(name = "voo")
public class Voo implements Serializable {

	private static final long serialVersionUID = 3616679131634118772L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime partida;

	@Column
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime chegada;

	@OneToOne
	@JoinColumn(name = "id_piloto", nullable = false)
	private Piloto piloto;

	@OneToOne
	@JoinColumn(name = "id_aviao", nullable = false)
	private Aviao aviao;

	@OneToOne
	@JoinColumn(name = "id_aeroporto_origem", nullable = false)
	private Aeroporto origem;

	@OneToOne
	@JoinColumn(name = "id_aeroporto_destino", nullable = false)
	private Aeroporto destino;

	@Enumerated(EnumType.STRING)
	private StatusVoo status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getPartida() {
		return partida;
	}

	public void setPartida(LocalDateTime horarioPartida) {
		this.partida = horarioPartida;
	}

	public LocalDateTime getChegada() {
		return chegada;
	}

	public void setChegada(LocalDateTime horarioChegada) {
		this.chegada = horarioChegada;
	}

	public Piloto getPiloto() {
		return piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	public Aviao getAviao() {
		return aviao;
	}

	public void setAviao(Aviao aviao) {
		this.aviao = aviao;
	}

	public Aeroporto getOrigem() {
		return origem;
	}

	public void setOrigem(Aeroporto origem) {
		this.origem = origem;
	}

	public Aeroporto getDestino() {
		return destino;
	}

	public void setDestino(Aeroporto destino) {
		this.destino = destino;
	}

	public StatusVoo getStatus() {
		return status;
	}

	public void setStatus(StatusVoo status) {
		this.status = status;
	}

}
