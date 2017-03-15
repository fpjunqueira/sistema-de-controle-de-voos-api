package org.controlador.api.rest.adapter.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import org.controlador.api.domain.Aeroporto;
import org.controlador.api.domain.Aviao;
import org.controlador.api.domain.Piloto;
import org.controlador.api.domain.StatusVoo;
import org.controlador.api.domain.Voo;
import org.controlador.api.domain.builder.AeroportoBuilder;
import org.controlador.api.domain.builder.AviaoBuilder;
import org.controlador.api.domain.builder.PilotoBuilder;
import org.controlador.api.domain.builder.VooBuilder;
import org.controlador.api.rest.dto.AeroportoDTO;
import org.controlador.api.rest.dto.AviaoDTO;
import org.controlador.api.rest.dto.PilotoDTO;
import org.controlador.api.rest.dto.VooDTO;
import org.controlador.api.rest.dto.builder.AeroportoDTOBuilder;
import org.controlador.api.rest.dto.builder.AviaoDTOBuilder;
import org.controlador.api.rest.dto.builder.PilotoDTOBuilder;
import org.controlador.api.rest.dto.builder.VooDTOBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VooAdapterTest {

	private static final Long ID_VOO = 1L;
	private static final Long ID_AVIAO = 1L;
	private static final Long ID_AEROPORTO = 2l;
	private static final Long ID_PILOTO = 1L;
	private static final Integer UTC_AEROPORTO = -3;
	private static final Integer HORAS_DE_VOO_PILOTO = 560;
	private static final Double LATITUDE_AEROPORTO = 6000.8;
	private static final Double LONGITUDE_AEROPORTO = -5888.16;
	private static final String FABRICANTE = "Embraer";
	private static final String REGISTRO_AVIAO = "ANAC-589774882";
	private static final String ANO_AVIAO = "2005";
	private static final String MODELO_AVIAO = "Super Tucano";
	private static final String CMA_PILOTO = "SP-360589771";
	private static final String DOCUMENTO_PILOTO = "55478155982";
	private static final String NOME_PILOTO = "Antônio José do Oliveira";
	private static final String IATA_AEROPORTO = "TMA";
	private static final String ICAO_AEROPOROTO = "SSOH";
	private static final String CIDADE_AEROPORTO = "Cumbica";
	private static final String UF_AEROPORTO = "SP";
	private static final String PAIS_AEROPORTO = "Brasil";
	private static final LocalDateTime PARTIDA_VOO = LocalDateTime.of(2017, Month.JANUARY, 1, 17, 30, 45);
	private static final LocalDateTime CHEGADA_VOO = LocalDateTime.of(2017, Month.JANUARY, 2, 17, 30, 45);
	

	@MockBean
	private AeroportoAdapter aeroportoAdapter;

	@MockBean
	private AviaoAdapter aviaoAdapter;

	@MockBean
	private PilotoAdapter pilotoAdapter;

	@Autowired
	private VooAdapter adapter;

	@Before
	public void init() {
		given(aeroportoAdapter.toDomain(getAeroportoDTO())).willReturn(getAeroportoDomain());
		given(aeroportoAdapter.toDto(getAeroportoDomain())).willReturn(getAeroportoDTO());
		given(aeroportoAdapter.toListDomain(getListAeroportoDTO())).willReturn(getListAeroportoDomain());
		given(aeroportoAdapter.toListDto(getListAeroportoDomain())).willReturn(getListAeroportoDTO());

		given(aviaoAdapter.toDomain(getAviaoDTO())).willReturn(getAviaoDomain());
		given(aviaoAdapter.toDto(getAviaoDomain())).willReturn(getAviaoDTO());
		given(aviaoAdapter.toListDomain(getListAviaoDTO())).willReturn(getListAviaoDomain());
		given(aviaoAdapter.toListDto(getListAviaoDomain())).willReturn(getListAviaoDTO());

		given(pilotoAdapter.toDomain(getPilotoDTO())).willReturn(getPilotoDomain());
		given(pilotoAdapter.toDto(getPilotoDomain())).willReturn(getPilotoDTO());
		given(pilotoAdapter.toListDomain(getListPilotoDTO())).willReturn(getListPilotoDomain());
		given(pilotoAdapter.toListDto(getListPilotoDomain())).willReturn(getListPilotoDTO());
	}

	@Test
	public void deveAdaptarVooDTOParaVooDomain() {
		Voo domain = adapter.toDomain(getVooDto());
		assertDomain(domain);
	}

	@Test
	public void deveAdaptarVooDomainParaVooDTO() {
		VooDTO dto = adapter.toDto(getVooDomain());
		assertDto(dto);
	}

	@Test
	public void deveAdaptarListVooDTOParaListVooDomain() {
		List<Voo> listDomain = adapter.toListDomain(getListDto());
		assertListDomain(listDomain);
	}

	@Test
	public void deveAdaptarListVooDomainParaListVooDTO() {
		List<VooDTO> listDto = adapter.toListDto(getListDomain());
		assertListDto(listDto);
	}

	private void assertDto(VooDTO dto) {
		assertThat(dto.getId()).isNotNull();
		assertThat(dto.getId()).isEqualTo(ID_VOO);
		assertThat(dto.getOrigem()).isEqualTo(getAeroportoDTO());
		assertThat(dto.getDestino()).isEqualTo(getAeroportoDTO());
		assertThat(dto.getPiloto()).isEqualTo(getPilotoDTO());
		assertThat(dto.getAviao()).isEqualTo(getAviaoDTO());
		assertThat(dto.getPartida()).isEqualTo(PARTIDA_VOO);
		assertThat(dto.getChegada()).isEqualTo(CHEGADA_VOO);
		assertThat(dto.getStatus()).isEqualTo(StatusVoo.AGUARDANDO_DECOLAGEM.toString());
	}

	private void assertDomain(Voo domain) {
		assertThat(domain.getId()).isNotNull();
		assertThat(domain.getId()).isEqualTo(ID_VOO);
		assertThat(domain.getOrigem()).isEqualTo(getAeroportoDomain());
		assertThat(domain.getDestino()).isEqualTo(getAeroportoDomain());
		assertThat(domain.getPiloto()).isEqualTo(getPilotoDomain());
		assertThat(domain.getAviao()).isEqualTo(getAviaoDomain());
		assertThat(domain.getPartida()).isEqualTo(PARTIDA_VOO);
		assertThat(domain.getChegada()).isEqualTo(CHEGADA_VOO);
		assertThat(domain.getStatus().toString()).isEqualTo(StatusVoo.AGUARDANDO_DECOLAGEM.toString());
	}
	
	private void assertListDto(List<VooDTO> listDto) {
		assertThat(listDto).isNotNull();
		assertThat(listDto.size()).isEqualTo(1);
		assertDto(listDto.get(0));		
	}

	private void assertListDomain(List<Voo> listDomain) {
		assertThat(listDomain).isNotNull();
		assertThat(listDomain.size()).isEqualTo(1);
		assertDomain(listDomain.get(0));		
	}

	private List<Voo> getListDomain() {
		return Arrays.asList(getVooDomain());
	}


	private List<VooDTO> getListDto() {
		return Arrays.asList(getVooDto());
	}

	private Voo getVooDomain() {
		return new VooBuilder()
				.withId(ID_VOO)
				.withPartida(PARTIDA_VOO)
				.withChegada(CHEGADA_VOO)
				.withOrigem(getAeroportoDomain())
				.withDestino(getAeroportoDomain())
				.withAviao(getAviaoDomain())
				.withPiloto(getPilotoDomain())
				.withStatus(StatusVoo.AGUARDANDO_DECOLAGEM)
				.create();
	}

	private VooDTO getVooDto() {
		return new VooDTOBuilder()
				.withId(ID_VOO)
				.withHorarios(PARTIDA_VOO, CHEGADA_VOO)
				.withOrigemDestino(getAeroportoDTO(), getAeroportoDTO())
				.withAviao(getAviaoDTO())
				.withPiloto(getPilotoDTO())
				.withStatus(StatusVoo.AGUARDANDO_DECOLAGEM.toString())
				.create();
	}

	private List<Piloto> getListPilotoDomain() {
		return Arrays.asList(getPilotoDomain());
	}

	private List<PilotoDTO> getListPilotoDTO() {
		return Arrays.asList(getPilotoDTO());
	}

	private Piloto getPilotoDomain() {
		return new PilotoBuilder()
				.withId(ID_PILOTO)
				.withNome(NOME_PILOTO)
				.withDocumento(DOCUMENTO_PILOTO)
				.withCma(CMA_PILOTO)
				.withHorasDeVoo(HORAS_DE_VOO_PILOTO)
				.create();
	}

	private PilotoDTO getPilotoDTO() {
		return new PilotoDTOBuilder()
				.withId(ID_PILOTO)
				.withNome(NOME_PILOTO)
				.withDocumento(DOCUMENTO_PILOTO)
				.withCma(CMA_PILOTO)
				.withHorasDeVoo(HORAS_DE_VOO_PILOTO)
				.create();
	}

	private List<Aviao> getListAviaoDomain() {
		return Arrays.asList(getAviaoDomain());
	}

	private List<AviaoDTO> getListAviaoDTO() {
		return Arrays.asList(getAviaoDTO());
	}

	private AviaoDTO getAviaoDTO() {
		return new AviaoDTOBuilder()
				.withId(ID_AVIAO)
				.withModelo(MODELO_AVIAO)
				.withAno(ANO_AVIAO)
				.withRegistro(REGISTRO_AVIAO)
				.withFabricante(FABRICANTE)
				.create();
	}

	private Aviao getAviaoDomain() {
		return new AviaoBuilder()
				.withId(ID_AVIAO)
				.withModelo(MODELO_AVIAO)
				.withAno(ANO_AVIAO)
				.withRegistro(REGISTRO_AVIAO)
				.withFabricante(FABRICANTE)
				.create();
	}

	private List<Aeroporto> getListAeroportoDomain() {
		return Arrays.asList(getAeroportoDomain());
	}

	private List<AeroportoDTO> getListAeroportoDTO() {
		return Arrays.asList(getAeroportoDTO());
	}

	private Aeroporto getAeroportoDomain() {
		return new AeroportoBuilder()
				.withId(ID_AEROPORTO)
				.withIata(IATA_AEROPORTO)
				.withIcao(ICAO_AEROPOROTO)
				.withCidade(CIDADE_AEROPORTO)
				.withUf(UF_AEROPORTO)
				.withPais(PAIS_AEROPORTO)
				.withUtc(UTC_AEROPORTO)
				.withLatitude(LATITUDE_AEROPORTO)
				.withLongitude(LONGITUDE_AEROPORTO)
				.create();
	}

	private AeroportoDTO getAeroportoDTO() {
		return new AeroportoDTOBuilder()
				.withId(ID_AEROPORTO)
				.withIata(IATA_AEROPORTO)
				.withIcao(ICAO_AEROPOROTO)
				.withCidade(CIDADE_AEROPORTO)
				.withUf(UF_AEROPORTO)
				.withPais(PAIS_AEROPORTO)
				.withUtc(UTC_AEROPORTO)
				.withLatitude(LATITUDE_AEROPORTO)
				.withLongitude(LONGITUDE_AEROPORTO)
				.create();
	}

}
