package modelo.bloque;

import static modelo.nivel.Constantes.BLOQUE_CANTIDAD_IMPACTOS;

public class BloqueTierra extends Bloque {
	
	private static final long serialVersionUID = 8801142529566292343L;
	
	protected Integer impactos = 0;
	
	public void impacto(){
		impactos++;
		if (impactos >= BLOQUE_CANTIDAD_IMPACTOS)
			nivel.destruirBloque(this);
	}

}
