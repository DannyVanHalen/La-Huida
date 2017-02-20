package huida.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import huida.entities.Lugar;
import huida.entities.Ruta;
import huida.repositories.RutaRepository;

@Component
public class RutaService {

	@Autowired
	private RutaRepository repo_ruta;
	
	public Ruta findById(Long id){
		return this.repo_ruta.findOne(id);
	}
	
	public List<Ruta> findByInicio(Lugar inicio){
		return this.repo_ruta.findByInicio(inicio);
	}
	
	public List<Ruta> findByDestino(Lugar destino){
		return this.repo_ruta.findByInicio(destino);
	}
	
	/** Operaciones E/S**/
	public void save(Ruta ruta){
		this.repo_ruta.save(ruta);
	}
	
	public void delete(Ruta ruta){
		this.repo_ruta.delete(ruta);
	}
	
	
	
}
