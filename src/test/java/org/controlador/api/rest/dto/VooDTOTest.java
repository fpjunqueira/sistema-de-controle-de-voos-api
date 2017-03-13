package org.controlador.api.rest.dto;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.Month;

import org.controlador.api.rest.dto.builder.VooDTOBuilder;
import org.junit.Test;

public class VooDTOTest {

	@Test
	public void deveCalcularHorarioDePartidaLocalUTCMaisTres() {
		VooDTO vooDTO = new VooDTOBuilder()
				.withHorarioPartida(getHorarioUTC(2017, Month.JANUARY, 1, 20, 30, 0))
				.withHorarioChegada(getHorarioUTC(2017, Month.JANUARY, 2, 12, 0, 0))
				.withOrigemDestino(getAeroporto(3), getAeroporto(3))
				.create();
		
		assertEquals("01/01/2017 23:30:00", vooDTO.getHorarioDePartidaLocal());
	}
	
	@Test
	public void deveCalcularHorarioDeChegadaLocalUTCMaisTres() {
		VooDTO vooDTO = new VooDTOBuilder()
				.withHorarioPartida(getHorarioUTC(2017, Month.JANUARY, 1, 20, 30, 0))
				.withHorarioChegada(getHorarioUTC(2017, Month.JANUARY, 2, 12, 0, 0))
				.withOrigemDestino(getAeroporto(3), getAeroporto(3))
				.create();
		
		assertEquals("02/01/2017 15:00:00", vooDTO.getHorarioDeChegadaLocal());
	}

	@Test
	public void deveCalcularHorarioDePartidaLocalUTCMenosCinco() {
		VooDTO vooDTO = new VooDTOBuilder()
				.withHorarioPartida(getHorarioUTC(2017, Month.JANUARY, 1, 20, 30, 0))
				.withHorarioChegada(getHorarioUTC(2017, Month.JANUARY, 2, 12, 0, 0))
				.withOrigemDestino(getAeroporto(-5), getAeroporto(-3))
				.create();
		
		assertEquals("01/01/2017 15:30:00", vooDTO.getHorarioDePartidaLocal());
	}
	
	@Test
	public void deveCalcularHorarioDeChegadaLocalUTCMenosCinco() {
		VooDTO vooDTO = new VooDTOBuilder()
				.withHorarioPartida(getHorarioUTC(2017, Month.JANUARY, 1, 20, 30, 0))
				.withHorarioChegada(getHorarioUTC(2017, Month.JANUARY, 2, 12, 0, 0))
				.withOrigemDestino(getAeroporto(-5), getAeroporto(-3))
				.create();
		
		assertEquals("02/01/2017 09:00:00", vooDTO.getHorarioDeChegadaLocal());
	}
	
	@Test
	public void deveCalcularHorarioDePartidaEChegadaLocalDiaAnteriorAoUTC() {
		VooDTO vooDTO = new VooDTOBuilder()
				.withHorarioPartida(getHorarioUTC(2017, Month.JANUARY, 1, 3, 0, 40))
				.withHorarioChegada(getHorarioUTC(2017, Month.JANUARY, 2, 4, 30, 0))
				.withOrigemDestino(getAeroporto(-7), getAeroporto(-5))
				.create();
		
		assertEquals("31/12/2016 20:00:40", vooDTO.getHorarioDePartidaLocal());
		assertEquals("01/01/2017 23:30:00", vooDTO.getHorarioDeChegadaLocal());
	}

	@Test
	public void deveCalcularHorarioDePartidaEChegadaLocalDiaPosteriorAoUTC() {
		VooDTO vooDTO = new VooDTOBuilder()
				.withHorarioPartida(getHorarioUTC(2017, Month.JANUARY, 1, 20, 30, 0))
				.withHorarioChegada(getHorarioUTC(2017, Month.JANUARY, 2, 21, 0, 59))
				.withOrigemDestino(getAeroporto(5), getAeroporto(6))
				.create();
		
		assertEquals("02/01/2017 01:30:00", vooDTO.getHorarioDePartidaLocal());
		assertEquals("03/01/2017 03:00:59", vooDTO.getHorarioDeChegadaLocal());
	}
	
	private AeroportoDTO getAeroporto(int utc) {
		AeroportoDTO aeroporto = new AeroportoDTO();
		aeroporto.setUtc(utc);
		return aeroporto;
	}
	
	private LocalDateTime getHorarioUTC(int ano, Month month, int dia, int hora, int min, int seg) {
		return LocalDateTime.of(ano, month, dia, hora, min, seg);
	}

}