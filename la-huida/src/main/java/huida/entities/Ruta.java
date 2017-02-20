package huida.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ruta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; // clave primaria
	
	private Lugar inicio;
	private Lugar destino;
	
	
	public Ruta(){}
	
	public Ruta(Lugar inicio, Lugar destino){
		this.inicio = inicio;
		this.destino = destino;
	}

	public Lugar getInicio() {
		return inicio;
	}

	public void setInicio(Lugar inicio) {
		this.inicio = inicio;
	}

	public Lugar getDestino() {
		return destino;
	}

	public void setDestino(Lugar destino) {
		this.destino = destino;
	}
	
	@Override
	public String toString(){
		return "Ruta[Inicio: "+this.inicio.toString()+"\nDestino: "+this.destino.toString()+" ]";
	}
	
}
