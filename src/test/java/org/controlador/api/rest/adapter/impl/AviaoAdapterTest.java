package org.controlador.api.rest.adapter.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.controlador.api.domain.Aviao;
import org.controlador.api.domain.builder.AviaoBuilder;
import org.controlador.api.rest.dto.AviaoDTO;
import org.controlador.api.rest.dto.builder.AviaoDTOBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AviaoAdapterTest {

	private static final Long ID_AVIAO = 1L;
	private static final String MODELO_AVIAO = "Boing 707";
	private static final String FABRICANTE_AVIAO = "Boing";
	private static final String ANO_AVIAO = "2010";
	private static final String REGISTRO_AVIAO = "ANAC-332225441";
	
	@Autowired
	private AviaoAdapter adapter;
	
	@Test
	public void deveAdaptarAviaoDTOParaAviaoDomain() {
		Aviao domain = adapter.toDomain(getAviaoDTO());
		assertDomain(domain);
	}
	
	@Test
	public void deveAdaptarAviaoDomainParaAviaoDTO() {
		AviaoDTO dto = adapter.toDto(getAviaoDomain());
		assertDTO(dto);
	}

	@Test
	public void deveAdaptarListAviaoDTOParaListAviaoDomain() {
		List<Aviao> listDomain = adapter.toListDomain(Arrays.asList(getAviaoDTO()));
		asserListDomain(listDomain);
	}
	
	@Test
	public void deveAdaptarListAviaoDomainParaListAviaoDTO() {
		List<AviaoDTO> listDto = adapter.toListDto(Arrays.asList(getAviaoDomain()));
		assertListDTO(listDto);
	}
	
	private void assertListDTO(List<AviaoDTO> listDto) {
		assertThat(listDto).isNotNull();
		assertThat(listDto.size()).isEqualTo(1);
		assertDTO(listDto.get(0));
	}

	private void asserListDomain(List<Aviao> listDomain) {
		assertThat(listDomain).isNotNull();
		assertThat(listDomain.size()).isEqualTo(1);
		assertDomain(listDomain.get(0));		
	}

	private AviaoDTO getAviaoDTO() {
		return new AviaoDTOBuilder()
				.withId(ID_AVIAO)
				.withModelo(MODELO_AVIAO)
				.withFabricante(FABRICANTE_AVIAO)
				.withAno(ANO_AVIAO)
				.withRegistro(REGISTRO_AVIAO)
				.create();
	}
	
	private Aviao getAviaoDomain() {
		return new AviaoBuilder()
				.withId(ID_AVIAO)
				.withModelo(MODELO_AVIAO)
				.withFabricante(FABRICANTE_AVIAO)
				.withAno(ANO_AVIAO)
				.withRegistro(REGISTRO_AVIAO)
				.create();
	}

	private void assertDTO(AviaoDTO dto) {
		assertThat(dto.getId()).isNotNull();
		assertThat(dto.getId()).isEqualTo(ID_AVIAO);
		assertThat(dto.getModelo()).isEqualTo(MODELO_AVIAO);
		assertThat(dto.getFabricante()).isEqualTo(FABRICANTE_AVIAO);
		assertThat(dto.getAno()).isEqualTo(ANO_AVIAO);
		assertThat(dto.getRegistro()).isEqualTo(REGISTRO_AVIAO);
	}

	private void assertDomain(Aviao domain) {
		assertThat(domain.getId()).isNotNull();
		assertThat(domain.getId()).isEqualTo(ID_AVIAO);
		assertThat(domain.getModelo()).isEqualTo(MODELO_AVIAO);
		assertThat(domain.getFabricante()).isEqualTo(FABRICANTE_AVIAO);
		assertThat(domain.getAno()).isEqualTo(ANO_AVIAO);
		assertThat(domain.getRegistro()).isEqualTo(REGISTRO_AVIAO);
	}
	
}
