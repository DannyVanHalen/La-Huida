package huida.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import huida.repositories.MonitorRepository;
import huida.entities.Monitor;

@Component
public class MonitorSesionService {

	@Autowired
	private MonitorRepository repo_monitor;
	
	public Monitor findById(Long id){
		return this.repo_monitor.findOne(id);
	}
	
	public List<Monitor> findAll(){
		return this.repo_monitor.findAll();
	}
	
	public List<Monitor> findByEdad(int edad){
		return this.repo_monitor.findByEdad(edad);
	}
	
	public List<Monitor> findByValoracion(int valoracion){
		return this.repo_monitor.findByValoracion(valoracion);
	}
	
	/** Operaciones E/S**/
	public void save(Monitor monitor){
		this.repo_monitor.save(monitor);
	}
	
	public void delete(Monitor monitor){
		this.repo_monitor.delete(monitor);
	}
	
	/** login **/
	public Monitor login(String email, String pass){
		return this.repo_monitor.findByEmailAndPass(email, pass);
	}
	
	
	
}
