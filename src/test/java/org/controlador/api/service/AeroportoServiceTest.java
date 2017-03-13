package org.controlador.api.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.Arrays;
import java.util.List;

import org.controlador.api.domain.Aeroporto;
import org.controlador.api.domain.builder.AeroportoBuilder;
import org.controlador.api.repository.AeroportoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AeroportoServiceTest {

	private static final Long ID_AEROPORTO_ORIGEM = 1l;
	private static final Double LONGITUDE_AEROPORTO_ORIGEM = -5888.16;
	private static final Double LATITUDE_AEROPORTO_ORIGEM = 6000.8;
	private static final Integer UTC_AEROPORTO_ORIGEM = -3;
	private static final String NOME_AEROPORTO_ORIGEM = "Cumbica";
	private static final String IATA_AEROPORTO_ORIGEM = "TMA";
	private static final String ICAO_AEROPOROTO_ORIGEM = "SSOH";
	private static final String CIDADE_AEROPORTO_ORIGEM = NOME_AEROPORTO_ORIGEM;
	private static final String UF_AEROPORTO_ORIGEM = "SP";
	private static final String PAIS_AEROPORTO_ORIGEM = "Brasil";
	
	private static final Long ID_AEROPORTO_DESTINO = 2L;
	private static final Double LONGITUDE_AEROPORTO_DESTINO = -2000.1;
	private static final Double LATITUDE_AEROPORTO_DESTINO = 10000.0;
	private static final Integer UTC_AEROPORTO_DESTINO = -5;
	private static final String NOME_AEROPORTO_DESTINO = "Juscelino Kubischeck";
	private static final String PAIS_AEROPORTO_DESTINO = "Brasil";
	private static final String UF_AEROPORTO_DESTINO = "DF";
	private static final String CIDADE_AEROPORTO_DESTINO = "Brasília";
	private static final String ICAO_AEROPOROTO_DESTINO = "INIB";
	private static final String IATA_AEROPORTO_DESTINO = "BSB";

	@MockBean
	private AeroportoRepository repository;
	
	@Autowired
	private AeroportoService service;
	
	@Before
	public void init() {
		given(this.repository.findAll()).willReturn(getListAeroportosMock());
		given(this.repository.findById(1L)).willReturn(getListAeroportosMock().get(0));
		given(this.repository.findById(2L)).willReturn(getListAeroportosMock().get(1));
	}
	
	@Test
	public void deveRetornarAeroporto() {
		Aeroporto aeroporto1 = service.getAeroporto(ID_AEROPORTO_ORIGEM);
		assertAeroportoOrigem(aeroporto1);
		Aeroporto aeroporto2 = service.getAeroporto(ID_AEROPORTO_DESTINO);
		assertAeroportoDestino(aeroporto2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deveValidarIdAoBuscarAeroporto() {
		service.getAeroporto(null);
	}
	
	@Test
	public void deveListarAeroportos() {
		List<Aeroporto> aeroportos = service.listarAeroportos();
		assertListaDeAeroportos(aeroportos);
	}
	
	private List<Aeroporto> getListAeroportosMock() {
		return Arrays.asList(getOrigemMock(), getDestinoMock());
	}
	
	private Aeroporto getDestinoMock() {
		return new AeroportoBuilder()
				.withId(ID_AEROPORTO_DESTINO)
				.withIata(IATA_AEROPORTO_DESTINO)
				.withIcao(ICAO_AEROPOROTO_DESTINO)
				.withNome(NOME_AEROPORTO_DESTINO)
				.withCidade(CIDADE_AEROPORTO_DESTINO)
				.withUf(UF_AEROPORTO_DESTINO)
				.withPais(PAIS_AEROPORTO_DESTINO)
				.withUtc(UTC_AEROPORTO_DESTINO)
				.withLatitude(LATITUDE_AEROPORTO_DESTINO)
				.withLongitude(LONGITUDE_AEROPORTO_DESTINO)
				.create();
	}

	private Aeroporto getOrigemMock() {
		return new AeroportoBuilder()
				.withId(ID_AEROPORTO_ORIGEM)
				.withIata(IATA_AEROPORTO_ORIGEM)
				.withNome(NOME_AEROPORTO_ORIGEM)
				.withIcao(ICAO_AEROPOROTO_ORIGEM)
				.withCidade(CIDADE_AEROPORTO_ORIGEM)
				.withUf(UF_AEROPORTO_ORIGEM)
				.withPais(PAIS_AEROPORTO_ORIGEM)
				.withUtc(UTC_AEROPORTO_ORIGEM)
				.withLatitude(LATITUDE_AEROPORTO_ORIGEM)
				.withLongitude(LONGITUDE_AEROPORTO_ORIGEM)
				.create();
	}

	private void assertListaDeAeroportos(List<Aeroporto> aeroportos) {
		assertThat(aeroportos).isNotNull();
		assertThat(aeroportos.size()).isEqualTo(2);
		assertAeroportoOrigem(aeroportos.get(0));
		assertAeroportoDestino(aeroportos.get(1));		
	}

	private void assertAeroportoOrigem(Aeroporto aeroporto1) {
		assertThat(aeroporto1.getId()).isNotNull();
		assertThat(aeroporto1.getId()).isEqualTo(ID_AEROPORTO_ORIGEM);
		assertThat(aeroporto1.getIata()).isEqualTo(IATA_AEROPORTO_ORIGEM);
		assertThat(aeroporto1.getIcao()).isEqualTo(ICAO_AEROPOROTO_ORIGEM);
		assertThat(aeroporto1.getNome()).isEqualTo(NOME_AEROPORTO_ORIGEM);
		assertThat(aeroporto1.getCidade()).isEqualTo(CIDADE_AEROPORTO_ORIGEM);
		assertThat(aeroporto1.getUf()).isEqualTo(UF_AEROPORTO_ORIGEM);
		assertThat(aeroporto1.getPais()).isEqualTo(PAIS_AEROPORTO_ORIGEM);
		assertThat(aeroporto1.getUtc()).isEqualTo(UTC_AEROPORTO_ORIGEM);
		assertThat(aeroporto1.getLatitude()).isEqualTo(LATITUDE_AEROPORTO_ORIGEM);
		assertThat(aeroporto1.getLongitude()).isEqualTo(LONGITUDE_AEROPORTO_ORIGEM);
	}

	private void assertAeroportoDestino(Aeroporto aeroporto2) {
		assertThat(aeroporto2.getId()).isNotNull();
		assertThat(aeroporto2.getId()).isEqualTo(ID_AEROPORTO_DESTINO);
		assertThat(aeroporto2.getIata()).isEqualTo(IATA_AEROPORTO_DESTINO);
		assertThat(aeroporto2.getIcao()).isEqualTo(ICAO_AEROPOROTO_DESTINO);
		assertThat(aeroporto2.getNome()).isEqualTo(NOME_AEROPORTO_DESTINO);
		assertThat(aeroporto2.getCidade()).isEqualTo(CIDADE_AEROPORTO_DESTINO);
		assertThat(aeroporto2.getUf()).isEqualTo(UF_AEROPORTO_DESTINO);
		assertThat(aeroporto2.getPais()).isEqualTo(PAIS_AEROPORTO_DESTINO);
		assertThat(aeroporto2.getUtc()).isEqualTo(UTC_AEROPORTO_DESTINO);
		assertThat(aeroporto2.getLatitude()).isEqualTo(LATITUDE_AEROPORTO_DESTINO);
		assertThat(aeroporto2.getLongitude()).isEqualTo(LONGITUDE_AEROPORTO_DESTINO);
	}

}
