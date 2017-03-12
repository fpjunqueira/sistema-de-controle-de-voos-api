package org.controlador.api.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import org.controlador.api.domain.Aeroporto;
import org.controlador.api.domain.Aviao;
import org.controlador.api.domain.Piloto;
import org.controlador.api.domain.Voo;
import org.controlador.api.domain.builder.AeroportoBuilder;
import org.controlador.api.domain.builder.AviaoBuilder;
import org.controlador.api.domain.builder.PilotoBuilder;
import org.controlador.api.domain.builder.VooBuilder;
import org.controlador.api.repository.VooRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VooServiceTest {
	
	private static final Long ID = 1L;
	private static final Long ID_VOO_1 = 1L;
	private static final Long ID_VOO_2 = 2L;
	private static final Long ID_AEROPORTO_ORIGEM = 2l;
	private static final Long ID_AEROPORTO_DESTINO = 1L;
	private static final Long ID_PILOTO = 1L;
	private static final Integer UTC_AEROPORTO_DESTINO = -5;
	private static final Integer UTC_AEROPORTO_ORIGEM = -3;
	private static final Integer HORAS_DE_VOO_PILOTO = 560;
	private static final Double LATITUDE_AEROPORTO_ORIGEM = 6000.8;
	private static final Double LONGITUDE_AEROPORTO_ORIGEM = -5888.16;
	private static final Double LONGITUDE_AEROPORTO_DESTINO = -2000.1;
	private static final Double LATITUDE_AEROPORTO_DESTINO = 10000.0;
	private static final String CMA_PILOTO = "SP-360589771";
	private static final String DOCUMENTO_PILOTO = "55478155982";
	private static final String NOME_PILOTO = "Antônio José do Oliveira";
	private static final String PAIS_AEROPORTO_DESTINO = "Brasil";
	private static final String UF_AEROPORTO_DESTINO = "DF";
	private static final String CIDADE_AEROPORTO_DESTINO = "Brasília";
	private static final String ICAO_AEROPOROTO_DESTINO = "INIB";
	private static final String IATA_AEROPORTO_DESTINO = "BSB";
	private static final String IATA_AEROPORTO_ORIGEM = "TMA";
	private static final String ICAO_AEROPOROTO_ORIGEM = "SSOH";
	private static final String CIDADE_AEROPORTO_ORIGEM = "Cumbica";
	private static final String UF_AEROPORTO_ORIGEM = "SP";
	private static final String PAIS_AEROPORTO_ORIGEM = "Brasil";
	private static final LocalDateTime DECOLAGEM_VOO_1 = LocalDateTime.of(2016, Month.DECEMBER, 31, 11, 40, 00);
	private static final LocalDateTime POUSO_VOO_1 = LocalDateTime.of(2016, Month.DECEMBER, 31, 11, 40, 00);
	private static final LocalDateTime DECOLAGEM_VOO_2 = LocalDateTime.of(2016, Month.DECEMBER, 31, 11, 40, 00);
	private static final LocalDateTime POUSO_VOO_2 = LocalDateTime.of(2016, Month.DECEMBER, 31, 11, 40, 00);
	private static final LocalDateTime FIND_BY_HORARIOS_DECOLAGEM = LocalDateTime.of(2017, Month.JANUARY, 1, 17, 30, 45);
	private static final LocalDateTime FIND_BY_HORARIOS_POUSO = LocalDateTime.of(2017, Month.JANUARY, 1, 17, 30, 45);

	@MockBean
	private VooRepository repository;
	
	@Autowired
	private VooService service;

	@Before
	public void init() {
		given(this.repository.findAll()).willReturn(getListVooMock());
		given(this.repository.findById(ID)).willReturn(getListVooMock().get(0));
		given(this.repository.findByHorarios(FIND_BY_HORARIOS_DECOLAGEM, FIND_BY_HORARIOS_POUSO)).willReturn(getListVooMock());
	}
	
	private List<Voo> getListVooMock() {
		Voo voo1 = new VooBuilder()
				.withId(ID_VOO_1)
				.withPartida(DECOLAGEM_VOO_1)
				.withChegada(POUSO_VOO_1)
				.withOrigem(getOrigemMock())
				.withDestino(getDestinoMock())
				.withAviao(getAviaoMock())
				.withPiloto(getPilotoMock())
				.create();
		
		Voo voo2 = new VooBuilder()
				.withId(ID_VOO_2)
				.withPartida(DECOLAGEM_VOO_2)
				.withChegada(POUSO_VOO_2)
				.withOrigem(getOrigemMock())
				.withDestino(getDestinoMock())
				.withAviao(getAviaoMock())
				.withPiloto(getPilotoMock())
				.create();
		
		return Arrays.asList(voo1, voo2);
	}

	private Piloto getPilotoMock() {
		return new PilotoBuilder()
				.withId(ID_PILOTO)
				.withNome(NOME_PILOTO)
				.withDocumento(DOCUMENTO_PILOTO)
				.withCMA(CMA_PILOTO)
				.withHorasVoo(HORAS_DE_VOO_PILOTO)
				.create();
	}

	private Aeroporto getDestinoMock() {
		return new AeroportoBuilder()
				.withId(ID_AEROPORTO_DESTINO)
				.withIata(IATA_AEROPORTO_DESTINO)
				.withIcao(ICAO_AEROPOROTO_DESTINO)
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
				.withIcao(ICAO_AEROPOROTO_ORIGEM)
				.withCidade(CIDADE_AEROPORTO_ORIGEM)
				.withUf(UF_AEROPORTO_ORIGEM)
				.withPais(PAIS_AEROPORTO_ORIGEM)
				.withUtc(UTC_AEROPORTO_ORIGEM)
				.withLatitude(LATITUDE_AEROPORTO_ORIGEM)
				.withLongitude(LONGITUDE_AEROPORTO_ORIGEM)
				.create();
	}

	private Aviao getAviaoMock() {
		return new AviaoBuilder()
				.withId(1L)
				.withModelo("Super Tucano")
				.withAno("2005")
				.withRegistro("ANAC-589774882")
				.withFabricante("Embraer")
				.create();
	}

	@Test
	public void deveListarVoos() {
		List<Voo> voos = service.listarVoos();
		assertListaDeVoos(voos, 0);
	}

	private void assertListaDeVoos(List<Voo> voos, int index) {
		assertThat(voos).isNotNull();
		assertThat(voos.size()).isEqualTo(2);
		assertVoo1(voos.get(index));
	}

	private void assertVoo1(Voo voo) {
		assertThat(voo.getPartida()).isEqualTo(DECOLAGEM_VOO_1);		
		assertThat(voo.getChegada()).isEqualTo(POUSO_VOO_1);
		assertThat(voo.getPiloto()).isEqualTo(getPilotoMock());
		assertThat(voo.getOrigem()).isEqualTo(getOrigemMock());
		assertThat(voo.getDestino()).isEqualTo(getDestinoMock());
		assertThat(voo.getAviao()).isEqualTo(getAviaoMock());
	}
	
	@Test
	public void deveListarVoosPorHorario() {
		List<Voo> voos = service.listarVoosPorHorarios(FIND_BY_HORARIOS_DECOLAGEM, FIND_BY_HORARIOS_POUSO);
		assertListaDeVoos(voos, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deveValidarDataDecolagemMainsQueDataPouso() {
		List<Voo> voos = service.listarVoosPorHorarios(FIND_BY_HORARIOS_POUSO, FIND_BY_HORARIOS_DECOLAGEM);
		assertListaDeVoos(voos, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deveValidarDecolagemObrigatoio() {
		List<Voo> voos = service.listarVoosPorHorarios(null, FIND_BY_HORARIOS_POUSO);
		assertListaDeVoos(voos, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deveValidarPousoObrigatorio() {
		List<Voo> voos = service.listarVoosPorHorarios(FIND_BY_HORARIOS_DECOLAGEM, null);
		assertListaDeVoos(voos, 0);
	}
	
	@Test
	public void deveRetornarVoo() {
		Voo voo = service.getVoo(ID_VOO_1);
		assertVoo1(voo);
	}
	
}
