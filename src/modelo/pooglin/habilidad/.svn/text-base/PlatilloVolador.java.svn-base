package modelo.pooglin.habilidad;

import modelo.nivel.Constantes;
import modelo.pooglin.Pooglin;

public class PlatilloVolador extends Caminar {

	private static final long serialVersionUID = 9175520989610318086L;
	
	public PlatilloVolador() {
		super();
		velocidadCaida = Constantes.POOGLIN_VELOCIDAD_CAIDA_LENTA;
	}

	public PlatilloVolador(Pooglin pooglin) {
		super(pooglin);
		velocidadCaida = Constantes.POOGLIN_VELOCIDAD_CAIDA_LENTA;
	}
	
	public void detenerCaida() {
		pooglin.setContadorCaida(null);
	}
	
	public String getNombre() {
		if (pooglin.isCayendo())
			return "platillovolador-" + pooglin.getSentido().name().toLowerCase();
		return ("caminar" + "-" + pooglin.getSentido().name()).toLowerCase();
	}
}
