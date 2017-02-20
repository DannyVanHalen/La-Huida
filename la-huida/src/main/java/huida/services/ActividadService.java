package huida.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import huida.entities.Actividad;
import huida.entities.Lugar;
import huida.entities.Monitor;
import huida.repositories.ActividadRepository;

@Component
public class ActividadService {

	@Autowired
	private ActividadRepository repo_act;
	
	public Actividad findById(Long id){
		return this.repo_act.findOne(id);
	}
	
	public Actividad findByNombre(String nombre){
		return this.repo_act.findByNombre(nombre);
	}
	
	public List<Actividad> findByMonitor(Monitor monitor){
		return this.repo_act.findByMonitor(monitor);
	}
	
	public List<Actividad> findByLugar(Lugar lugar){
		return this.repo_act.findByLugar(lugar);
	}
	
	public List<Actividad> findByFecha(String fecha){
		return this.repo_act.findByFecha(fecha);
	}
	
	public List<Actividad> findByValoracion(int valoracion){
		return this.repo_act.findByValoracion(valoracion);
	}
	
	public List<Actividad> findAll(){
		return this.repo_act.findAll();
	}
	
	/** Operaciones E/S**/
	public void save(Actividad actividad){
		this.repo_act.save(actividad);
	}
	
	public void delete(Actividad actividad){
		this.repo_act.delete(actividad);
	}
	
	
}
