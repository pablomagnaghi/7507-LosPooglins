package modelo.utils;

import java.io.Serializable;

public enum Sentido implements Serializable{
	IZQUIERDA(-1),
	DERECHA(1);

	public final Integer factor;
	
	private Sentido(Integer num){
		this.factor = num;
	}
	
	public Sentido inversa(){
		if (this.equals(Sentido.IZQUIERDA)) return Sentido.DERECHA;
		return Sentido.IZQUIERDA;
	}
}
