package modelo.bloque;

import java.util.Timer;
import java.util.TimerTask;

import main.Juego;
import modelo.nivel.Constantes;
import modelo.pooglin.Pooglin;
import modelo.utils.Coordenadas;

public class BloqueNaveEntrada extends Bloque {
	private static final long serialVersionUID = -7635017714551874086L;

	private static BloqueNaveEntrada instance;
	
	private static Timer timer;
	
	public static BloqueNaveEntrada get(){
		return instance;
	}
	
	public static void reset(){
		if (timer != null) timer.cancel();
		instance = null;
	}
		
	private Integer pooglins = 0;
		
	public BloqueNaveEntrada() {
		super();
		
		instance = this;
		
		timer = new Timer();
		
		TimerTask task = new TimerTask(){
			public void run() {
				if (Juego.getInstance().isIniciado() && ! Juego.getInstance().isPausado())
					if (pooglins < nivel.getPropiedades().getPooglinsTotalNivel()){
						Coordenadas coords = coordenadas.clonar();
						coords.setJ(coords.getJ() + 1);
						if (nivel.estaVacia(coords)) {
							Pooglin nuevo = new Pooglin(nivel);
							nuevo.setPosicion(nivel.aPosicion(coords));
							nivel.agregar(nuevo);
							pooglins++;
						}
					} else {
						timer.cancel();
					}
			}
		};
		
		timer.scheduleAtFixedRate(task, Constantes.POOGLIN_CREATION_RATE / 2, Constantes.POOGLIN_CREATION_RATE);
	}
	
}
