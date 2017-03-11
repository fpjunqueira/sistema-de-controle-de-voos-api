package org.controlador.api.repository;

import org.controlador.api.domain.Aeroporto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AeroportoRepository extends JpaRepository<Aeroporto, Long> {

	public Aeroporto findById(Long id);
}