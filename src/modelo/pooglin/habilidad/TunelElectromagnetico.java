package modelo.pooglin.habilidad;

import modelo.pooglin.Pooglin;
import modelo.bloque.BloqueTunelElectro;
import modelo.utils.*;


public class TunelElectromagnetico extends Habilidad{

	private static final long serialVersionUID = 955271312190282441L;
	
	public TunelElectromagnetico(){
		super();
	}

	public TunelElectromagnetico(Pooglin pooglin) {
		super(pooglin);
	}

	public Pooglin accion() {
		
			if (!pooglin.isCayendo()){
				Posicion pos = pooglin.getPosicion();
				Coordenadas coo1 = pooglin.getNivel().aCoordenadas(pos);
				
				coo1.setI(coo1.getI() + pooglin.getSentido().factor * 1);
				Coordenadas coo2 = coo1.clonar();
				
				if (getNivel().getBloque(coo1) == null){
					BloqueTunelElectro tunel1 = new BloqueTunelElectro();
					tunel1.setCoordenadas(coo1);
					tunel1.setSentido(pooglin.getSentido());
					getNivel().crearBloque(tunel1);
					pooglin.setHabilidad(new Caminar(pooglin));
				} else {
					desplazar();
				}
				
				coo2.setI(coo1.getI() + pooglin.getSentido().factor * 1);
				coo2.setJ(coo1.getJ()-1);
				
				if (getNivel().getBloque(coo2) == null){
					BloqueTunelElectro tunel2 = new BloqueTunelElectro();
					tunel2.setCoordenadas(coo2);
					tunel2.setSentido(pooglin.getSentido());
					getNivel().crearBloque(tunel2);
					pooglin.setHabilidad(new Caminar(pooglin));
				} else {
					desplazar();
				}
			}
			
			return pooglin;
		}
}