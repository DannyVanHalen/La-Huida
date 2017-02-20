package huida.entities;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Monitor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; // clave primaria
	
	private String nombre;
	private String pass;
	private String email;
	private String rol;
	private int edad;
	
	@OneToMany
	private List<Actividad> actividades;
	private int valoracion;
	
	public Monitor(){}
	
	public Monitor(String nombre, String pass, String email, String rol, int edad){
		this.nombre = nombre;
		this.pass = pass;
		this.email = email;
		this.rol = rol;
		this.edad = edad;
		this.actividades = new ArrayList<Actividad>();
		this.valoracion = 0;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public List<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(List<Actividad> actividades) {
		this.actividades = actividades;
	}

	public int getValoracion_monitor() {
		return valoracion;
	}

	public void setValoracion_monitor(int valoracion_monitor) {
		this.valoracion = valoracion_monitor;
	}
	
	public String toString(){
		return "Monitor[Nombre: "+this.nombre+" Email: "+this.email+" Categoria: "+this.rol+" Edad:"+this.edad+"\nActividades: "+this.actividades.toString()+"\nValoracion: "+this.valoracion+"]";
	}
	
	public void calcula_valoracion(){
		
		int media_act = 0 , total_acts = 0;
		
		for(Actividad a:this.actividades){
			for(Valoracion v: a.getValoraciones()){
				media_act = (media_act + v.getValoracion_monitor())/a.getValoraciones().size();
			}
			total_acts += media_act;
		}
		
		this.valoracion = total_acts/this.actividades.size();
		
	}
	
}
