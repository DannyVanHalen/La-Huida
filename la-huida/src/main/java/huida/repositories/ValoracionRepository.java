package huida.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import huida.entities.Valoracion;

public interface ValoracionRepository  extends JpaRepository<Valoracion, Long>{

	List<Valoracion> findAll();
	
}
