package huida.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Actividad {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; // clave primaria
	
	private String nombre;
	private String fecha;
	private Lugar lugar;
	
	@OneToOne
	private Monitor monitor;
	
	private AtomicInteger plazas;
	
	@OneToMany
	private CopyOnWriteArrayList<Cliente> inscritos;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Ruta> rutas;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Valoracion> valoraciones;
	private int valoracion;
	
	public Actividad(){}
	
	public Actividad(String nombre, String fecha, Lugar lugar, Monitor monitor, int plazas){
	
		this.nombre = nombre;
		this.fecha = fecha;
		this.lugar = lugar;
		this.monitor = monitor;
		this.plazas = new AtomicInteger(plazas);
		this.inscritos = new CopyOnWriteArrayList<Cliente>();
		this.rutas = new ArrayList<Ruta>();
		this.valoraciones = new ArrayList<Valoracion>();
		this.valoracion = 0;
	
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

	public AtomicInteger getPlazas() {
		return plazas;
	}

	public void setPlazas(AtomicInteger plazas) {
		this.plazas = plazas;
	}

	public CopyOnWriteArrayList<Cliente> getInscritos() {
		return inscritos;
	}

	public void setInscritos(CopyOnWriteArrayList<Cliente> inscritos) {
		this.inscritos = inscritos;
	}

	public List<Ruta> getRutas() {
		return rutas;
	}

	public void setRutas(List<Ruta> rutas) {
		this.rutas = rutas;
	}

	public List<Valoracion> getValoraciones() {
		return valoraciones;
	}

	public void setValoraciones(List<Valoracion> valoraciones) {
		this.valoraciones = valoraciones;
	}

	public int getValoracion_media() {
		return valoracion;
	}

	public void setValoracion_media(int valoracion_media) {
		this.valoracion = valoracion_media;
	}
	
	@Override
	public String toString(){
		return "Actividad[Nombre:"+this.nombre+"\nLugar: "+this.lugar.toString()+"\nFecha: "
				+this.fecha+"\nMonitor: "+this.monitor.getNombre()+"\nInscritos: "+this.inscritos.toString()+
				"\n Plazas Libres: "+this.plazas.get()+" ]";
	}
	
	private boolean esta_inscrito(Cliente cliente){
		boolean inscrito = false;
		for(Cliente c: this.inscritos){
			inscrito = c.equals(cliente);
		}
		return inscrito;
	}
	
	public boolean inscribir_usuario(Cliente cliente){
		if(this.plazas.get() > 0){
			if(!this.esta_inscrito(cliente)){
				this.plazas.getAndDecrement();
				return this.inscritos.add(cliente);
			}
		}
		return false;
	}
	
	public boolean quitar_usuario(Cliente cliente){
		if(this.inscritos.size() != 0 ){
			this.plazas.getAndIncrement();
			return this.inscritos.remove(cliente);
		}
		return false;
	}
	
	public void añadirValoración(Cliente cliente, int actividad, int monitor){
		Valoracion valoracion = new Valoracion(cliente.getId(),this.id,actividad,monitor);
		cliente.añadirValoracion(valoracion);
		this.valoraciones.add(valoracion);
	}
	
	public void calcula_valoracion(){
		int val = 0;
		for(Valoracion v: this.valoraciones){
			val += v.getValoracion_actividad();
		}
		
		this.valoracion = val/this.valoraciones.size();
	}
	
	
}
