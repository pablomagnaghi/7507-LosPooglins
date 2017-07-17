package modelo.pooglin.habilidad;

import static modelo.nivel.Constantes.POOGLIN_CAIDA_MAXIMA;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import modelo.nivel.Constantes;
import modelo.nivel.Nivel;
import modelo.nivel.Propiedades;
import modelo.pooglin.Pooglin;
import modelo.utils.Coordenadas;
import modelo.utils.Posicion;

public abstract class Habilidad implements Serializable {
	
	private static List<Class<? extends Habilidad>> subclases;
	
	public static void init(){
		subclases = new ArrayList<Class<? extends Habilidad>>();

		subclases.add(Congelamiento.class);
		subclases.add(PlatilloVolador.class);
		subclases.add(RayoLaser.class);
		subclases.add(TaladroUltrasonico.class);
		subclases.add(Teletransportacion.class);
		subclases.add(TunelElectromagnetico.class);
	}
	
	public static List<Class<? extends Habilidad>> getHabilidades(){
		return Collections.unmodifiableList(subclases);
	}

	private static final long serialVersionUID = -1514372072746000424L;

	protected Pooglin pooglin;
	
	protected Integer velocidadCaida;
		
	public Habilidad (){
		velocidadCaida = Constantes.POOGLIN_DEFAUT_VALOCIDAD_CAIDA;
	}
	
	public Habilidad (Pooglin pooglin){
		this.pooglin = pooglin;
		velocidadCaida = Constantes.POOGLIN_DEFAUT_VALOCIDAD_CAIDA;
	}
	
	public void setCayendo(){
		if (! pooglin.isCayendo()) 
			pooglin.setContadorCaida(0);
	}
	
	public void detenerCaida(){
		if (pooglin.isCayendo() && pooglin.getContadorCaida() >= 
				POOGLIN_CAIDA_MAXIMA * getPropiedades().getAltoBloque()) pooglin.morir();
		pooglin.setContadorCaida(null);
	}
	
	public void rebotar(){
		pooglin.setSentido(pooglin.getSentido().inversa());
	}

	public void desplazar(){
		if(! pooglin.isCayendo()) desplazarHorizontal();
		else desplazarVertical();
	}

	protected void desplazarVertical() {
		Posicion pos = pooglin.getPosicion().clonar();
		//nueva pos, le sumo la altura del pooglin porque la posicion es relativa a la esquina sup-izq
		pos.setY(pos.getY() + velocidadCaida + pooglin.getAlto());
		
		//Coordenadas para saber si se superpone el pooglin con un bloque
		Coordenadas coords = getNivel().aCoordenadas(pos);
		
		//Si hay un bloque
		if (! getNivel().estaDentroDeLimites(coords) || ! getNivel().estaVacia(coords) )
			//Uso la posicion mas cercana posible al bloque: pos de esquina sup -1
			pos.setY(getNivel().aPosicion(coords).getY() - 1);
					
		//Resto la altura
		pos.setY(pos.getY() - pooglin.getAlto());
		pooglin.setPosicion(pos);
		
		pooglin.setContadorCaida(pooglin.getContadorCaida() + velocidadCaida);
	}

	protected void desplazarHorizontal() {
		Integer desplazamiento = pooglin.getSentido().factor * pooglin.getFactorVelocidad() * 
				Constantes.POOGLIN_DEFAUT_VELOCIDAD_HORIZONTAL;

		//Distancia desde lateral
		Integer distRelPos = Math.max(0, pooglin.getSentido().factor * pooglin.getAncho());
		
		Posicion pos = pooglin.getPosicion().clonar();

		pos.setX(pos.getX() + desplazamiento + distRelPos);
		
		//Coordenadas para saber si se superpone el pooglin con un bloque
		Coordenadas coords = getNivel().aCoordenadas(pos);
		
		//Si hay un bloque
		if (! getNivel().estaDentroDeLimites(coords))
			rebotar();
	
		//Resto la dist relativa al lateral
		pos.setX(pos.getX() - distRelPos);
		pooglin.setPosicion(pos);
	}
	
	protected Nivel getNivel(){
		return pooglin.getNivel();
	}
	
	protected Propiedades getPropiedades(){
		return getNivel().getPropiedades();
	}
	
	public abstract Pooglin accion();

	public String getNombre() {
		if (pooglin.isCayendo())
			return "cayendo";
		else 
			return (getClass().getSimpleName() + "-" + pooglin.getSentido().name()).toLowerCase();
	}

	public void setPooglin(Pooglin pooglin) {
		this.pooglin = pooglin;
		pooglin.setHabilidad(this);
	}
	
}
