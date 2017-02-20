package huida.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import huida.entities.Lugar;

public interface LugarRepository extends JpaRepository<Lugar, Long> {

	Lugar findByLugar(String lugar);
	List<Lugar> findAll();
	List<Lugar> findByRegion(String region);
	List<Lugar> findByPais(String pais);
	
}
