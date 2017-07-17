package modelo.utils;

import java.io.Serializable;

public class Posicion  implements Serializable{

	private static final long serialVersionUID = -6089532953676260177L;
	
	private Integer x, y;
	
	public Posicion(Integer x, Integer y){
		this.x = x;
		this.y = y;
	}
	
	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}
	
	public Posicion clonar(){
		return new Posicion(this.x, this.y);
	}
	
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Posicion){
			Posicion that = (Posicion) obj;
			if (this.getX().equals(that.getX()) && this.getY().equals(that.getY()))
				return true;
		}
		return false;
	}
	
	

}
