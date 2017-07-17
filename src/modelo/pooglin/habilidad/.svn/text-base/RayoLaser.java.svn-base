package modelo.pooglin.habilidad;

import modelo.bloque.Bloque;
import modelo.nivel.Constantes;
import modelo.pooglin.Pooglin;
import modelo.utils.Coordenadas;
import modelo.utils.Posicion;
import modelo.utils.Sentido;

public class RayoLaser extends Habilidad {

	private static final long serialVersionUID = -6503066915411007043L;
	
	private Integer bloques = 0;
	private Integer impactos = 0;
	
	public RayoLaser() {
		super();
	}
	
	public RayoLaser(Pooglin pooglin) {
		super(pooglin);
	}

	public Pooglin accion() {
		desplazar();
		return pooglin;
	}
	
	@Override
	protected void desplazarHorizontal() {
		Integer desplazamiento = pooglin.getSentido().factor * pooglin.getFactorVelocidad() * 
						Constantes.POOGLIN_DEFAUT_VELOCIDAD_HORIZONTAL;

		Integer distRelPos = Math.max(0, pooglin.getSentido().factor * pooglin.getAncho());
		
		Posicion pos = pooglin.getPosicion().clonar();
		
		pos.setX(pos.getX() + desplazamiento + distRelPos);
		
		Coordenadas coords = getNivel().aCoordenadas(pos);

		if (! getNivel().estaDentroDeLimites(coords))
			pos.setX(getNivel().aPosicion(coords).getX() + (pooglin.getSentido().equals
					(Sentido.DERECHA) ? -1 : getPropiedades().getAnchoBloque()) );
		
		if (! getNivel().estaVacia(coords)) {
			Bloque bloque = getNivel().getBloque(coords);
			bloque.impacto();
			impactos++;
			if (bloque.isDestruido()){
				bloques++;
			}
		} else {
			pos.setX(pos.getX() - distRelPos);
			pooglin.setPosicion(pos);
		}
		
		if (bloques == Constantes.LASER_DESTRUYE_BLOQUES || impactos == Constantes.LASER_IMPACTOS)
			pooglin.setHabilidad(new Caminar(pooglin));
	}
}
	
