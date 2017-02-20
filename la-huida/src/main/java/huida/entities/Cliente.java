package huida.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; // clave primaria
	
	private String nombre;
	private String pass;
	private String email;
	private String rol;
	private int edad;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Valoracion> valoraciones;
	private int satisfaccion;
	
	public Cliente(){}
	
	public Cliente(String nombre, String pass, String email, String rol, int edad){
		//super(nombre, pass, email,rol,edad);
		this.nombre = nombre;
		this.pass = pass;
		this.email = email;
		this.rol = rol;
		this.edad = edad;
		this.valoraciones = new ArrayList<Valoracion>();
		this.satisfaccion = 0;
	}

	public List<Valoracion> getValoraciones() {
		return valoraciones;
	}

	public void setValoraciones(List<Valoracion> valoraciones) {
		this.valoraciones = valoraciones;
	}

	public int getGrado_satisfaccion() {
		return satisfaccion;
	}

	public void setGrado_satisfaccion(int grado_satisfaccion) {
		this.satisfaccion = grado_satisfaccion;
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

	public int getSatisfaccion() {
		return satisfaccion;
	}

	public void setSatisfaccion(int satisfaccion) {
		this.satisfaccion = satisfaccion;
	}

	public boolean añadirValoracion(Valoracion valoracion){
		return this.valoraciones.add(valoracion);
	}
	
	
	public String toString(){
		return "Cliente[Nombre: "+this.nombre+" Email: "+this.email+" Categoria: "+this.rol+" Edad:"+this.edad+"\nValoraciones: "+this.valoraciones.toString()+"\nGrado Satisfaccion: "+this.satisfaccion+"]";
	}
	
	public void calcular_satisfaccion(){
		int  med = 0;
		for(Valoracion v: this.valoraciones){
			med += (v.getValoracion_actividad()+v.getValoracion_monitor())/2;
		}
		this.satisfaccion = med/this.valoraciones.size();
	}
	
}
