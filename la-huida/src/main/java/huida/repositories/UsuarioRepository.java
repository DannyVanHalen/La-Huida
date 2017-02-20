package huida.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import huida.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	List<Usuario> findAll();
	List<Usuario> findByRol(String rol);
	
}
