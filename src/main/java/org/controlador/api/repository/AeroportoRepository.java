package org.controlador.api.repository;

import org.controlador.api.domain.Piloto;

public interface AeroportoRepository {

	public Piloto findById(Long id);
}