package huida.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import huida.entities.Monitor;

public interface MonitorRepository extends JpaRepository<Monitor, Long>{

	//Monitor findByNombre(String nombre);
	Monitor findByEmailAndPass (String email, String pass);
	List<Monitor> findAll();
	List<Monitor> findByEdad(int edad);
	List<Monitor> findByValoracion(int valoracion);
	
}
