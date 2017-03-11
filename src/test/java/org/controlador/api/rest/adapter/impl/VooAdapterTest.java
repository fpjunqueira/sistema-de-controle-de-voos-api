package org.controlador.api.rest.adapter.impl;

import static org.junit.Assert.fail;

import org.controlador.api.domain.Voo;
import org.controlador.api.rest.dto.VooDTO;
import org.junit.Test;
import org.mockito.Mock;

public class VooAdapterTest {
	
	@Mock
	private Voo domain;
	
	@Mock
	private VooDTO dto;
	
	@Mock
	private VooAdapter adapter ;
	
	@Test
	public void deveAdaptarVooDTOParaVooDomain() {
		fail("Not yet implemented");
	}
	
	@Test
	public void deveAdaptarVooDomainParaVooDTO() {
		fail("Not yet implemented");
	}

	@Test
	public void deveAdaptarListVooDTOParaListVooDomain() {
		fail("Not yet implemented");
	}
	
	@Test
	public void deveAdaptarListVooDomainParaListVooDTO() {
		fail("Not yet implemented");
	}
}
