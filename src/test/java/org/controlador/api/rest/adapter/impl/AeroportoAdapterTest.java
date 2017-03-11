package org.controlador.api.rest.adapter.impl;

import static org.junit.Assert.*;

import org.controlador.api.domain.Aeroporto;
import org.controlador.api.rest.dto.AeroportoDTO;
import org.junit.Test;

public class AeroportoAdapterTest {

	private AeroportoAdapter adapter = new AeroportoAdapter();
	
	private static final Long ID = 1L;
	private static final String IATA = "BSB";
	private static final String ICAO = "SBBR";
	private static final String NOME = "Jucelino Kubitschek";
	private static final String CIDADE = "Brasília";
	private static final String UF = "DF";
	private static final String PAIS = "Brasil";
	private static final String UTC = "UTC";
	private static final Double LATITUDE = -15.6661;
	private static final Double LONGITUDE = 48.0060;
	
	@Test
	public void deveAdaptarAeroportoDTOParaAeroportoDomain() {
		Aeroporto domain = adapter.toDomain(getDto());
		assertDomain(domain);
	}
	
	private AeroportoDTO getDto() {
		return null;
	}

	private void assertDomain(Aeroporto domain) {
		assertEquals(domain.getId(), ID);
		assertEquals(domain.getIata(), IATA);
		assertEquals(domain.getIcao(), ICAO);
		assertEquals(domain.getNome(), NOME);
		assertEquals(domain.getCidade(), CIDADE);
		assertEquals(domain.getUf(), UF);
		assertEquals(domain.getPais(), PAIS);
		assertEquals(domain.getUtc(), UTC);
		assertEquals(domain.getLatitude(), LATITUDE);
		assertEquals(domain.getLongitude(), LONGITUDE);
	}

	@Test
	public void deveAdaptarAeroportoDomainParaAeroportoDTO() {
		fail("Not yet implemented");
	}

	@Test
	public void deveAdaptarListAeroportoDTOParaListAeroportoDomain() {
		fail("Not yet implemented");
	}
	
	@Test
	public void deveAdaptarListAeroportoDomainParaListAeroportoDTO() {
		fail("Not yet implemented");
	}
}
