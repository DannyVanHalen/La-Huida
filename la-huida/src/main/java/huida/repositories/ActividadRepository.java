package huida.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import huida.entities.Actividad;
import huida.entities.Lugar;
import huida.entities.Monitor;

public interface ActividadRepository extends JpaRepository<Actividad,Long> {
	
	Actividad findByNombre(String nombre);
	List<Actividad> findActividades();
	List<Actividad> findAll();
	List<Actividad> findByMonitor(Monitor monitor);
	List<Actividad> findByLugar(Lugar lugar);
	List<Actividad> findByFecha(String fecha);
	List<Actividad> findByValoracion(int valoracion);
	
}
