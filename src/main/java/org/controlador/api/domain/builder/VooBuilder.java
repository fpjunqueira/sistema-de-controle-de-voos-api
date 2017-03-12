package org.controlador.api.domain.builder;

import java.time.LocalDateTime;

import org.controlador.api.domain.Aeroporto;
import org.controlador.api.domain.Aviao;
import org.controlador.api.domain.Piloto;
import org.controlador.api.domain.StatusVoo;
import org.controlador.api.domain.Voo;

public class VooBuilder {

	private Voo voo;

	public VooBuilder() {
		voo = new Voo();
	}
	
	public VooBuilder withId(Long id) {
		this.voo.setId(id);
		return this;
	}
	public VooBuilder withPartida(LocalDateTime partida) {
		this.voo.setPartida(partida);
		return this;
	}

	public VooBuilder withChegada(LocalDateTime chegada) {
		this.voo.setChegada(chegada);
		return this;
	}

	public VooBuilder withOrigem(Aeroporto origem) {
		this.voo.setOrigem(origem);
		return this;
	}

	public VooBuilder withDestino(Aeroporto destino) {
		this.voo.setDestino(destino);
		return this;
	}

	public VooBuilder withStatus(StatusVoo status) {
		this.voo.setStatus(status);
		return this;
	}

	public VooBuilder withPiloto(Piloto piloto) {
		this.voo.setPiloto(piloto);
		return this;
	}

	public VooBuilder withAviao(Aviao aviao) {
		this.voo.setAviao(aviao);
		return this;
	}

	public Voo create() {
		return this.voo;
	}

}
