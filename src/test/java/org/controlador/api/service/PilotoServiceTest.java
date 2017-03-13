package org.controlador.api.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.Arrays;
import java.util.List;

import org.controlador.api.domain.Piloto;
import org.controlador.api.domain.builder.PilotoBuilder;
import org.controlador.api.repository.PilotoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PilotoServiceTest {
	
	private static final Long ID_PILOTO_1 = 1L;
	private static final String NOME_PILOTO_1 = "Francisco de Paula";
	private static final String DOCUMENTO_PILOTO_1 = "55899622472";
	private static final String CMA_PILOTO_1 = "PR-225441889";
	private static final int HORAS_DE_VOO_PILOTO_1 = 750;
	
	private static final Long ID_PILOTO_2 = 2L;
	private static final String NOME_PILOTO_2 = "Antônio Moreira";
	private static final String DOCUMENTO_PILOTO_2 = "55666844123";
	private static final String CMA_PILOTO_2 = "RJ-225441225";
	private static final int HORAS_DE_VOO_PILOTO_2 = 820;

	@MockBean
	private PilotoRepository repository;
	
	@Autowired
	private PilotoService service;
	
	@Before
	public void init() {
		given(this.repository.findAll()).willReturn(getListPilotosMock());
		given(this.repository.findById(1L)).willReturn(getListPilotosMock().get(0));
		given(this.repository.findById(2L)).willReturn(getListPilotosMock().get(1));
	}

	@Test
	public void deveRetornarPiloto() {
		Piloto piloto1 = service.getPiloto(ID_PILOTO_1);
		assertPiloto1(piloto1);
		Piloto piloto2 = service.getPiloto(ID_PILOTO_2);
		assertPiloto2(piloto2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deveValidarIdAoBuscarPiloto() {
		service.getPiloto(null);
	}
	
	@Test
	public void deveListarPilotos() {
		List<Piloto> pilotos = service.listarPilotos();
		assertListaDePilotos(pilotos);
		
	}
	
	private List<Piloto> getListPilotosMock() {
		Piloto piloto1 = new PilotoBuilder()
				.withId(ID_PILOTO_1)
				.withNome(NOME_PILOTO_1)
				.withDocumento(DOCUMENTO_PILOTO_1)
				.withCma(CMA_PILOTO_1)
				.withHorasDeVoo(HORAS_DE_VOO_PILOTO_1)
				.create();
		
		Piloto piloto2 = new PilotoBuilder()
				.withId(ID_PILOTO_2)
				.withNome(NOME_PILOTO_2)
				.withDocumento(DOCUMENTO_PILOTO_2)
				.withCma(CMA_PILOTO_2)
				.withHorasDeVoo(HORAS_DE_VOO_PILOTO_2)
				.create();
		
		return Arrays.asList(piloto1, piloto2);
	}

	private void assertPiloto2(Piloto piloto2) {
		assertThat(piloto2.getId()).isNotNull();
		assertThat(piloto2.getId()).isEqualTo(ID_PILOTO_2);
		assertThat(piloto2.getNome()).isEqualTo(NOME_PILOTO_2);
		assertThat(piloto2.getDocumento()).isEqualTo(DOCUMENTO_PILOTO_2);
		assertThat(piloto2.getCma()).isEqualTo(CMA_PILOTO_2);
		assertThat(piloto2.getHorasDeVoo()).isEqualTo(HORAS_DE_VOO_PILOTO_2);		
	}

	private void assertPiloto1(Piloto piloto1) {
		assertThat(piloto1.getId()).isNotNull();
		assertThat(piloto1.getId()).isEqualTo(ID_PILOTO_1);
		assertThat(piloto1.getNome()).isEqualTo(NOME_PILOTO_1);
		assertThat(piloto1.getDocumento()).isEqualTo(DOCUMENTO_PILOTO_1);
		assertThat(piloto1.getCma()).isEqualTo(CMA_PILOTO_1);
		assertThat(piloto1.getHorasDeVoo()).isEqualTo(HORAS_DE_VOO_PILOTO_1);
	}

	private void assertListaDePilotos(List<Piloto> pilotos) {
		assertThat(pilotos).isNotNull();
		assertThat(pilotos.size()).isEqualTo(2);
		assertPiloto1(pilotos.get(0));
		assertPiloto2(pilotos.get(1));		
	}
}
