package huida.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Valoracion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; // clave primaria
	
	private Long idCliente;
	private Long idActividad;
	private int valoracion_actividad;
	private int valoracion_monitor;
	
	public Valoracion(){}
	
	public Valoracion(Long idCliente, Long idActividad ,int valoracion_actividad, int valoracion_monitor){
		this.idCliente = idCliente;
		this.idActividad = idActividad;
		this.valoracion_actividad = valoracion_actividad;
		this.valoracion_monitor = valoracion_monitor;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}

	public int getValoracion_actividad() {
		return valoracion_actividad;
	}

	public void setValoracion_actividad(int valoracion_actividad) {
		this.valoracion_actividad = valoracion_actividad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getValoracion_monitor() {
		return valoracion_monitor;
	}

	public void setValoracion_monitor(int valoracion_monitor) {
		this.valoracion_monitor = valoracion_monitor;
	}
	
	/**
	@Override
	public String toString(){
		return "Valoracion[Usuario: "+this.usuario+" Actividad: "+this.valoracion_actividad+" Monitor: "+this.valoracion_monitor+" ]";
	}*/
	
}
