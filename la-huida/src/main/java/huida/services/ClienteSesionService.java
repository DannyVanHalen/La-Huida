package huida.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Component;

import huida.entities.Cliente;
import huida.repositories.ClienteRepository;


@Component
public class ClienteSesionService {

	
	@Autowired
	private ClienteRepository repo_client;
	
	
	public List<Cliente> findAll(){
		return this.repo_client.findAll();
	}
	
	public Cliente findById(Long id){
		return this.repo_client.findOne(id);
	}
	
	public List<Cliente> findByNombre(String nombre){
		return this.repo_client.findByNombre(nombre);
	}
		
	public List<Cliente> findByEdad(int edad){
		return this.repo_client.findByEdad(edad);
	}

	public List<Cliente> findBySatisfaccion(int satisfaccion){
		return this.repo_client.findBySatisfaccion(satisfaccion);
	}
	
	/** Operaciones de lectura/escritura (E/S) **/
	public void save(Cliente cliente){
		this.repo_client.save(cliente);
	}
	
	public void delete(Cliente cliente){
		this.repo_client.save(cliente);
	}
	
	
	/** Operacion de comprobacion **/
	public boolean exists(Long id){
		return this.repo_client.exists(id);
	}
	
	public Cliente login(Cliente cliente){
		return this.repo_client.findByEmailAndPass(cliente.getEmail(), cliente.getPass());
	}
	
}
