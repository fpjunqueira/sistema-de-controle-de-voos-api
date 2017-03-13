package org.controlador.api.rest.adapter.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.controlador.api.domain.Piloto;
import org.controlador.api.domain.builder.PilotoBuilder;
import org.controlador.api.rest.dto.PilotoDTO;
import org.controlador.api.rest.dto.builder.PilotoDTOBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PilotoAdapterTest {

	private static final Long ID_PILOTO = 1L;
	private static final String NOME_PILOTO = "Jão Vitor Maciel";
	private static final String DOCUMENTO_PILOTO = "22559877421";
	private static final String CMA_PILOTO = "MG-125112448";
	private static final int HORASDEVOO_PILOTO = 660;

	@Autowired
	private PilotoAdapter adapter;
	
	@Test
	public void deveAdaptarPilotoDTOParaPilotoDomain() {
		Piloto domain = adapter.toDomain(getPilotoDTO());
		assertDomain(domain);
	}
	
	@Test
	public void deveAdaptarPilotoDomainParaPilotoDTO() {
		PilotoDTO dto = adapter.toDto(getPilotoDomain());
		assertDTO(dto);
	}

	@Test
	public void deveAdaptarListPilotoDTOParaListPilotoDomain() {
		List<Piloto> listDomain = adapter.toListDomain(Arrays.asList(getPilotoDTO()));
		asserListDomain(listDomain);
	}
	
	@Test
	public void deveAdaptarListPilotoDomainParaListPilotoDTO() {
		List<PilotoDTO> listDto = adapter.toListDto(Arrays.asList(getPilotoDomain()));
		assertListDTO(listDto);
	}
	
	private void assertListDTO(List<PilotoDTO> listDto) {
		assertThat(listDto).isNotNull();
		assertThat(listDto.size()).isEqualTo(1);
		assertDTO(listDto.get(0));
	}

	private void asserListDomain(List<Piloto> listDomain) {
		assertThat(listDomain).isNotNull();
		assertThat(listDomain.size()).isEqualTo(1);
		assertDomain(listDomain.get(0));		
	}

	private PilotoDTO getPilotoDTO() {
		return new PilotoDTOBuilder()
				.withId(ID_PILOTO)
				.withNome(NOME_PILOTO)
				.withDocumento(DOCUMENTO_PILOTO)
				.withCma(CMA_PILOTO)
				.withHorasDeVoo(HORASDEVOO_PILOTO)
				.create();
	}
	
	private Piloto getPilotoDomain() {
		return new PilotoBuilder()
				.withId(ID_PILOTO)
				.withNome(NOME_PILOTO)
				.withDocumento(DOCUMENTO_PILOTO)
				.withCma(CMA_PILOTO)
				.withHorasDeVoo(HORASDEVOO_PILOTO)
				.create();
	}

	private void assertDTO(PilotoDTO dto) {
		assertThat(dto.getId()).isNotNull();
		assertThat(dto.getId()).isEqualTo(ID_PILOTO);
		assertThat(dto.getNome()).isEqualTo(NOME_PILOTO);
		assertThat(dto.getDocumento()).isEqualTo(DOCUMENTO_PILOTO);
		assertThat(dto.getCma()).isEqualTo(CMA_PILOTO);
		assertThat(dto.getHorasDeVoo()).isEqualTo(HORASDEVOO_PILOTO);
	}

	private void assertDomain(Piloto domain) {
		assertThat(domain.getId()).isNotNull();
		assertThat(domain.getId()).isEqualTo(ID_PILOTO);
		assertThat(domain.getNome()).isEqualTo(NOME_PILOTO);
		assertThat(domain.getDocumento()).isEqualTo(DOCUMENTO_PILOTO);
		assertThat(domain.getCma()).isEqualTo(CMA_PILOTO);
		assertThat(domain.getHorasDeVoo()).isEqualTo(HORASDEVOO_PILOTO);
	}
}
