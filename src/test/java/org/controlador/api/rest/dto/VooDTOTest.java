package org.controlador.api.rest.dto;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class VooDTOTest {

	@Test
	public void deveCalcularHorarioDePartidaLocalUTCMaisTres() {
		VooDTO vooDTO = new VooDTOBuilder()
				.setHorarioPartida(getHorarioUTC(2017, 0, 1, 20, 30, 0))
				.setHorarioChegada(getHorarioUTC(2017, 0, 2, 12, 0, 0))
				.setOrigemDestino(getAeroporto("UTC+03:00"), getAeroporto("UTC+03:00"))
				.build();
		
		assertEquals("01/01/2017 23:30:00", vooDTO.getHorarioDePartidaLocal());
	}
	
	@Test
	public void deveCalcularHorarioDeChegadaLocalUTCMaisTres() {
		VooDTO vooDTO = new VooDTOBuilder()
				.setHorarioPartida(getHorarioUTC(2017, 0, 1, 20, 30, 0))
				.setHorarioChegada(getHorarioUTC(2017, 0, 2, 12, 0, 0))
				.setOrigemDestino(getAeroporto("UTC+03:00"), getAeroporto("UTC+03:00"))
				.build();
		
		assertEquals("02/01/2017 15:00:00", vooDTO.getHorarioDeChegadaLocal());
	}

	@Test
	public void deveCalcularHorarioDePartidaLocalUTCMenosCinco() {
		VooDTO vooDTO = new VooDTOBuilder()
				.setHorarioPartida(getHorarioUTC(2017, 0, 1, 20, 30, 0))
				.setHorarioChegada(getHorarioUTC(2017, 0, 2, 12, 0, 0))
				.setOrigemDestino(getAeroporto("UTC-05:00"), getAeroporto("UTC-03:00"))
				.build();
		
		assertEquals("01/01/2017 15:30:00", vooDTO.getHorarioDePartidaLocal());
	}
	
	@Test
	public void deveCalcularHorarioDeChegadaLocalUTCMenosCinco() {
		VooDTO vooDTO = new VooDTOBuilder()
				.setHorarioPartida(getHorarioUTC(2017, 0, 1, 20, 30, 0))
				.setHorarioChegada(getHorarioUTC(2017, 0, 2, 12, 0, 0))
				.setOrigemDestino(getAeroporto("UTC-05:00"), getAeroporto("UTC-03:00"))
				.build();
		
		assertEquals("02/01/2017 09:00:00", vooDTO.getHorarioDeChegadaLocal());
	}
	
	@Test
	public void deveCalcularHorarioDePartidaEChegadaLocalDiaAnteriorAoUTC() {
		VooDTO vooDTO = new VooDTOBuilder()
				.setHorarioPartida(getHorarioUTC(2017, 0, 1, 3, 0, 40))
				.setHorarioChegada(getHorarioUTC(2017, 0, 2, 4, 30, 0))
				.setOrigemDestino(getAeroporto("UTC-07:00"), getAeroporto("UTC-05:00"))
				.build();
		
		assertEquals("31/12/2016 20:00:40", vooDTO.getHorarioDePartidaLocal());
		assertEquals("01/01/2017 23:30:00", vooDTO.getHorarioDeChegadaLocal());
	}

	@Test
	public void deveCalcularHorarioDePartidaEChegadaLocalDiaPosteriorAoUTC() {
		VooDTO vooDTO = new VooDTOBuilder()
				.setHorarioPartida(getHorarioUTC(2017, 0, 1, 20, 30, 0))
				.setHorarioChegada(getHorarioUTC(2017, 0, 2, 21, 0, 59))
				.setOrigemDestino(getAeroporto("UTC+05:00"), getAeroporto("UTC+06:00"))
				.build();
		
		assertEquals("02/01/2017 01:30:00", vooDTO.getHorarioDePartidaLocal());
		assertEquals("03/01/2017 03:00:59", vooDTO.getHorarioDeChegadaLocal());
	}
	
	private AeroportoDTO getAeroporto(String utc) {
		AeroportoDTO aeroporto = new AeroportoDTO();
		aeroporto.setUtc(utc);
		return aeroporto;
	}
	
	private Date getHorarioUTC(int ano, int mes, int dia, int hora, int min, int seg) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, ano);
		calendar.set(Calendar.MONTH, mes);
		calendar.set(Calendar.DAY_OF_MONTH, dia);
		calendar.set(Calendar.HOUR_OF_DAY, hora);
		calendar.set(Calendar.MINUTE, min);
		calendar.set(Calendar.SECOND, seg);
		return calendar.getTime();
	}

}