package org.controlador.api.repository;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.controlador.api.domain.Voo;
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

	@Autowired
	private VooRepository repository;
	private Date partida;
	private Date chegada;
	
	@Test
	public void deveBuscarListaDeVoosPorHorarioDeDecolagemEPouso() {
		List<Voo> findByHorarios = repository.findByHorarios(partida, chegada);
		assertTrue(assertListaPorHorarios(findByHorarios));
	}

	private boolean assertListaPorHorarios(List<Voo> findByHorarios) {
		return false;
	}
	
	

}
