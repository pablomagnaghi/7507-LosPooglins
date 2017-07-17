package modelo.pooglin.habilidad;


import modelo.bloque.BloquePooglinCongelado;
import modelo.pooglin.Pooglin;
import modelo.utils.Coordenadas;


public class Congelamiento extends Habilidad{
	private static final long serialVersionUID = -5880578075534049442L;

	public Congelamiento() {
		super();
	}
	
	public Congelamiento(Pooglin pooglin) {
		super(pooglin);
	}

	public Pooglin accion() {
		Coordenadas coords = getNivel().aCoordenadas(pooglin.getPosicion());
		if (getNivel().getBloque(coords) == null){
			pooglin.morir();
			BloquePooglinCongelado pooglinCongelado = new BloquePooglinCongelado();
			pooglinCongelado.setCoordenadas(coords);
			getNivel().crearBloque(pooglinCongelado);
			return null;
		} else {
			desplazar();
			return pooglin;
		}
	}
}
