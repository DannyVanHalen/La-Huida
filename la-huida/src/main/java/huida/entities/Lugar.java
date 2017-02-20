package huida.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lugar {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; // clave primaria
	
	private String lugar;
	private String region;
	private String pais;
	
	public Lugar(){}
	
	public Lugar(String lugar, String region, String pais){
		this.lugar = lugar;
		this.region = region;
		this.pais = pais;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	@Override
	public String toString(){
		return "Lugar[Lugar: "+this.lugar+" Region: "+this.region+" Pais: "+this.pais+" ]";
	}
	
	
}
