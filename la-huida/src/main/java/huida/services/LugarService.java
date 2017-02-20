package huida.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import huida.repositories.LugarRepository;
import huida.entities.Lugar;

@Component
public class LugarService {

	@Autowired
	private LugarRepository repo_lugar;
	
	
	public Lugar findById(Long id){
		return this.repo_lugar.findOne(id);
	}
	
	public Lugar findByLugar(String lugar){
		return this.repo_lugar.findByLugar(lugar);
	}
	
	public List<Lugar> findAll(){
		return this.repo_lugar.findAll();
	}
	
	public List<Lugar> findByRegion(String region){
		return this.repo_lugar.findByRegion(region);
	}
	
	public List<Lugar> findByPais(String pais){
		return this.repo_lugar.findByPais(pais);
	}
	
	/** Operaciones E/S**/
	public void save(Lugar lugar){
		this.repo_lugar.save(lugar);
	}
	
	public void delete(Lugar lugar){
		this.repo_lugar.delete(lugar);
	}
	
	
}
