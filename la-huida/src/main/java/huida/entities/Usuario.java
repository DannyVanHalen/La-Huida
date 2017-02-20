package huida.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; // clave primaria
	
	private String nombre;
	private String pass;
	private String email;
	private String rol;
	private int edad;
	
	public Usuario(){}
	
	public Usuario(String nombre, String pass, String email, String rol ,int edad){
		this.nombre = nombre;
		this.pass = pass;
		this.email = email;
		this.rol = rol;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@Override
	public String toString(){
		return "Nombre: "+this.nombre+" Email: "+this.email+" Categoria: "+this.rol+" Edad:"+this.edad;
	}
	
	
	
	
}
