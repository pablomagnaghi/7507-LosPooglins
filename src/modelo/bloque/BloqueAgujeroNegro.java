package modelo.bloque;

import modelo.pooglin.Pooglin;

public class BloqueAgujeroNegro extends Bloque{

	private static final long serialVersionUID = -6589993190968308084L;

	public void lateralAPooglin(Pooglin pooglin) {
		pooglin.morir();
	}

	public void bajoPooglin(Pooglin pooglin) {
		pooglin.morir();
	}
}
