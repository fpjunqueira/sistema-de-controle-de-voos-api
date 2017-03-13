package org.controlador.api.rest.adapter.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.controlador.api.domain.Aeroporto;
import org.controlador.api.domain.builder.AeroportoBuilder;
import org.controlador.api.rest.dto.AeroportoDTO;
import org.controlador.api.rest.dto.builder.AeroportoDTOBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AeroportoAdapterTest {
	
	private static final Long ID_AEROPORTO = 1L;
	private static final String IATA_AEROPORTO = "BSB";
	private static final String ICAO_AEROPORTO = "SBBR";
	private static final String NOME_AEROPORTO = "Jucelino Kubitschek";
	private static final String CIDADE_AEROPORTO = "Brasília";
	private static final String UF_AEROPORTO = "DF";
	private static final String PAIS_AEROPORTO = "Brasil";
	private static final int UTC_AEROPORTO = -5;
	private static final Double LATITUDE_AEROPORTO = -15.6661;
	private static final Double LONGITUDE_AEROPORTO = 48.0060;
	
	@Autowired
	private AeroportoAdapter adapter;
	
	@Test
	public void deveAdaptarAeroportoDTOParaAeroportoDomain() {
		Aeroporto domain = adapter.toDomain(getAeroportoDTO());
		assertDomain(domain);
	}
	
	@Test
	public void deveAdaptarAeroportoDomainParaAeroportoDTO() {
		AeroportoDTO dto = adapter.toDto(getAeroportoDomain());
		assertDTO(dto);
	}

	@Test
	public void deveAdaptarListAeroportoDTOParaListAeroportoDomain() {
		List<Aeroporto> listDomain = adapter.toListDomain(Arrays.asList(getAeroportoDTO()));
		asserListDomain(listDomain);
	}
	
	@Test
	public void deveAdaptarListAeroportoDomainParaListAeroportoDTO() {
		List<AeroportoDTO> listDto = adapter.toListDto(Arrays.asList(getAeroportoDomain()));
		assertListDTO(listDto);
	}
	
	private void assertListDTO(List<AeroportoDTO> listDto) {
		assertThat(listDto).isNotNull();
		assertThat(listDto.size()).isEqualTo(1);
		assertDTO(listDto.get(0));
	}

	private void asserListDomain(List<Aeroporto> listDomain) {
		assertThat(listDomain).isNotNull();
		assertThat(listDomain.size()).isEqualTo(1);
		assertDomain(listDomain.get(0));		
	}

	private AeroportoDTO getAeroportoDTO() {
		return new AeroportoDTOBuilder()
				.withId(ID_AEROPORTO)
				.withIata(IATA_AEROPORTO)
				.withIcao(ICAO_AEROPORTO)
				.withNome(NOME_AEROPORTO)
				.withCidade(CIDADE_AEROPORTO)
				.withUf(UF_AEROPORTO)
				.withPais(PAIS_AEROPORTO)
				.withUtc(UTC_AEROPORTO)
				.withLatitude(LATITUDE_AEROPORTO)
				.withLongitude(LONGITUDE_AEROPORTO)
				.create();
	}
	
	private Aeroporto getAeroportoDomain() {
		return new AeroportoBuilder()
				.withId(ID_AEROPORTO)
				.withIata(IATA_AEROPORTO)
				.withNome(NOME_AEROPORTO)
				.withIcao(ICAO_AEROPORTO)
				.withCidade(CIDADE_AEROPORTO)
				.withUf(UF_AEROPORTO)
				.withPais(PAIS_AEROPORTO)
				.withUtc(UTC_AEROPORTO)
				.withLatitude(LATITUDE_AEROPORTO)
				.withLongitude(LONGITUDE_AEROPORTO)
				.create();
	}

	private void assertDTO(AeroportoDTO dto) {
		assertThat(dto.getId()).isNotNull();
		assertThat(dto.getId()).isEqualTo(ID_AEROPORTO);
		assertThat(dto.getIata()).isEqualTo(IATA_AEROPORTO);
		assertThat(dto.getIcao()).isEqualTo(ICAO_AEROPORTO);
		assertThat(dto.getNome()).isEqualTo(NOME_AEROPORTO);
		assertThat(dto.getCidade()).isEqualTo(CIDADE_AEROPORTO);
		assertThat(dto.getUf()).isEqualTo(UF_AEROPORTO);
		assertThat(dto.getPais()).isEqualTo(PAIS_AEROPORTO);
		assertThat(dto.getUtc()).isEqualTo(UTC_AEROPORTO);
		assertThat(dto.getLatitude()).isEqualTo(LATITUDE_AEROPORTO);
		assertThat(dto.getLongitude()).isEqualTo(LONGITUDE_AEROPORTO);
	}

	private void assertDomain(Aeroporto domain) {
		assertThat(domain.getId()).isNotNull();
		assertThat(domain.getId()).isEqualTo(ID_AEROPORTO);
		assertThat(domain.getIata()).isEqualTo(IATA_AEROPORTO);
		assertThat(domain.getIcao()).isEqualTo(ICAO_AEROPORTO);
		assertThat(domain.getNome()).isEqualTo(NOME_AEROPORTO);
		assertThat(domain.getCidade()).isEqualTo(CIDADE_AEROPORTO);
		assertThat(domain.getUf()).isEqualTo(UF_AEROPORTO);
		assertThat(domain.getPais()).isEqualTo(PAIS_AEROPORTO);
		assertThat(domain.getUtc()).isEqualTo(UTC_AEROPORTO);
		assertThat(domain.getLatitude()).isEqualTo(LATITUDE_AEROPORTO);
		assertThat(domain.getLongitude()).isEqualTo(LONGITUDE_AEROPORTO);
	}
	
}
