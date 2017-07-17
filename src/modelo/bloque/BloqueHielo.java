package modelo.bloque;

import modelo.pooglin.Pooglin;

public class BloqueHielo extends Bloque {

	private static final long serialVersionUID = -6573506071373156254L;

	public void bajoPooglin(Pooglin pooglin) {
		super.bajoPooglin(pooglin);
		pooglin.duplicarVelocidad();
	}
}
