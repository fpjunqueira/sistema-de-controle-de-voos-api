package org.controlador.api.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.BDDMockito.given;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.controlador.api.domain.Voo;
import org.controlador.api.repository.VooRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class VooServiceTest {
	
	private static final Long ID = 1L;

	@MockBean
	private VooRepository repository;
	
	@Autowired
	private VooService service;

	@Before
	public void init() {
		given(this.repository.findAll()).willReturn(getListaDeVoosMock());
		given(this.repository.findById(ID)).willReturn(getVooMock());
		given(this.repository.findByHorarios(getDataDecolagemMock(), getDataPousoMock()));
	}
	
	private LocalDateTime getDataPousoMock() {
		// TODO Auto-generated method stub
		return null;
	}

	private LocalDateTime getDataDecolagemMock() {
		// TODO Auto-generated method stub
		return null;
	}

	private Voo getVooMock() {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Voo> getListaDeVoosMock() {
		List<Voo> voos = new ArrayList<Voo>();
		
		Voo voo = new Voo();
		return voos;
	}

	@Test
	public void deveListarVoos() {
		List<Voo> voos = service.listarVoos();
		
		assertThat(voos).isNotNull();
		assertThat(voos.size()).isEqualTo(2);
		
		assertThat(voos.get(1).getId()).isEqualTo(ID);
	}
	
	@Test
	public void deveListarVoosPorHorario() {
		fail("Not yet implemented");
	}

	@Test(expected = IllegalArgumentException.class)

	public void deveValidarDataDecolagemMainsQueDataPouso() {
		fail("Not yet implemented");
	}
	
	@Test
	public void deveValidarDecolagemOgrigatoio() {
		fail("Not yet implemented");
	}
	
	@Test
	public void deveValidarPousoObrigatorio() {
		fail("Not yet implemented");
	}
	
	
	@Test
	public void deveRetornarVoo() {
		fail("Not yet implemented");
	}
	
}
