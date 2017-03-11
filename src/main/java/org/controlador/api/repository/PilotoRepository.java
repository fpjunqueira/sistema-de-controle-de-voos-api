package org.controlador.api.repository;

import org.controlador.api.domain.Piloto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PilotoRepository extends JpaRepository<Piloto, Long>{
	
	public Piloto findById(Long id);

	public Piloto findByCma(String cma);

}
