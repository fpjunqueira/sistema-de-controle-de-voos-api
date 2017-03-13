package org.controlador.api.repository;

import org.controlador.api.domain.Aviao;
import org.controlador.api.domain.Piloto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AviaoRepository extends JpaRepository<Aviao, Long>{
	
	public Piloto findById(Long id);

}
