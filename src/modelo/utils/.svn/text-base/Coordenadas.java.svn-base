package modelo.utils;

import java.io.Serializable;

public class Coordenadas implements Serializable {

	private static final long serialVersionUID = 7667253898584496700L;
	
	private Integer i, j;
	
	public Coordenadas (Integer i, Integer j){
		this. i = i;
		this.j = j;
	}

	public Integer getI() {
		return i;
	}

	public void setI(Integer i) {
		this.i = i;
	}

	public Integer getJ() {
		return j;
	}

	public void setJ(Integer j) {
		this.j = j;
	}
	
	public Coordenadas clonar(){
		return new Coordenadas(this.i, this.j);
	}
	
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Coordenadas){
			Coordenadas that = (Coordenadas) obj;
			if (this.getI().equals(that.getI()) && this.getJ().equals(that.getJ()))
				return true;
		}
		return false;
	}

}
