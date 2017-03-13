package org.controlador.api.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import org.controlador.api.domain.Aeroporto;
import org.controlador.api.domain.Aviao;
import org.controlador.api.domain.Piloto;
import org.controlador.api.domain.Voo;
import org.controlador.api.domain.builder.AeroportoBuilder;
import org.controlador.api.domain.builder.AviaoBuilder;
import org.controlador.api.domain.builder.PilotoBuilder;
import org.controlador.api.domain.builder.VooBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class VooRepositoryTest {

	private static final Long ID_AVIAO = 1L;
	private static final Long ID_VOO_1 = 1L;
	private static final Long ID_VOO_2 = 2L;
	private static final Long ID_AEROPORTO_ORIGEM = 1l;
	private static final Long ID_AEROPORTO_DESTINO = 2L;
	private static final Long ID_PILOTO = 1L;
	private static final Integer UTC_AEROPORTO_DESTINO = -5;
	private static final Integer UTC_AEROPORTO_ORIGEM = -3;
	private static final Integer HORAS_DE_VOO_PILOTO = 560;
	private static final Double LATITUDE_AEROPORTO_ORIGEM = 6000.8;
	private static final Double LONGITUDE_AEROPORTO_ORIGEM = -5888.16;
	private static final Double LONGITUDE_AEROPORTO_DESTINO = -2000.1;
	private static final Double LATITUDE_AEROPORTO_DESTINO = 10000.0;
	private static final String NOME_AEROPORO_DESTINO = "Cumbica";
	private static final String NOME_AEROPORO_ORIGEM = "Juscelino";
	private static final String FABRICANTE = "Embraer";
	private static final String REGISTRO_AVIAO = "ANAC-589774882";
	private static final String ANO_AVIAO = "2005";
	private static final String MODELO_AVIAO = "Super Tucano";
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
	
	private static final LocalDateTime DECOLAGEM_VOO_1 = LocalDateTime.of(2017, Month.JANUARY, 20, 10, 00, 00);
	private static final LocalDateTime POUSO_VOO_1 = LocalDateTime.of(2017, Month.JANUARY, 20, 14, 00, 00);
	private static final LocalDateTime DECOLAGEM_VOO_2 = LocalDateTime.of(2017, Month.JANUARY, 23, 9, 00, 00);
	private static final LocalDateTime POUSO_VOO_2 = LocalDateTime.of(2017, Month.JANUARY, 23, 19, 00, 00);
	
	private static final LocalDateTime DATA_DECOLAGEM_COM_VOO = LocalDateTime.of(2017, Month.JANUARY, 15, 14, 00, 00);
	private static final LocalDateTime DATA_POUSO_COM_VOO = LocalDateTime.of(2017, Month.JANUARY, 25, 14, 00, 00);
	private static final LocalDateTime DATA_DECOLAGEM_SEM_VOO = LocalDateTime.of(2017, Month.FEBRUARY, 20, 14, 00, 00);
	private static final LocalDateTime DATA_POUSO_SEM_VOO = LocalDateTime.of(2017, Month.FEBRUARY, 25, 14, 00, 00);

	@Autowired
	private VooRepository vooRepository;
	
	@Autowired
	private AviaoRepository aviaoRepository;
	
	@Autowired
	private AeroportoRepository aeroportoRepository;
	
	@Autowired
	private PilotoRepository pilotoRepository;
	
	@Before
	public void inti() {
		Voo voo1 = getVoo1();
		Voo voo2 = getVoo2();
		Piloto piloto = pilotoRepository.save(getPiloto());
		voo1.setPiloto(piloto);
		voo2.setPiloto(piloto);
		Aviao aviao = aviaoRepository.save(getAviao());
		voo1.setAviao(aviao);
		voo2.setAviao(aviao);
		Aeroporto aeroportoOrigem = aeroportoRepository.save(getAeroportoOrigem());
		voo1.setOrigem(aeroportoOrigem);
		voo2.setOrigem(aeroportoOrigem);
		Aeroporto aeroportoDestino = aeroportoRepository.save(getAeroportoDestino());
		voo1.setDestino(aeroportoDestino);
		voo2.setDestino(aeroportoDestino);
		vooRepository.save(voo1);
		vooRepository.save(voo2);
	}
	
	@Test
	public void deveEncontrarVoosPorHorarioDeDecolagemEPouso() {
		List<Voo> list = vooRepository.findByHorarios(DATA_DECOLAGEM_COM_VOO, DATA_POUSO_COM_VOO);
		assertThat(list).isNotEmpty();
		assertThat(list.size()).isEqualTo(2);
		assertThat(list.get(0).getPartida().isAfter(DATA_DECOLAGEM_COM_VOO));
		assertThat(list.get(0).getPartida().isBefore(DATA_POUSO_COM_VOO));
		assertThat(list.get(1).getPartida().isAfter(DATA_DECOLAGEM_COM_VOO));
		assertThat(list.get(1).getPartida().isBefore(DATA_POUSO_COM_VOO));
	}

	@Test
	public void naoDeveEncontrarVoosPorHorarioDeDecolagemEPouso() {
		List<Voo> list = vooRepository.findByHorarios(DATA_DECOLAGEM_SEM_VOO, DATA_POUSO_SEM_VOO);
		assertThat(list).isEmpty();
	}
	
	private Voo getVoo1() {
		return new VooBuilder()
				.withId(ID_VOO_1)
				.withPartida(DECOLAGEM_VOO_1)
				.withChegada(POUSO_VOO_1)
				.withOrigem(getAeroportoOrigem())
				.withDestino(getAeroportoDestino())
				.withAviao(getAviao())
				.withPiloto(getPiloto())
				.create();
	}
	
	private Voo getVoo2() {
		return new VooBuilder()
				.withId(ID_VOO_2)
				.withPartida(DECOLAGEM_VOO_2)
				.withChegada(POUSO_VOO_2)
				.withOrigem(getAeroportoOrigem())
				.withDestino(getAeroportoDestino())
				.withAviao(getAviao())
				.withPiloto(getPiloto())
				.create();
	}

	private Piloto getPiloto() {
		return new PilotoBuilder()
				.withId(ID_PILOTO)
				.withNome(NOME_PILOTO)
				.withDocumento(DOCUMENTO_PILOTO)
				.withCma(CMA_PILOTO)
				.withHorasDeVoo(HORAS_DE_VOO_PILOTO)
				.create();
	}

	private Aeroporto getAeroportoDestino() {
		return new AeroportoBuilder()
				.withId(ID_AEROPORTO_DESTINO)
				.withIata(IATA_AEROPORTO_DESTINO)
				.withIcao(ICAO_AEROPOROTO_DESTINO)
				.withNome(NOME_AEROPORO_DESTINO)
				.withCidade(CIDADE_AEROPORTO_DESTINO)
				.withUf(UF_AEROPORTO_DESTINO)
				.withPais(PAIS_AEROPORTO_DESTINO)
				.withUtc(UTC_AEROPORTO_DESTINO)
				.withLatitude(LATITUDE_AEROPORTO_DESTINO)
				.withLongitude(LONGITUDE_AEROPORTO_DESTINO)
				.create();
	}

	private Aeroporto getAeroportoOrigem() {
		return new AeroportoBuilder()
				.withId(ID_AEROPORTO_ORIGEM)
				.withIata(IATA_AEROPORTO_ORIGEM)
				.withIcao(ICAO_AEROPOROTO_ORIGEM)
				.withNome(NOME_AEROPORO_ORIGEM)
				.withCidade(CIDADE_AEROPORTO_ORIGEM)
				.withUf(UF_AEROPORTO_ORIGEM)
				.withPais(PAIS_AEROPORTO_ORIGEM)
				.withUtc(UTC_AEROPORTO_ORIGEM)
				.withLatitude(LATITUDE_AEROPORTO_ORIGEM)
				.withLongitude(LONGITUDE_AEROPORTO_ORIGEM)
				.create();
	}
	
	private Aviao getAviao() {
		return new AviaoBuilder()
				.withId(ID_AVIAO)
				.withModelo(MODELO_AVIAO)
				.withAno(ANO_AVIAO)
				.withRegistro(REGISTRO_AVIAO)
				.withFabricante(FABRICANTE)
				.create();
	}

}
