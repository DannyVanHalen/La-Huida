package huida.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import huida.entities.Lugar;
import huida.entities.Ruta;

public interface RutaRepository extends JpaRepository<Ruta,Long> {

	List<Ruta> findAll();
	List<Ruta> findByInicio(Lugar inicio);
	List<Ruta> findByDestino(Lugar destino);
	
	
}

