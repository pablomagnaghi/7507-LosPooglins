package modelo.pooglin.habilidad;

import modelo.nivel.Constantes;
import modelo.pooglin.Pooglin;
import modelo.utils.Coordenadas;
import modelo.utils.Posicion;

public class Teletransportacion extends Habilidad {
	private static final long serialVersionUID = -4435599163223053084L;

	private Integer pasos = 0;
	
	public Teletransportacion() {
		super();
	}

	public Teletransportacion(Pooglin pooglin) {
		super(pooglin);
	}

	public Pooglin accion() {
		desplazar();
		if (pasos >= Constantes.POOGLIN_PASOS_TRANSPORTACION){
			Posicion pos = pooglin.getPosicion().clonar();
			pos.setX(pos.getX() + pooglin.getSentido().factor * Constantes.POOGLIN_DISTANCIA_TRANSPORTACION);

			//evita que se ubique el pooglin fuera de la pantalla o dentro de un bloque 
			Coordenadas coords = getNivel().aCoordenadas(pos); 
			while (! getNivel().estaDentroDeLimites(coords) || ! getNivel().estaVacia(coords)) {
				coords.setI(coords.getI() - pooglin.getSentido().factor * 1);
			}

			pos = getNivel().aPosicion(coords);
			pooglin.setPosicion(pos);
			
			pooglin.setHabilidad(new Caminar(pooglin));
		}
		
		return pooglin;
	}
	
	protected void desplazarHorizontal() {
		super.desplazarHorizontal();
		pasos++;
	}
}
