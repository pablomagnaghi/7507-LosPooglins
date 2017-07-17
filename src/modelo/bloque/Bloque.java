package modelo.bloque;

import modelo.Elemento;
import modelo.nivel.Nivel;
import modelo.pooglin.Pooglin;
import modelo.utils.Coordenadas;
import modelo.utils.Posicion;


public abstract class Bloque implements Elemento{
	private static final long serialVersionUID = -1262839672204215084L;

	protected Coordenadas coordenadas;
	
	protected Nivel nivel;
	
	protected boolean destruido = false;
	
	public void bajoPooglin(Pooglin pooglin){
		pooglin.detenerCaida();
		pooglin.resetVelocidad();
	}
	
	public void lateralAPooglin(Pooglin pooglin){
		pooglin.rebotar();
	}
	
	public Coordenadas getCoordenadas() {
		return coordenadas;
	}

	public Bloque setCoordenadas(Coordenadas coordenadas) {
		this.coordenadas = coordenadas;
		return this;
	}
	
	public Bloque setCoordenadas(Integer i, Integer j) {
		this.coordenadas = new Coordenadas(i, j);
		return this;
	}

	public Bloque setNivel(Nivel nivel) {
		this.nivel = nivel;
		return this;
	}
	
	public void impacto(){}
	
	public Posicion getPosicion() {
		return nivel.aPosicion(coordenadas);
	}
	
	public String getNombre() {
		return getClass().getSimpleName();
	}
	
	public Integer getAncho() {
		return nivel.getPropiedades().getAnchoBloque();
	}
	
	public Integer getAlto() {
		return nivel.getPropiedades().getAltoBloque();
	}

	public void setDestruido() {
		destruido = true;
	}

	public boolean isDestruido() {
		return destruido;
	}	
}
