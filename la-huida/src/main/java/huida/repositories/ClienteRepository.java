package huida.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import huida.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Cliente findByEmailAndPass(String email, String pass);
	List<Cliente> findByNombre(String nombre);
	List<Cliente> findAll();
	List<Cliente> findByEdad(int edad);
	List<Cliente> findBySatisfaccion(int satisfaccion);
	
}
