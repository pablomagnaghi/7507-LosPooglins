package modelo.bloque;

import modelo.pooglin.Pooglin;
import modelo.utils.Sentido;
import modelo.utils.Coordenadas;
import modelo.utils.Posicion;


public class BloqueTunelElectro extends Bloque {
	
	private Sentido sentido;
	
	public Sentido getSentido() {
		return sentido;
	}

	public void setSentido(Sentido sentido) {
		this.sentido = sentido;
	}

	private static final long serialVersionUID = 8552719052347031604L;

	
	public void lateralAPooglin(Pooglin pooglin) {
		if (pooglin.getSentido()== this.sentido){
			subir(pooglin);
		}else{
			pooglin.rebotar();
		}
	}
	
	public void bajoPooglin(Pooglin pooglin){
		pooglin.detenerCaida();
		pooglin.resetVelocidad();
	}
	
	public void subir(Pooglin pooglin){
		Coordenadas coo = pooglin.getNivel().aCoordenadas(pooglin.getPosicion());
		Posicion pos;
		if (this.sentido.factor==1){
			coo.setI(coo.getI()+1);
			coo.setJ(coo.getJ()-1);
			pos = nivel.aPosicion(coo);
		}else
		{
			coo.setI(coo.getI()-1);
			coo.setJ(coo.getJ()-1);
			pos=nivel.aPosicion(coo);
			pos.setX(pos.getX()+5);
		}
		
		pooglin.setPosicion(pos);
		
	}
	
	public String getNombre(){
		if (this.sentido.factor ==1) return "BloqueTunelElectro-derecha";
		else return "BloqueTunelElectro-izquierda";	
	}

}
